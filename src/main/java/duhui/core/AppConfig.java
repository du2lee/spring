package duhui.core;

import duhui.core.discount.DiscountPolicy;
import duhui.core.discount.FixDiscountPolicy;
import duhui.core.discount.RateDiscountPolicy;
import duhui.core.member.MemberRepository;
import duhui.core.member.MemberService;
import duhui.core.member.MemberServiceImpl;
import duhui.core.member.MemoryMemberRepository;
import duhui.core.order.OrderService;
import duhui.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public DiscountPolicy fixRepository(){
        return new FixDiscountPolicy();
    }

    @Bean
    public DiscountPolicy rateRepository(){
        return new RateDiscountPolicy();
    }

    @Bean
    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public OrderService fixOrderService(){
        return new OrderServiceImpl(memberRepository(), fixRepository());
    }

    @Bean
    public OrderService rateOrderService(){
        return new OrderServiceImpl(memberRepository(), rateRepository());
    }
}
