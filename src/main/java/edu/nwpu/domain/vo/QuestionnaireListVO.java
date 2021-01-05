package edu.nwpu.domain.vo;

import edu.nwpu.domain.Questionnaire;
import edu.nwpu.util.PaginationSupport;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 用于给用户展示问卷列表
 *
 * @author dengzhijian
 * @version 3.0
 */
@Data
public class QuestionnaireListVO {
  private int id;
  private int status;
  private String title;
  private String url;
  private Date createTime;
  private Date checkTime;

  public QuestionnaireListVO(Questionnaire questionnaire) {
    this.id = questionnaire.getId();
    this.status = questionnaire.getStatus();
    this.title = questionnaire.getTitle();
    this.url =questionnaire.getUrl();
    this.createTime = questionnaire.getCreateTime();
    this.checkTime = questionnaire.getCheckTime();
  }

  public QuestionnaireListVO() {}

  /**
   * 转换工具
   *
   * @param questionnaires 问卷列表
   * @return 问卷vo列表
   */
  public static PaginationSupport<QuestionnaireListVO> toQuestionnaireListVO(
      PaginationSupport<Questionnaire> questionnaires) {
    List<Questionnaire> questionnaireList = questionnaires.getItems();
    List<QuestionnaireListVO> list = new ArrayList<>();
    for (Questionnaire questionnaire : questionnaireList) {
      list.add(new QuestionnaireListVO(questionnaire));
    }
    int total = questionnaires.getTotalCount();
    return new PaginationSupport<>(list, total);
  }
}
