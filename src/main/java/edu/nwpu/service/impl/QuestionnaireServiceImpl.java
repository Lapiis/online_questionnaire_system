package edu.nwpu.service.impl;

import edu.nwpu.dao.QuestionnaireMapper;
import edu.nwpu.domain.Questionnaire;
import edu.nwpu.service.QuestionnaireService;
import edu.nwpu.util.PaginationSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** @author dengzhijian */
@Service
public class QuestionnaireServiceImpl implements QuestionnaireService {
  @Autowired private QuestionnaireMapper questionnaireMapper;

  @Override
  public Questionnaire selectByPrimaryKey(Integer id) {

    return questionnaireMapper.selectByPrimaryKey(id);
  }

  @Override
  public PaginationSupport<Questionnaire> findPage(int pageNo, int pageSize, int uid) {
    int totalCount = questionnaireMapper.count(uid);
    Map<String, Object> params = new HashMap<>();
    params.put("start", PaginationSupport.convertFromPageToStartIndex(pageNo, pageSize));
    params.put("size", pageSize);
    params.put("uid", uid);
    List<Questionnaire> list = questionnaireMapper.findAllByPageAndId(params);
    return new PaginationSupport<>(list, totalCount, pageSize, pageNo);
  }

  /**
   * 按页查询所有问卷列表
   *
   * @param pageNo
   * @param pageSize
   * @return
   */
  @Override
  public PaginationSupport<Questionnaire> findAllPage(int pageNo, int pageSize) {
    int totalCount = questionnaireMapper.countAll();
    Map<String, Object> params = new HashMap<>();
    params.put("start", PaginationSupport.convertFromPageToStartIndex(pageNo, pageSize));
    params.put("size", pageSize);
    List<Questionnaire> list = questionnaireMapper.findAllByPage(params);
    return new PaginationSupport<>(list, totalCount, pageSize, pageNo);
  }

  /**
   * 按页查询所有已提交问卷列表
   *
   * @param pageNo
   * @param pageSize
   * @return
   */
  @Override
  public PaginationSupport<Questionnaire> findAllPageCommit(int pageNo, int pageSize) {
    int totalCount = questionnaireMapper.countAllCommit();
    Map<String, Object> params = new HashMap<>();
    params.put("start", PaginationSupport.convertFromPageToStartIndex(pageNo, pageSize));
    params.put("size", pageSize);
    List<Questionnaire> list = questionnaireMapper.findAllCommitByPage(params);
    return new PaginationSupport<>(list, totalCount, pageSize, pageNo);
  }

  @Override
  public Questionnaire create(int uid) {
    Questionnaire q = new Questionnaire(uid);
    questionnaireMapper.insert(q);
    return q;
  }

  /**
   * 删除指定问卷
   *
   * @param id 问卷id
   */
  @Override
  public void delete(int id) {
    questionnaireMapper.deleteByPrimaryKey(id);
  }

  /**
   * 设置指定id的问卷的审核情况
   *
   * @param id 问卷id
   * @param mid 管理员id
   * @param url url
   */
  @Override
  public void setCheck(int id, int mid, String url) {
    Questionnaire questionnaire = questionnaireMapper.selectByPrimaryKey(id);
    Date time = new Date();
    questionnaire.setStatus(2);
    questionnaire.setCheckTime(time);
    questionnaire.setUrl(url);
    questionnaire.setMid(mid);
    questionnaireMapper.updateByPrimaryKeySelective(questionnaire);
  }

  /**
   * 更新问卷
   *
   * @param questionnaire 新问卷
   */
  @Override
  public void updateSelective(Questionnaire questionnaire) {
    Date time = new Date();
    questionnaire.setUpdateTime(time);
    questionnaireMapper.updateByPrimaryKeySelective(questionnaire);
  }
}
