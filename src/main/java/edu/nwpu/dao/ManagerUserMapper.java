package edu.nwpu.dao;

import edu.nwpu.domain.ManagerUser;
import edu.nwpu.domain.ManagerUserKey;
import org.springframework.stereotype.Repository;

@Repository
public interface ManagerUserMapper {
    int deleteByPrimaryKey(ManagerUserKey key);

    int insert(ManagerUser record);

    int insertSelective(ManagerUser record);

    ManagerUser selectByPrimaryKey(ManagerUserKey key);

    int updateByPrimaryKeySelective(ManagerUser record);

    int updateByPrimaryKey(ManagerUser record);
}