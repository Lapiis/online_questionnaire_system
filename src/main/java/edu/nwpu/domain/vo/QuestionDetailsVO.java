package edu.nwpu.domain.vo;

import edu.nwpu.domain.Question;
import edu.nwpu.util.PaginationSupport;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * 问题详情VO
 *
 * @author dengzhijian
 * @version 2.1
 */
@Data
public class QuestionDetailsVO {
  private int id;
  private int type;
  private String description;
  private List<OptionVO> options;

  public QuestionDetailsVO() {}

  public QuestionDetailsVO(Question question, List<OptionVO> options) {
    this.id = question.getId();
    this.type = question.getType();
    this.description = question.getDescription();
    this.options = new ArrayList<>();
    this.options.addAll(options);
  }

  /**
   * 将questionList转换为questionDetailsVOList
   *
   * @param questions 问题列表
   * @param optionsList 选项列表
   * @return 问题详情列表
   */
  public static PaginationSupport<QuestionDetailsVO> toQuestionDetailsVO(
      PaginationSupport<Question> questions, List<List<OptionVO>> optionsList) {
    List<QuestionDetailsVO> list = new ArrayList<>();
    List<Question> questionList = questions.getItems();
    for (int i = 0; i < questionList.size(); i++) {
      list.add(new QuestionDetailsVO(questionList.get(i), optionsList.get(i)));
    }
    int total = questions.getTotalCount();
    return new PaginationSupport<>(list, total);
  }
}
