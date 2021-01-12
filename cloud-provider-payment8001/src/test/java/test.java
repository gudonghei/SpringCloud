import com.gudonghei.springcloud.PaymentMain8001;
import com.gudonghei.springcloud.controller.PaymentController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @ClassName: test
 * @Description: TODO(一句话描述该类的功能)
 * @Author: ZJH
 * @Date: 2020/10/15 16:18
 */
@SpringBootTest(classes = PaymentMain8001.class)
@RunWith(SpringRunner.class)
public class test {
    @Resource
    PaymentController paymentController;

    @Test
    public void test() {
        paymentController.getPaymentById(1l);
    }
}
