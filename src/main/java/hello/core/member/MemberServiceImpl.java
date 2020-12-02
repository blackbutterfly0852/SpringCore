package hello.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberServiceImpl implements MemberService{

    // 1. DIP, OCP 위반
    // private final MemberRepository memberRepository = new MemoryMemberRepository();

    // 2. 해결 : 생성자 주입
    // 의존관계에 대한 고민은 외부에 맡기고 실행에만 집중한다.

    private final MemberRepository memberRepository; // final -> 생성자 주입
    @Autowired // 자동으로 MemberRepository 에 맞는 객체를 주입 (현재는 MemoryMemberRepository) , ac.getBean(MemberRepository.class)
    public MemberServiceImpl(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }


    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);

    }

    // @Bean 객체를 두 번 호출 했을 때 깨지는지 TEST
    public MemberRepository getMemberRepository(){
        return memberRepository;
    }

}
