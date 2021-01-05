package edu.nwpu.dao;

import edu.nwpu.domain.Manager;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface ManagerMapper {
  /**
   * 设isDeleted为true
   *
   * @param id
   * @return
   */
  int deleteByPrimaryKey(Integer id);

  int insert(Manager record);

  int insertSelective(Manager record);

  Manager selectByPrimaryKey(Integer id);

  int updateByPrimaryKeySelective(Manager record);

  int updateByPrimaryKey(Manager record);

  /**
   * 分页查询未删除的管理员列表
   *
   * @param params
   * @return
   */
  List<Manager> findAllByPage(Map<String, Object> params);

  /**
   * 返回未删除管理员总人数
   *
   * @return
   */
  int count();

  /**
   * 根据用户名查找管理员
   *
   * @param name
   * @return
   */
  Manager findByName(String name);

  /**
   * 根据用户名和密码查找管理员
   *
   * @param name
   * @param password
   * @return
   */
  Manager findByNameAndPassword(@Param("name") String name, @Param("password") String password);
}
