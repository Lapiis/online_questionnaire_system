package edu.nwpu.controller;

import edu.nwpu.domain.Option;
import edu.nwpu.domain.Question;
import edu.nwpu.domain.Questionnaire;
import edu.nwpu.domain.User;
import edu.nwpu.domain.vo.OptionVO;
import edu.nwpu.domain.vo.QuestionDetailsVO;
import edu.nwpu.domain.vo.QuestionnaireDetailsVO;
import edu.nwpu.domain.vo.QuestionnaireListVO;
import edu.nwpu.service.OptionService;
import edu.nwpu.service.QuestionService;
import edu.nwpu.service.QuestionnaireService;
import edu.nwpu.service.UserService;
import edu.nwpu.util.DisplayChart;
import edu.nwpu.util.PaginationSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * 问卷显示相关页面控制器
 *
 * @author dengzhijian
 */
@Controller
public class QuestionnaireController {
  @Autowired private QuestionnaireService questionnaireService;
  @Autowired private QuestionService questionService;
  @Autowired private OptionService optionService;
  @Autowired private UserService userService;

  /**
   * 跳转到用户问卷列表页面
   *
   * @param pageNo
   * @param pageSize
   * @param model
   * @param session
   * @return
   */
  @GetMapping("/user/questionnaire/questionnaireList")
  public String uQnList(
      @RequestParam(value = "pageNo", defaultValue = "1") int pageNo,
      @RequestParam(value = "pageSize", defaultValue = "10") int pageSize,
      Model model,
      HttpSession session) {
    User user = (User) session.getAttribute("user");
    PaginationSupport<Questionnaire> qnList =
        questionnaireService.findPage(pageNo, pageSize, user.getId());
    PaginationSupport<QuestionnaireListVO> questionnaireList =
        QuestionnaireListVO.toQuestionnaireListVO(qnList);
    model.addAttribute("questionnaireList", questionnaireList);
    return "user_quesList";
  }

  /**
   * 提交问卷 等待管理员审批
   *
   * @param id
   * @return
   */
  @GetMapping("/user/questionnaire/post/{id}")
  public String postQuestionnaire(@PathVariable int id) {
    Questionnaire questionnaire = questionnaireService.selectByPrimaryKey(id);
    questionnaire.setStatus(1);
    questionnaireService.updateSelective(questionnaire);
    return "redirect:/user/questionnaire/questionnaireList";
  }

  /**
   * 显示已提交、待审核的问卷列表
   *
   * @param pageNo
   * @param pageSize
   * @param model
   * @return
   */
  @GetMapping("/manage/questionnaire/questionnaireList")
  public String mQnList(
      @RequestParam(value = "pageNo", defaultValue = "1") int pageNo,
      @RequestParam(value = "pageSize", defaultValue = "10") int pageSize,
      Model model) {
    PaginationSupport<Questionnaire> qnList =
        questionnaireService.findAllPageCommit(pageNo, pageSize);
    PaginationSupport<QuestionnaireListVO> questionnaireList =
        QuestionnaireListVO.toQuestionnaireListVO(qnList);
    model.addAttribute("questionnaireList", questionnaireList);
    return "manager_qList";
  }

  /**
   * 根据问卷id获得所有问卷详情
   *
   * @param pageNo
   * @param pageSize
   * @param id
   * @param model
   * @return
   */
  @GetMapping("/manage/checkPage/{id}")
  public String checkPage(
      @RequestParam(value = "pageNo", defaultValue = "1") int pageNo,
      @RequestParam(value = "pageSize", defaultValue = "10") int pageSize,
      @PathVariable int id,
      Model model) {
    QuestionnaireDetailsVO questionnaireDetailsVO = showQuestionnaireDetails(pageNo, pageSize, id);
    model.addAttribute("questionnaireDetails", questionnaireDetailsVO);
    return "qn_check";
  }

  /**
   * 指定用户创建新问卷
   *
   * @param id
   * @return
   */
  @GetMapping("/user/questionnaire/create/{id}")
  public String creatQn(@PathVariable int id) {
    Questionnaire questionnaire = questionnaireService.create(id);
    questionnaire.setTitle("未命名");
    questionnaireService.updateSelective(questionnaire);
    String url = "/user/questionnaire/modify/" + questionnaire.getId();
    return "redirect:" + url;
  }

  /**
   * 修改指定问卷
   *
   * @param pageNo
   * @param pageSize
   * @param qnid
   * @param model
   * @return
   */
  @GetMapping("/user/questionnaire/modify/{qnid}")
  public String modify(
      @RequestParam(value = "pageNo", defaultValue = "1") int pageNo,
      @RequestParam(value = "pageSize", defaultValue = "10") int pageSize,
      @PathVariable int qnid,
      Model model) {
    QuestionnaireDetailsVO questionnaireDetailsVO =
        showQuestionnaireDetails(pageNo, pageSize, qnid);
    model.addAttribute("questionnaireDetails", questionnaireDetailsVO);
    return "qn_setting";
  }

