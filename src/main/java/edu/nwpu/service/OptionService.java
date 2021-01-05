package edu.nwpu.service;

import edu.nwpu.domain.Option;

import java.util.List;

/**
 * 选项服务接口
 * @author dengzhijian
 */
public interface OptionService {
  /**
   * 按主键id删除
   *
   * @param id 主键id
   * @return 影响行数
   */
  void delete(Integer id);

  /**
   * 插入一个选项
   *
   * @param qid 问题id
   * @return 影响行数
   */
  void create(int qid);

  /**
   * 插入一个选项
   *
   * @param option 选项
   * @return
   */
  Option insert(Option option);

  /**
   * 按主键查询
   *
   * @param id 主键id
   * @return 选项
   */
  Option findOne(Integer id);

  /**
   * 按主键更新（字段为null则不更新）
   *
   * @param record 选项
   * @return 影响行数
   */
  void update(Option record);

  /**
   * 按主键更新选项
   *
   * @param record 选项
   */
  void updateByPrimaryKey(Option record);

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
