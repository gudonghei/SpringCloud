
import com.gudonghei.springcloud.OrderMain80;
import com.gudonghei.springcloud.controller.OrderController;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import javax.annotation.Resource;

/**
 * @ClassName: test
 * @Description: TODO(一句话描述该类的功能)
 * @Author: ZJH
 * @Date: 2020/10/15 16:18
 */
@SpringBootTest(classes = OrderMain80.class)
@RunWith(SpringRunner.class)
@Slf4j
public class test {
    @Resource
    OrderController orderController;

    @Test
    public void test() {
        log.info("*********结果输出"+ orderController.getPayment(1l));

    }
}
