package edu.nwpu.dao;

import edu.nwpu.domain.Questionnaire;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface QuestionnaireMapper {
  /**
   * 删除指定主键问卷
   *
   * @param id 主键id
   * @return 影响行数
   */
  int deleteByPrimaryKey(Integer id);

  /**
   * 插入一个问卷
   *
   * @param record 问卷
   * @return 问卷
   */
  int insert(Questionnaire record);

  /**
   * 插入一个问卷(空字段不更新)
   *
   * @param record 问卷
   * @return 问卷
   */
  int insertSelective(Questionnaire record);

  /**
   * 按主键查询
   *
   * @param id 主键id
   * @return 问卷
   */
  Questionnaire selectByPrimaryKey(Integer id);

  /**
   * 按主键更新问卷（字段为null则不更新）
   *
   * @param record 问卷
   * @return 影响行数
   */
  int updateByPrimaryKeySelective(Questionnaire record);

  /**
   * 按主键更新问卷
   *
   * @param record 问卷
   * @return 影响行数
   */
  int updateByPrimaryKey(Questionnaire record);

  /**
   * 计算相应id用户的问卷总数
   *
   * @param uid 用户id
   * @return 问卷总数
   */
  int count(int uid);

  /**
   * 查询所有问卷总数
   *
   * @return 问卷总数
   */
  int countAll();
  /**
   * 分页返回用户所有问卷
   *
   * @param params 分页参数和uid
   * @return 问卷列表
   */
  List<Questionnaire> findAllByPageAndId(Map<String, Object> params);

  /**
   * 分页返回所有问卷
   *
   * @param params
   * @return
   */
  List<Questionnaire> findAllByPage(Map<String, Object> params);

  /**
   * 分页返回所有已提交问卷
   *
   * @param params
   * @return
   */
  List<Questionnaire> findAllCommitByPage(Map<String, Object> params);

  /**
   * 统计已提交的问卷数量
   *
   * @return
   */
  int countAllCommit();
}
