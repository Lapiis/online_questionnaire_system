package edu.nwpu.domain;

import java.io.Serializable;
import lombok.Data;

/**
 * manager_user
 * @author lijiacheng
 */
@Data
public class ManagerUserKey implements Serializable {
    private Integer mid;

    private Integer uid;

    private static final long serialVersionUID = 1L;
}