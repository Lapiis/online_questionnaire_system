package edu.nwpu.service;

import edu.nwpu.domain.User;
import edu.nwpu.util.PaginationSupport;

/**
 * 用户服务接口
 * @author Zhou yuang
 */
public interface UserService {
    /**
     * 删除指定主键用户
     *
     * @param id
     */
    void delete(Integer id);

    /**
     * 增加用户
     *
     * @param record
     * @return
     */
    User add(User record);

    /**
     * 根据用户id查找用户
     *
     * @param id
     * @return
     */
    User findOne(Integer id);

    User findByName(String name);

    /**
     * 修改用户
     *
     * @param record 用户
     * @return
     */
    User modify(User record);

    /**
     * 分页返回所有用户
     *
     * @param pageNo
     * @param pageSize
     * @return 问卷列表
     */
    PaginationSupport<User> findPage(int pageNo, int pageSize);

    /**
     * 返回用户总人数
     *
     * @return 总数
     */
    int count();

    boolean checkName(String name);

    User login(String name, String password);
}
