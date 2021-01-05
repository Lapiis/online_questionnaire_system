package edu.nwpu.domain;

import lombok.Data;
import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * manager
 *
 * @author lijiacheng
 */
@Data
public class Manager implements Serializable {
  private Integer id;

  @NotNull
  @Size(min = 5, max = 16)
  private String name;

  @NotNull
  @Size(min = 5, max = 16)
  private String password;

  @NotNull
  @Pattern(regexp = "^1[3|4|5|7|8]\\d{9}$", message = "请输入正确的手机号码")
  private String phoneNum;

  @NotNull @Email private String email;

  private Boolean isDeleted = false;

  private static final long serialVersionUID = 1L;
}
