package duhui.core.scan;

import duhui.core.AutoAppConfig;
import duhui.core.member.MemberService;
import duhui.core.order.OrderService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AutoAppConfigTest {

    @Test
    void basicScan(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);

        MemberService memberservice = ac.getBean(MemberService.class);
        OrderService ordersService = ac.getBean(OrderService.class);

        Assertions.assertThat(memberservice).isInstanceOf(MemberService.class);
    }
}
