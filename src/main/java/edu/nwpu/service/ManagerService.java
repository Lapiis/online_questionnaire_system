package edu.nwpu.service;

import edu.nwpu.domain.Manager;
import edu.nwpu.util.PaginationSupport;

/**
 * 管理员服务接口
 * @author dengzhijian
 */
public interface ManagerService {

    /**
     * 删除指定id管理员
     * @param id
     */
    void delete(Integer id);

    /**
     * 增加一个管理员
     * @param record
     * @return
     */
    Manager add(Manager record);

    /**
     * 根据管理员id查找
     *
     * @param id
     * @return
     */
    Manager findOne(Integer id);

    /**
     * 修改管理员
     *
     * @param record 管理员
     * @return
     */
    Manager modify(Manager record);

    /**
     * 分页返回所有管理员
     *
     * @param pageNo
     * @param pageSize
     * @return 问卷列表
     */
    PaginationSupport<Manager> findPage(int pageNo, int pageSize);

    /**
     * 返回管理员总人数
     *
     * @return 总数
     */
    int count();

    boolean checkName(String name);

    /**
     * 管理员登录
     *
     * @param name
     * @param password
     * @return
     */
    Manager login(String name, String password);
}
