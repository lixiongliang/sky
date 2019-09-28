package spring.ch1.topic2;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by louyuting on 17/1/20.
 * 这里使用依赖注入的方式测试:依赖注入采用反射机制实例化的.
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:ApplicationContext-test.xml"})
public class SingerTest {
    @Autowired
    private ApplicationContext applicationContext;

    @Test
    public void testSinger(){
        Singer jack = (Singer)applicationContext.getBean("jack");
        jack.singSong();
        Singer rose = (Singer)applicationContext.getBean("rose");
        rose.singSong();
    }



}
