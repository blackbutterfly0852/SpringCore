package hello.core.member;

public class MemberServiceImpl implements MemberService{

    // 1. DIP, OCP 위반
    // private final MemberRepository memberRepository = new MemoryMemberRepository();

    // 2. 해결 : 생성자 주입
    // 의존관계에 대한 고민은 외부에 맡기고 실행에만 집중한다.
    private final MemberRepository memberRepository; // final -> 생성자 주입
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
}
