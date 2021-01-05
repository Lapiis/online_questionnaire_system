package edu.nwpu.dao;

import edu.nwpu.domain.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface UserMapper {
  int deleteByPrimaryKey(Integer id);

  int insert(User record);

  int insertSelective(User record);

  User selectByPrimaryKey(Integer id);

  int updateByPrimaryKeySelective(User record);

  int updateByPrimaryKey(User record);

  /**
   * 根据用户名查找用户
   *
   * @param name
   * @return
   */
  User findByName(String name);

  User findByNameAndPassword(@Param("name") String name, @Param("password") String password);
  /**
   * 分页返回所有用户
   *
   * @param params 分页参数
   * @return 问卷列表
   */
  List<User> findAllByPage(Map<String, Object> params);

  /**
   * 返回用户总人数
   *
   * @return 总数
   */
  int count();
}
