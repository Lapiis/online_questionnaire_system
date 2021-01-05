package edu.nwpu.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * questionnaire
 *
 * @author yefeng
 */
@Data
public class Questionnaire implements Serializable {
  private Integer id;
  /** 状态 0:草稿 1:提交 2:已审核 */
  private Integer status = 0;

  private String title;

  private String url;

  private Date createTime;

  private Integer uid;

  private Date checkTime;

  private Integer mid;

  private Date updateTime;

  private static final long serialVersionUID = 1L;

  public Questionnaire(Integer uid, Integer status) {
    this.uid = uid;
    this.status = status;
    this.createTime = new Date();
  }

  public Questionnaire(Integer uid) {
    this.uid = uid;
    this.createTime = new Date();
  }

  public Questionnaire() {}
}
