package duhui.core.autowired;

import duhui.core.AutoAppConfig;
import duhui.core.discount.DiscountPolicy;
import duhui.core.member.Grade;
import duhui.core.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

public class AllBeanTest {

    @Test
    void findAllBean(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class, DiscountService.class);
        
        DiscountService discountService = ac.getBean(DiscountService.class);
        Member duhui = new Member(1L, "duhui", Grade.VIP);
        int discountPrice = discountService.discount(duhui, 20000, "rateDiscountPolicy");

        Assertions.assertThat(discountService).isInstanceOf(DiscountService.class);
        Assertions.assertThat(discountPrice).isEqualTo(2000);
    }

    @Component
    static class DiscountService {
        private final Map<String, DiscountPolicy> policyMap;
        private final List<DiscountPolicy> polices;

        @Autowired
        public DiscountService(Map<String, DiscountPolicy> policyMap, List<DiscountPolicy> polices){
            this.policyMap = policyMap;
            this.polices = polices;

            System.out.println("policyMap = " + policyMap);
            System.out.println("polices = " + polices);
        }

        public int discount(Member member, int price, String discountCode){
            DiscountPolicy discountPolicy = policyMap.get(discountCode);
            return discountPolicy.discount(member, price);
        }
    }
}
