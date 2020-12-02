package hello.core.order;

import hello.core.annotation.MainDiscountPolicy;
import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
// @RequiredArgsConstructor // final이 붙은 필드 생성자 주입
public class OrderServiceImpl implements OrderService {
    // 1. DIP, OCP 위반
    // private final MemberRepository memberRepository = new MemoryMemberRepository();
    // private final DiscountPolicy discountPolicy = new FixDiscountPolocy();
    // private final DiscountPolicy discountPolicy = new RateDiscountPolicy();

    // 2. 해결 : 생성자 주입 + final
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy ;

    // @RequiredArgsConstructor로 인한 생성자 생략
//    @Autowired
//    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
//        this.memberRepository = memberRepository;
//        this.discountPolicy = discountPolicy;
//    }

    // @MainDiscountPolicy 사용을 위해 @RequiredArgsConstructor 주석 처리
    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, @MainDiscountPolicy DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

//    // OrderServiceImplTest.class 을 위한 수정자 주입
//
//    private MemberRepository memberRepository;
//    private DiscountPolicy discountPolicy;
//
//    @Autowired
//    public void setMemberRepository(MemberRepository memberRepository) {
//        this.memberRepository = memberRepository;
//    }
//    @Autowired
//    public void setDiscountPolicy(DiscountPolicy discountPolicy) {
//        this.discountPolicy = discountPolicy;
//    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        // 1. 회원 조회
        Member member =  memberRepository.findById(memberId);
        // 2. 할인 적용 -> 단일 체계 원칙 준수, 즉 할인정책은 discountPolicy에 위임하고 결과만 return
        int discountPrice = discountPolicy.discount(member, itemPrice);
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    // @Bean 객체를 두 번 호출 했을 때 깨지는지 TEST
    public MemberRepository getMemberRepository(){
        return memberRepository;
    }


}
