package duhui.core.order;

import duhui.core.discount.DiscountPolicy;
import duhui.core.discount.FixDiscountPolicy;
import duhui.core.discount.RateDiscountPolicy;
import duhui.core.member.Member;
import duhui.core.member.MemberRepository;
import duhui.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private DiscountPolicy discountPolicy;


//    =====================  DIP, OCP 위반 코드  ===============================
//    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
//    private final DiscountPolicy discountPolicy = new RateDiscountPolicy();
//    ========================================================================

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId,itemName, itemPrice, discountPrice);
    }
}
