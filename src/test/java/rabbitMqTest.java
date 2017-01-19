import com.quartztask.rabbitmq.MessageProducer;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Administrator on 2017/1/19.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:/applicationContext.xml","classpath*:/applicationContext-rabbitmq.xml","classpath*:/applicationContext-mybatis.xml"})
public class rabbitMqTest {
    private final Logger log = Logger.getLogger(this.getClass());
    @Autowired
    private MessageProducer messageProducer;
    @Test
    public void rabbitMqTest(){
        log.debug("============================================logtest=============================================");
        for (int i = 0; i < 10; i++) {
            messageProducer.sendMessage("Hello, I am amq serder num: " + i);
        }
    }
}
