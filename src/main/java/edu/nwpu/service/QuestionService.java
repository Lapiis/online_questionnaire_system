package edu.nwpu.service;

import edu.nwpu.domain.Question;
import edu.nwpu.util.PaginationSupport;

import java.util.List;

/**
 * 问题业务接口
 *
 * @author dengzhijian
 */
public interface QuestionService {
  /**
   * 新建一个问题
   *
   * @param qnid 问卷id
   */
  Question create(int qnid);

  /**
   * 删除指定问题
   *
   * @param id 问题id
   */
  void delete(int id);

  /**
   * 分页查找指定问卷id的所有问题
   *
   * @param pageNo 页码
   * @param pageSize 页面大小
   * @param qnid 问卷id
   * @return 所有问题列表
   */
  PaginationSupport<Question> findPage(int pageNo, int pageSize, int qnid);

  /**
   * 根据问卷id返回所有问题（不分页）
   * @param qnid
   * @return
   */
  List<Question> findAll(int qnid);
  /**
   * 按主键查找问题
   *
   * @param id 问题id
   * @return 问题
   */
  Question selectByPrimaryKey(int id);

  /**
   * 返回指定问卷id的总问题数
   *
   * @param qnid 问卷id
   * @return 总数
   */
  int count(int qnid);

  /**
   * 更新问题
   *
   * @param question 问题
   */
  void update(Question question);
}
