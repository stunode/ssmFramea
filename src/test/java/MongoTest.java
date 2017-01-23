import com.quartztask.mongodb.MongoSmsPoolEntity;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * TODO
 *
 * @author cuiran
 * @version TODO
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:/applicationContext.xml","classpath*:/applicationContext-mongo.xml","classpath*:/applicationContext-rabbitmq.xml","classpath*:/applicationContext-mybatis.xml"})
public class MongoTest {

    private static Log log = LogFactory.getLog(MongoTest.class.getName());

    @Autowired
    private MongoOperations mongoOperations;

    /**
     * <b>function:</b>根据输入的ID查找对象
     *
     * @author cuiran
     * @createDate 2012-12-12 16:24:10
     */
    public void findOne() {
        List<MongoSmsPoolEntity> mongoSmsPoolEntity = mongoOperations.find(
                new Query(Criteria.where("sendstatus").is(3)),
                MongoSmsPoolEntity.class, "smsPool");
        log.debug(mongoSmsPoolEntity.size());
    }

    public void findAll() {

        List<MongoSmsPoolEntity> mongoSmsPoolEntity = mongoOperations.findAll(MongoSmsPoolEntity.class);
        log.debug(mongoSmsPoolEntity.size());
    }


    /**
     * <b>function:</b>测试方法
     *
     * @author cuiran
     * @createDate 2012-12-12 16:11:37
     */
    @Test
    public void start() {
        findOne();
    }

}
