package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolocy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.*;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // 설정파일
public class AppConfig {

    // 1. 애플리케이션 실제 동작에 필요한 구현객체를 생성한다.
//    public MemberService memberService(){
//        return new MemberServiceImpl(new MemoryMemberRepository());
//    }
//
//    public OrderService orderService(){
//        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolocy());
//    }

    // 2. 1.의 코드는 역할에 따른 구현이 잘 안보인다.

//    public MemberService memberService(){
//        return new MemberServiceImpl(memberRepository());
//    }

//    public OrderService orderService(){
//        return new OrderServiceImpl(memberRepository(), discountPolicy());
//    }

//    public MemberRepository memberRepository() {
//        return new MemoryMemberRepository();
//    }

//    public DiscountPolicy discountPolicy() {
//        // return new FixDiscountPolocy();
//        // AppConfig의 등장으로 애플리케이션이 크게 사용 영역과, 객체를 생성하고 구성(Configuration)하는 영역으로 분리되었다.
//        return new RateDiscountPolicy();
//    }

    // 3. 2.의 코드를 Spring 전환
    @Bean // @Bean Spring Container 등록
    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    }
    @Bean
    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }
    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
    @Bean
    public DiscountPolicy discountPolicy() {
        // return new FixDiscountPolocy();
        // AppConfig의 등장으로 애플리케이션이 크게 사용 영역과, 객체를 생성하고 구성(Configuration)하는 영역으로 분리되었다.
        return new RateDiscountPolicy();
    }

}
