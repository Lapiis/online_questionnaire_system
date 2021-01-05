package edu.nwpu.service.impl;

import edu.nwpu.dao.ManagerMapper;
import edu.nwpu.domain.Manager;
import edu.nwpu.service.ManagerService;
import edu.nwpu.util.PaginationSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** @author dengzhijian */
@Service
public class ManagerServiceImpl implements ManagerService {
  @Autowired private ManagerMapper managerMapper;

  @Override
  public void delete(Integer id) {
    managerMapper.deleteByPrimaryKey(id);
  }

  /**
   * 添加管理员
   * @param record 管理员
   * @return
   */
  @Override
  public Manager add(Manager record) {
    managerMapper.insert(record);
    return record;
  }

  /**
   * 根据管理员id查找
   *
   * @param id
   * @return
   */
  @Override
  public Manager findOne(Integer id) {
    return managerMapper.selectByPrimaryKey(id);
  }

  /**
   * 修改管理员
   *
   * @param record 管理员
   * @return
   */
  @Override
  public Manager modify(Manager record) {
    managerMapper.updateByPrimaryKeySelective(record);
    return record;
  }

  /**
   * 分页返回所有管理员
   *
   * @param pageNo
   * @param pageSize
   * @return 问卷列表
   */
  @Override
  public PaginationSupport<Manager> findPage(int pageNo, int pageSize) {
    int totalCount = managerMapper.count();
    Map<String, Object> params = new HashMap<>();
    params.put("start", PaginationSupport.convertFromPageToStartIndex(pageNo, pageSize));
    params.put("size", pageSize);
    List<Manager> list = managerMapper.findAllByPage(params);
    return new PaginationSupport<>(list, totalCount, pageSize, pageNo);
  }

  /**
   * 返回管理员总人数
   *
   * @return 总数
   */
  @Override
  public int count() {
    return managerMapper.count();
  }

  @Override
  public boolean checkName(String name) {
    Manager manager = managerMapper.findByName(name);
    if (manager != null) {
      return true;
    }
    return false;
  }

  @Override
  public Manager login(String name, String password) {
    return managerMapper.findByNameAndPassword(name, password);
  }
}
