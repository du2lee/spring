package duhui.core;

import duhui.core.discount.DiscountPolicy;
import duhui.core.discount.FixDiscountPolicy;
import duhui.core.discount.RateDiscountPolicy;
import duhui.core.member.MemberService;
import duhui.core.member.MemberServiceImpl;
import duhui.core.member.MemoryMemberRepository;
import duhui.core.order.OrderService;
import duhui.core.order.OrderServiceImpl;

public class AppConfig {

    private MemoryMemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    private DiscountPolicy fixRepository(){
        return new FixDiscountPolicy();
    }

    private DiscountPolicy rateRepository(){
        return new RateDiscountPolicy();
    }


    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    }

    public OrderService fixOrderService(){
        return new OrderServiceImpl(memberRepository(), fixRepository());
    }

    public OrderService rateOrderService(){
        return new OrderServiceImpl(memberRepository(), rateRepository());
    }
}
