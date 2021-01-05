package edu.nwpu.service.impl;

import edu.nwpu.dao.QuestionMapper;
import edu.nwpu.domain.Question;
import edu.nwpu.service.QuestionService;
import edu.nwpu.util.PaginationSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class QuestionServiceImpl implements QuestionService {

  @Autowired private QuestionMapper questionMapper;

  /**
   * 新建一个问题
   *
   * @param qnid 问卷id
   */
  @Override
  public Question create(int qnid) {
    Question question = new Question(qnid);
    questionMapper.insert(question);
    return question;
  }

  /**
   * 删除指定问题
   *
   * @param id 问题id
   */
  @Override
  public void delete(int id) {
    questionMapper.deleteByPrimaryKey(id);
  }

  /**
   * 分页查找问题(包含选项)
   *
   * @param pageNo 页码
   * @param pageSize 页面大小
   * @param qnid 问卷id
   * @return 问卷列表
   */
  @Override
  public PaginationSupport<Question> findPage(int pageNo, int pageSize, int qnid) {
    int totalCount = questionMapper.count(qnid);
    Map<String, Object> params = new HashMap<>();
    params.put("start", PaginationSupport.convertFromPageToStartIndex(pageNo, pageSize));
    params.put("size", pageSize);
    params.put("qnid", qnid);
    List<Question> list = questionMapper.findAllByPageAndId(params);
    return new PaginationSupport<>(list, totalCount, pageSize, pageNo);
  }

  @Override
  public List<Question> findAll(int qnid) {
    return questionMapper.findAll(qnid);
  }

  /**
   * 按主键查找问题
   *
   * @param id 问题id
   * @return 问题
   */
  @Override
  public Question selectByPrimaryKey(int id) {
    return questionMapper.selectByPrimaryKey(id);
  }

  /**
   * 返回指定问卷id的总问题数
   *
   * @param qnid 问卷id
   * @return 总数
   */
  @Override
  public int count(int qnid) {
    return questionMapper.count(qnid);
  }

  /**
   * 更新问题
   *
   * @param question 问题
   */
  @Override
  public void update(Question question) {
    questionMapper.updateByPrimaryKeySelective(question);
  }
}
