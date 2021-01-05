package edu.nwpu.dao;

import edu.nwpu.domain.Option;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OptionMapper {
  /**
   * 按主键id删除
   *
   * @param id 主键id
   * @return 影响行数
   */
  int deleteByPrimaryKey(Integer id);

  /**
   * 插入一个选项
   *
   * @param record 选项
   * @return 影响行数
   */
  int insert(Option record);

  /**
   * 插入一个选项（字段为null则不插入）
   *
   * @param record 选项
   * @return 影响行数
   */
  int insertSelective(Option record);

  /**
   * 按主键查询
   *
   * @param id 主键id
   * @return 选项
   */
  Option selectByPrimaryKey(Integer id);

  /**
   * 按主键更新（字段为null则不更新）
   *
   * @param record 选项
   * @return 影响行数
   */
  int updateByPrimaryKeySelective(Option record);

  /**
   * 按主键更新选项
   *
   * @param record 选项
   * @return 影响行数
   */
  int updateByPrimaryKey(Option record);

  /**
   * 根据问题id返回所有相应选项，按id排序
   *
   * @param qid 问题id
   * @return 选项列表
   */
  List<Option> findAllByQidOrderById(int qid);

  /**
   * 指定id选项被选择，进行+1
   *
   * @param id
   */
  void selected(int id);
}
