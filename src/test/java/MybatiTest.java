import com.quartztask.entity.Items;
import com.quartztask.service.ItemsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import javax.annotation.Resource;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:/applicationContext*.xml")
public class MybatiTest {
    @Autowired
    private ItemsService itemsService;
    @Test
    public void test() throws Exception{
        Items items = itemsService.findItemsById(1);
        System.out.println("aaa");
    }
}
