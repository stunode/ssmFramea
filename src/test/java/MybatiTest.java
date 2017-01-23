//import com.quartztask.entity.ScheduleJob;
//import com.quartztask.service.IScheduleJobService;
//import com.quartztask.service.ItemsService;
//import org.apache.log4j.Logger;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import java.util.Date;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = "classpath*:/applicationContext*.xml")
//public class MybatiTest {
//    private final Logger log = Logger.getLogger(this.getClass());
//    @Autowired
//    private ItemsService itemsService;
//    @Autowired
//    private IScheduleJobService scheduleJobService;
//    private ScheduleJob scheduleJob = new ScheduleJob();
//    @Test
//    public void test() throws Exception {
//
//        try {
//            scheduleJob.setBeanClass("aaa");
//            scheduleJob.setCronExpression("0 0 0 0 0 0 0");
//            scheduleJob.setCreateTime(new Date());
//            scheduleJob.setUpdateTime(new Date());
//            scheduleJob.setMethodName("a");
//            scheduleJobService.insertSelective(scheduleJob);
//        } catch (Exception e) {
//        }
//
//    }
//
//    public static void main(String[] args) {
//
//    }
//}
