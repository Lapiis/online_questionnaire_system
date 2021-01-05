package edu.nwpu.dao;

import edu.nwpu.domain.Question;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface QuestionMapper {
  /**
   * 删除指定主键问题
   *
   * @param id 主键id
   * @return 影响行数
   */
  int deleteByPrimaryKey(Integer id);

  /**
   * 插入一个问题
   *
   * @param record 问题
   * @return 问题
   */
  int insert(Question record);

  /**
   * 插入一个问题(空字段不更新)
   *
   * @param record 问题
   * @return 问题
   */
  int insertSelective(Question record);
  /**
   * 按主键查询
   *
   * @param id 主键id
   * @return 问题
   */
  Question selectByPrimaryKey(Integer id);

  /**
   * 按主键更新问题（字段为null则不更新）
   *
   * @param record 问题
   * @return 影响行数
   */
  int updateByPrimaryKeySelective(Question record);
  /**
   * 按主键更新问题
   *
   * @param record 问题
   * @return 影响行数
   */
  int updateByPrimaryKey(Question record);

  /**
   * 分页返回指定问卷id的所有问题列表
   *
   * @param params 分页参数和问卷id
   * @return 问题列表
   */
  List<Question> findAllByPageAndId(Map<String, Object> params);

  /**
   * 根据问卷id返回所有问题
   *
   * @param qnid
   * @return
   */
  List<Question> findAll(int qnid);
  /**
   * 返回指定问题id的总问题数
   *
   * @param qnid 问题id
   * @return 总问题数
   */
  int count(int qnid);
}
