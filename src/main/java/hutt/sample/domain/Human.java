package hutt.sample.domain;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public class Human {

  // 名前
  private String name;

  // 年齢
  private int age;

  // あだ名
  private List<String> aliases;
}
