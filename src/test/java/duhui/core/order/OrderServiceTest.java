package duhui.core.order;

import duhui.core.discount.DiscountPolicy;
import duhui.core.discount.FixDiscountPolicy;
import duhui.core.member.Grade;
import duhui.core.member.Member;
import duhui.core.member.MemberService;
import duhui.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {

    MemberService memberService = new MemberServiceImpl();
    OrderService orderService = new OrderServiceImpl();

    @Test
    void creatOrder(){
        Long memberId = 1L;
        Member member = new Member(memberId, "duhui", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "Chicken Breast", 2000);

        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}
