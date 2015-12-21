package hutt;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import hutt.core.JavaTheHuttApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = JavaTheHuttApplication.class)
@WebAppConfiguration
public class JavaTheHuttApplicationTests {

	@Test
	public void contextLoads() {
	}

}
