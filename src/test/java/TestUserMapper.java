import edu.nwpu.dao.QuestionnaireMapper;
import edu.nwpu.dao.UserMapper;
import edu.nwpu.domain.Questionnaire;
import edu.nwpu.domain.User;
import edu.nwpu.service.QuestionService;
import edu.nwpu.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
    value = {"classpath:applicationContext-dao.xml", "classpath:applicationContext-service.xml"})
public class TestUserMapper {
  @Autowired private UserMapper userMapper;

  @Autowired private UserService userService;

  @Autowired private QuestionnaireMapper questionnaireMapper;
  @Autowired private QuestionService questionService;

  @Test
  public void test() {
    User user = userMapper.findByNameAndPassword("zhou", "123");
    System.out.println(user);

    user = userService.login("zhou", "123");
    System.out.println(user);
  }

  @Test
  public void test1() {
    Map<String, Object> map = new HashMap<>();
    map.put("start", 0);
    map.put("size", 3);
    map.put("id", 1);
    questionnaireMapper.insert(new Questionnaire(1));
    List<Questionnaire> list = questionnaireMapper.findAllByPageAndId(map);
    for (Questionnaire q : list) {
      System.out.println(q);
    }
    //        questionnaireMapper.delete(1);
    //        List<Questionnaire> list1 = questionnaireMapper.findAllByPageAndUId(map);
    //        for (Questionnaire q : list1) {
    //            System.out.println(q);
    //        }
  }
}
