package edu.nwpu.domain.vo;

import edu.nwpu.domain.Questionnaire;
import edu.nwpu.util.PaginationSupport;
import lombok.Data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * 传递问卷详情 包括所有问题和选项
 *
 * @author dengzhijian
 * @version 2.2
 */
@Data
public class QuestionnaireDetailsVO {
  private int id;
  private int status;
  private String title;
  private String url;
  private Date createTime;
  private Date checkTime;
  private int mid;
  private String username;
  private Date updateTime;
  private PaginationSupport<QuestionDetailsVO> questions;

  public QuestionnaireDetailsVO() {}

  public QuestionnaireDetailsVO(
      Questionnaire questionnaire,
      PaginationSupport<QuestionDetailsVO> questions,
      String username) {
    this.id = questionnaire.getId();
    this.status = questionnaire.getStatus();
    this.title = questionnaire.getTitle();
    this.url = questionnaire.getUrl();
    this.createTime = questionnaire.getCreateTime();
    this.checkTime = questionnaire.getCheckTime();
    if (questionnaire.getMid() != null) {
      this.mid = questionnaire.getMid();
    } else {
      this.mid = -1;
    }
    this.username = username;
    this.updateTime = questionnaire.getCheckTime();
    int pageSize = questions.getPageSize();
    int total = questions.getTotalCount();
    int start = questions.getStartIndex();
    this.questions = new PaginationSupport<>(questions.getItems(), total, pageSize, start);
  }

  /**
   * 将questionnaireList转换为questionnaireDetailsVOList
   *
   * @param questionnaires 问卷列表
   * @param questionDVOsList 问题详情列表
   * @return 问卷详情列表
   */
  public static PaginationSupport<QuestionnaireDetailsVO> toQuestionnaireDetailsVO(
      PaginationSupport<Questionnaire> questionnaires,
      List<PaginationSupport<QuestionDetailsVO>> questionDVOsList,
      String username) {
    List<Questionnaire> questionnaireList = questionnaires.getItems();
    List<QuestionnaireDetailsVO> list = new ArrayList<>();
    for (int i = 0; i < questionnaireList.size(); i++) {
      list.add(
          new QuestionnaireDetailsVO(questionnaireList.get(i), questionDVOsList.get(i), username));
    }
    int total = questionnaires.getTotalCount();
    return new PaginationSupport<>(list, total);
  }
}
