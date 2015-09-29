package hutt.sample.controller;

import lombok.Getter;
import lombok.Setter;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

  @RequestMapping("/hello")
  public String hello(Params p) {
    return "Hello " + p.getName();
  }

  @Getter
  @Setter
  public static class Params {
    @NotBlank
    private String name;
  }
}
