package hutt.sample.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import hutt.sample.domain.Human;

@RestController
@RequestMapping("humans")
@EnableAutoConfiguration
public class RestSampleController {

  @RequestMapping(method = RequestMethod.GET)
  List<Human> getHumans() {
    List<Human> humans = createDummyHumans();
    return humans;
  }

  @RequestMapping(value = "{id}", method = RequestMethod.GET)
  Human getHuman(@PathVariable Integer id) {
    List<Human> humans = createDummyHumans();
    return humans.get(id);
  }

  @RequestMapping(method = RequestMethod.POST)
  @ResponseStatus(HttpStatus.CREATED)
  void createHuman(@RequestBody Human human) {
    List<Human> humans = createDummyHumans();
    humans.add(human);
  }

  @RequestMapping(method = RequestMethod.PUT)
  @ResponseStatus(HttpStatus.NO_CONTENT)
  void updateHuman(@PathVariable Integer id, @RequestBody Human human) {
    List<Human> humans = createDummyHumans();
    humans.set(id, human);
  }

  @RequestMapping(method = RequestMethod.DELETE)
  @ResponseStatus(HttpStatus.NO_CONTENT)
  void deleteHuman(@PathVariable Integer id) {
    List<Human> humans = createDummyHumans();
    humans.set(id, null);
  }

  private List<Human> createDummyHumans() {
    List<Human> humans = new ArrayList<>();
    // create by lombok.AllArgsConstructor
    IntStream.range(0, 9).forEach(
        (i) -> humans.add(new Human(String.format("name_%d", i), i, new ArrayList<String>())));
    // create by lombok.Builder
    humans
        .add(Human.builder().name("name_builder").age(10).aliases(new ArrayList<String>()).build());
    return humans;
  }

}
