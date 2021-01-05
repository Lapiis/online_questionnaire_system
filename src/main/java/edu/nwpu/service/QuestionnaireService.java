package edu.nwpu.service;

import edu.nwpu.domain.Questionnaire;
import edu.nwpu.util.PaginationSupport;

/**
 * 问卷业务类
 *
 * @author dengzhijian
 */
public interface QuestionnaireService {

  /**
   * 根据问卷id返回问卷详情
   *
   * @param id 问卷id
   * @return 问卷详情
   */
  Questionnaire selectByPrimaryKey(Integer id);

  /**
   * 按页查询用户问卷列表
   *
   * @param pageNo 页码
   * @param pageSize 页面大小
   * @param uid 用户id
   * @return 问卷列表
   */
  PaginationSupport<Questionnaire> findPage(int pageNo, int pageSize, int uid);

  /**
   * 按页查询所有问卷列表
   *
   * @param pageNo
   * @param pageSize
   * @return
   */
  PaginationSupport<Questionnaire> findAllPage(int pageNo, int pageSize);

  /**
   * 按页查询所有已提交问卷列表
   *
   * @param pageNo
   * @param pageSize
   * @return
   */
  PaginationSupport<Questionnaire> findAllPageCommit(int pageNo, int pageSize);
  /**
   * 创建一个问卷
   *
   * @param uid 用户id
   * @return 问卷
   */
  Questionnaire create(int uid);

  /**
   * 删除指定问卷
   *
   * @param id 问卷id
   */
  void delete(int id);

  /**
   * 设置指定id的问卷的审核情况以及url
   *
   * @param id 问卷
   * @param mid 管理员id
   * @param url url
   */
  void setCheck(int id, int mid, String url);

  /**
   * 更新问卷（空字段不更新）
   *
   * @param questionnaire 新问卷
   */
  void updateSelective(Questionnaire questionnaire);
}
