package edu.nwpu.controller;

import edu.nwpu.domain.Option;
import edu.nwpu.domain.Question;
import edu.nwpu.service.OptionService;
import edu.nwpu.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * 问题控制器
 *
 * @author dengzhijian
 * @version 2.1
 */
@Controller
@RequestMapping("/user/question")
public class QuestionController {
  @Autowired private QuestionService questionService;
  @Autowired private OptionService optionService;

  /**
   * 创建指定问卷id的问题
   *
   * @param pageNo
   * @param pageSize
   * @param id
   * @param model
   * @return
   */
  @PostMapping("/create/{id}")
  public String create(
      @RequestParam(value = "pageNo", defaultValue = "1") int pageNo,
      @RequestParam(value = "pageSize", defaultValue = "10") int pageSize,
      @RequestParam(value = "optionCnt", defaultValue = "4") int optionCnt,
      @RequestParam(value = "qid", defaultValue = "-1") int qid,
      @PathVariable int id,
      @RequestParam int qType,
      @RequestParam String newQuestion,
      Model model) {
    Question question;
    if ("true".equals(newQuestion)) {
      question = questionService.create(id);
      question.setType(qType);
      questionService.update(question);
    } else {
      question = questionService.selectByPrimaryKey(qid);
    }
    model.addAttribute("question", question);
    model.addAttribute("optionCnt", optionCnt);
    return "question_create";
  }

  @GetMapping("/delete/{qnid}/{qid}")
  public String delete(@PathVariable int qnid, @PathVariable int qid) {
    questionService.delete(qid);
    String url = "/user/questionnaire/modify/" + qnid;
    return "redirect:" + url;
  }

  /**
   * 更新指定id问题及创建其选项
   *
   * @param req
   * @param id
   * @param model
   * @return
   */
  @PostMapping("/save/{id}")
  public String saveQuestion(HttpServletRequest req, @RequestParam String description, @PathVariable int id, Model model) {

    // question更新
    Question question = questionService.selectByPrimaryKey(id);
    question.setDescription(description);
    questionService.update(question);
    int type = question.getType();
    int qid = question.getId();

    // 非问答题
    if (type != 0) {
      // 创建option
      String[] options = req.getParameterValues("option");
      for (String answer : options) {
        if (answer.equals("")) {
          continue;
        }
        Option option = new Option(qid);
        option.setAnswer(answer);
        optionService.insert(option);
      }
    } else {
      Option option = new Option(qid);
      optionService.insert(option);
    }
    String url = "/user/questionnaire/modify/" + question.getQnid();
    return "redirect:" + url;
  }
}
