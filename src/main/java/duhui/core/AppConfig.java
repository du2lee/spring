package duhui.core;

import duhui.core.discount.FixDiscountPolicy;
import duhui.core.member.MemberService;
import duhui.core.member.MemberServiceImpl;
import duhui.core.member.MemoryMemberRepository;
import duhui.core.order.OrderService;
import duhui.core.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService(){
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderService orderService(){
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
    }

}
