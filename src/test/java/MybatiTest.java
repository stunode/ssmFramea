import com.quartztask.service.IScheduleJobService;
import com.quartztask.service.ItemsService;
import com.quartztask.util.RefrenceUtil;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:/applicationContext*.xml")
public class MybatiTest {
    private final Logger log = Logger.getLogger(this.getClass());
    @Autowired
    private ItemsService itemsService;
    @Autowired
    private IScheduleJobService scheduleJobService;
    @Test
    public void test() throws Exception{
//        List<ScheduleJob> items = scheduleJobService.getAllJobList();
        log.debug("aaaaaaaa");
        RefrenceUtil.getBean();
//        System.out.println(items.size());
    }

    public static void main(String[] args) {

    }
}
