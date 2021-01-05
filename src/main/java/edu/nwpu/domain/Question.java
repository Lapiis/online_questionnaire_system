package edu.nwpu.domain;

import lombok.Data;

import java.util.List;

import java.io.Serializable;

/**
 * question
 *
 * @author yefeng
 */
@Data
public class Question implements Serializable {
  private Integer id;
  /**
   * 0 表示 填空
   * 1 表示 单选
   * 2 表示 多选
   */
  private Integer type;

  private String description;

  private Integer qnid;
  private List<Option> options;

  private static final long serialVersionUID = 1L;

  public Question() {}

  public Question(Integer qnid) {
    this.qnid = qnid;
  }
}
