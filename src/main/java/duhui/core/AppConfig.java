package duhui.core;

import duhui.core.discount.FixDiscountPolicy;
import duhui.core.discount.RateDiscountPolicy;
import duhui.core.member.MemberService;
import duhui.core.member.MemberServiceImpl;
import duhui.core.member.MemoryMemberRepository;
import duhui.core.order.OrderService;
import duhui.core.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService(){
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderService fixOrderService(){
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
    }

    public OrderService rateOrderService(){
        return new OrderServiceImpl(new MemoryMemberRepository(), new RateDiscountPolicy());
    }

}
