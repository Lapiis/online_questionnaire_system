package edu.nwpu.service.impl;

import edu.nwpu.dao.OptionMapper;
import edu.nwpu.domain.Option;
import edu.nwpu.service.OptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OptionServiceImpl implements OptionService {
  @Autowired private OptionMapper optionMapper;
  /**
   * 按主键id删除
   *
   * @param id 主键id
   * @return 影响行数
   */
  @Override
  public void delete(Integer id) {
    optionMapper.deleteByPrimaryKey(id);
  }

  /**
   * 插入一个选项
   *
   * @param qid 问题id
   * @return 影响行数
   */
  @Override
  public void create(int qid) {
    optionMapper.insertSelective(new Option(qid));
  }

  /**
   * 插入选项
   *
   * @param option 选项
   * @return
   */
  @Override
  public Option insert(Option option) {
    optionMapper.insert(option);
    return option;
  }

  /**
   * 按主键查询
   *
   * @param id 主键id
   * @return 选项
   */
  @Override
  public Option findOne(Integer id) {
    return optionMapper.selectByPrimaryKey(id);
  }

  /**
   * 按主键更新（字段为null则不更新）
   *
   * @param record 选项
   */
  @Override
  public void update(Option record) {
    optionMapper.updateByPrimaryKeySelective(record);
  }

  /**
   * 按主键更新选项
   *
   * @param record 选项
   */
  @Override
  public void updateByPrimaryKey(Option record) {
    optionMapper.updateByPrimaryKey(record);
  }

  /**
   * 根据问题id返回所有相应选项，按id排序
   *
   * @param qid 问题id
   * @return 选项列表
   */
  @Override
  public List<Option> findAllByQidOrderById(int qid) {
    return optionMapper.findAllByQidOrderById(qid);
  }

  /**
   * 指定id选项被选择，进行+1
   *
   * @param id
   */
  @Override
  public void selected(int id) {
    optionMapper.selected(id);
  }
}
