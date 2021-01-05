package edu.nwpu.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * option
 *
 * @author yefeng
 */
@Data
public class Option implements Serializable {
  private Integer id;

  private String answer;

  private Long selectCount;

  private Integer qid;

  private static final long serialVersionUID = 1L;

  public Option(Integer qid) {
    this.qid = qid;
  }

  public Option() {}
}
