package edu.nwpu.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * manager_user
 *
 * @author dengzhijian
 */
@Data
public class ManagerUser extends ManagerUserKey implements Serializable {
  private Date updateTime;

  private Date resetTime;

  private static final long serialVersionUID = 1L;
}
