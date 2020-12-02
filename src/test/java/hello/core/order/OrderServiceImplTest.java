package hello.core.order;

import hello.core.discount.FixDiscountPolicy;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemoryMemberRepository;
import org.assertj.core.api.Assertions;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

// 수정자 주입 TEST
class OrderServiceImplTest {

    @Test
    @DisplayName("스프링 없는 순수한 자바 코드 테스트")
    void createOrder(){
        // 1. 수정자 주입시 : NPE 예외, 의존관계 직관적으로 확인 어려움
//        OrderServiceImpl orderService = new OrderServiceImpl();
//        orderService.createOrder(1L,"itemA",10000);

        // 2. 생성자 주입시
        MemoryMemberRepository memoryMemberRepository = new MemoryMemberRepository();
        memoryMemberRepository.save(new Member(1L,"name", Grade.VIP));
        OrderServiceImpl orderService = new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
        Order order = orderService.createOrder(1L,"itemA",10000);
        assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }

}