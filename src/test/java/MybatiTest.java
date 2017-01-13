import com.quartztask.entity.Items;
import com.quartztask.entity.ScheduleJob;
import com.quartztask.service.IScheduleJobService;
import com.quartztask.service.ItemsService;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import javax.annotation.Resource;
import java.util.List;

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
//        System.out.println(items.size());
    }

    public static void main(String[] args) {
        String a = "b";
        int b =  a.equals("a")? 1 :2 ;
        System.out.println(b);
    }
}
