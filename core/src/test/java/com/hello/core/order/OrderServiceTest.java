package com.hello.core.order;

import com.hello.core.AppConfig;
import com.hello.core.discount.FixDiscountPolicy;
import com.hello.core.discount.RateDiscountPolicy;
import com.hello.core.member.Grade;
import com.hello.core.member.Member;
import com.hello.core.member.MemberService;
import com.hello.core.member.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {

    OrderService orderService;
    MemberService memberService;

    @BeforeEach // 각 테스트 실행 전에 되는 것
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        orderService = appConfig.orderService();
        memberService = appConfig.memberService();
    }

    @Test
    void createOrder() {
        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);
        Assertions.assertThat(order.getDiscoutPrice()).isEqualTo(1000);
    }

//    @Test
//    void fieldInjectionTest() {
////        OrderServiceImpl orderService = new OrderServiceImpl();
////        orderService.createOrder(1L, "itemA", 10000);
////        orderService.setMemberRepository(new MemoryMemberRepository());
////        orderService.setDiscountPolicy(new FixDiscountPolicy());
//    }
}
