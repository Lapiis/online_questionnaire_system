package edu.nwpu.service.impl;

import edu.nwpu.dao.UserMapper;
import edu.nwpu.domain.User;
import edu.nwpu.service.UserService;
import edu.nwpu.util.PaginationSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class UserServiceImpl implements UserService {
  @Autowired private UserMapper userMapper;

  @Override
  public void delete(Integer id) {
    userMapper.deleteByPrimaryKey(id);
  }

  @Override
  public User add(User record) {
    userMapper.insertSelective(record);
    return record;
  }

  /**
   * 根据用户id查找用户
   *
   * @param id
   * @return
   */
  @Override
  public User findOne(Integer id) {

    return userMapper.selectByPrimaryKey(id);
  }

  @Override
  public User findByName(String name) {
    return userMapper.findByName(name);
  }

  /**
   * 修改用户
   *
   * @param record 用户
   * @return
   */
  @Override
  public User modify(User record) {
    userMapper.updateByPrimaryKeySelective(record);
    return record;
  }

  /**
   * 分页返回所有用户
   *
   * @param pageNo
   * @param pageSize
   * @return 用户列表
   */
  @Override
  public PaginationSupport<User> findPage(int pageNo, int pageSize) {
    int totalCount = userMapper.count();
    Map<String, Object> params = new HashMap<>();
    params.put("start", PaginationSupport.convertFromPageToStartIndex(pageNo, pageSize));
    params.put("size", pageSize);
    List<User> list = userMapper.findAllByPage(params);
    return new PaginationSupport<>(list, totalCount, pageSize, pageNo);
  }

  /**
   * 返回用户总人数
   *
   * @return 总数
   */
  @Override
  public int count() {
    return userMapper.count();
  }

  @Override
  public boolean checkName(String name) {
    User user = userMapper.findByName(name);
    if (user != null) {
      return true;
    }
    return false;
  }

  @Override
  public User login(String name, String password) {
    return userMapper.findByNameAndPassword(name, password);
  }
}
