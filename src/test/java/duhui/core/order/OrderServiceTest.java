package duhui.core.order;

import duhui.core.AppConfig;
import duhui.core.discount.DiscountPolicy;
import duhui.core.discount.FixDiscountPolicy;
import duhui.core.member.Grade;
import duhui.core.member.Member;
import duhui.core.member.MemberService;
import duhui.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderServiceTest {
    MemberService memberService;
    OrderService orderService;

    @BeforeEach
    public void beforeEach(){
//        AppConfig appConfig = new AppConfig();
//        memberService = appConfig.memberService();
//        orderService = appConfig.fixOrderService();
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        memberService = applicationContext.getBean("memberService", MemberService.class);
        orderService = applicationContext.getBean("fixOrderService", OrderService.class);
    }

    @Test
    void creatOrder(){
        Long memberId = 1L;
        Member member = new Member(memberId, "duhui", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "Chicken Breast", 2000);

        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}
