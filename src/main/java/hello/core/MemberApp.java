package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {

    public static void main(String[] args) {
        // 1. DIP, OCP 위반
//        MemberService memberService = new MemberServiceImpl();
//        Member member = new Member(1L, "memberA", Grade.VIP);
//        memberService.join(member);
//
//        Member findMember = memberService.findMember(1L);
//
//        System.out.println("newMember = " + member.getName());
//        System.out.println("findMember = " + findMember.getName() );

        // 2. 해결 - AppConfig 활용
//
//            AppConfig app = new AppConfig();
//            Member member = new Member(1L, "memberA", Grade.VIP);
//            MemberService memberService = app.memberService();
//            memberService.join(member);
//            Member findMember = memberService.findMember(1L);
//            System.out.println("findMember = " + findMember.getName() );

        // 3. 스프링 전환
            ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
            MemberService memberService = ac.getBean("memberService", MemberService.class);
            Member member = new Member(1L, "memberA", Grade.VIP);
            memberService.join(member);
            Member findMember = memberService.findMember(1L);
            System.out.println("findMember = " + findMember.getName() );

    }
}