  /**
   * 更新标题
   *
   * @param pageNo
   * @param pageSize
   * @param qnid
   * @param title
   * @param model
   * @return
   */
  @PostMapping("/user/questionnaire/modify/{qnid}")
  public String updateTitle(
      @RequestParam(value = "pageNo", defaultValue = "1") int pageNo,
      @RequestParam(value = "pageSize", defaultValue = "10") int pageSize,
      @PathVariable int qnid,
      @RequestParam String title,
      Model model) {
    // 更新标题
    Questionnaire questionnaire = questionnaireService.selectByPrimaryKey(qnid);
    questionnaire.setTitle(title);
    questionnaireService.updateSelective(questionnaire);
    // 取出问卷vo
    QuestionnaireDetailsVO questionnaireDetailsVO =
        showQuestionnaireDetails(pageNo, pageSize, qnid);
    model.addAttribute("questionnaireDetails", questionnaireDetailsVO);
    return "qn_setting";
  }

  /**
   * 展示指定id问卷详情页
   *
   * @param id
   * @return
   */
  @GetMapping("/user/questionnaire/show/{id}")
  public String showQn(
      @RequestParam(value = "pageNo", defaultValue = "1") int pageNo,
      @RequestParam(value = "pageSize", defaultValue = "10") int pageSize,
      @PathVariable int id,
      Model model) {
    QuestionnaireDetailsVO questionnaireDetailsVO = showQuestionnaireDetails(pageNo, pageSize, id);
    model.addAttribute("questionnaireDetails", questionnaireDetailsVO);
    return "qn_details";
  }

  /**
   * 返回问卷填写页
   *
   * @param id 问卷id
   * @return
   */
  @GetMapping("/questionnaire/{id}")
  public String disPlay(
      @RequestParam(value = "pageNo", defaultValue = "1") int pageNo,
      @RequestParam(value = "pageSize", defaultValue = "10") int pageSize,
      @PathVariable int id,
      Model model) {
    if (questionnaireService.selectByPrimaryKey(id) == null) {
      return "visit_error";
    }
    QuestionnaireDetailsVO questionnaireDetailsVO = showQuestionnaireDetails(pageNo, pageSize, id);
    model.addAttribute("questionnaireDetails", questionnaireDetailsVO);
    return "qn_form";
  }

  /**
   * 记录填写信息
   *
   * @param id
   * @param req
   * @return
   */
  @PostMapping("/questionnaire/{id}")
  public String record(@PathVariable int id, HttpServletRequest req) {
    List<Question> questions = questionService.findAll(id);
    String key; // 存储问题id
    String[] values; // 存储选项id和问答题答案
    for (Question question : questions) {
      key = "answerTo" + question.getId();
      values = req.getParameterValues(key);
      if (question.getType() == 0) {
        List<Option> options = optionService.findAllByQidOrderById(question.getId());
        String ans = options.get(0).getAnswer() + ", " + values[0];
        options.get(0).setAnswer(ans);
      } else {
        for (String optionId : values) {
          optionService.selected(Integer.parseInt(optionId));
        }
      }
    }
    return "qn_form_complete";
  }

  /**
   * 根据问题id，传输统计数据到统计页面
   *
   * @param id
   * @return
   */
  @GetMapping("/user/questionnaire/stats/{id}")
  public String stats(@PathVariable int id, Model model, HttpSession session) throws Exception {
    Question question = questionService.selectByPrimaryKey(id);
    List<OptionVO> optionVOS =
        OptionVO.toList(optionService.findAllByQidOrderById(question.getId()));
    QuestionDetailsVO questionDetailsVO = new QuestionDetailsVO(question, optionVOS);
    String barChart = DisplayChart.getBarChart(session, questionDetailsVO);
    String pieChart = DisplayChart.getPieChart(session, questionDetailsVO);
    model.addAttribute("barChart", barChart);
    model.addAttribute("pieChart", pieChart);
    return "question_stats";
  }

  /**
   * 根据传来的问卷id返回问卷详情（包括问题，选项）
   *
   * @param pageNo
   * @param pageSize
   * @param id
   * @return
   */
  private QuestionnaireDetailsVO showQuestionnaireDetails(int pageNo, int pageSize, int id) {
    List<List<OptionVO>> list = new ArrayList<>();
    Questionnaire questionnaire = questionnaireService.selectByPrimaryKey(id);
    String username = userService.findOne(questionnaire.getUid()).getName();
    PaginationSupport<Question> qList = questionService.findPage(pageNo, pageSize, id);
    for (Question question : qList.getItems()) {
      list.add(OptionVO.toList(optionService.findAllByQidOrderById(question.getId())));
    }
    PaginationSupport<QuestionDetailsVO> qdList =
        QuestionDetailsVO.toQuestionDetailsVO(qList, list);
    return new QuestionnaireDetailsVO(questionnaire, qdList, username);
  }
}
