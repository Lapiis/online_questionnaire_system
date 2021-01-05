package edu.nwpu.domain.vo;

import edu.nwpu.domain.Option;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * 选项vo
 * @author yefeng
 */
@Data
public class OptionVO {
  private int id;
  private long selectCount;
  String answer;

  public OptionVO(Option option) {
    this.id = option.getId();
    this.selectCount = option.getSelectCount();
    this.answer = option.getAnswer();
  }

  public OptionVO() {}

  public static List<OptionVO> toList(List<Option> options) {
    List<OptionVO> list = new ArrayList<>();
    for (Option option : options) {
      list.add(new OptionVO(option));
    }
    return list;
  }
}
