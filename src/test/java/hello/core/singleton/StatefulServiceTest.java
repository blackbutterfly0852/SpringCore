package hello.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

public class StatefulServiceTest {

    @Test
    void statefulServiceSingleton(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService1 = ac.getBean(StatefulService.class);
        StatefulService statefulService2 = ac.getBean(StatefulService.class);
//        1. 싱글톤 빈의 상태를 유지하게 설계하면 안된다.
//        // ThreadA : 사용자A가 10000원 주문
//        statefulService1.order("userA", 10000);
//        // ThreadB : 사용자B가 10000원 주문
//        statefulService2.order("userB", 20000);
//
//        // ThreadA : 사용자A 주문 금액 조회 : 10000원 예상하나 20000 출력
//        // 스프링 싱글톤은 하나의 인스턴스를 공유하기 때문에 ThreadB에서 엎어친다.
//        int price = statefulService1.getPrice();
//        System.out.println("price = " + price);
//
//        Assertions.assertThat(statefulService1.getPrice()).isEqualTo(20000);

//       2. 싱글 톤 빈의 상태를 무상태로 변경
         // ThreadA : 사용자A가 10000원 주문
         int priceA = statefulService1.order("userA", 10000);
         // ThreadB : 사용자B가 10000원 주문
         int priceB = statefulService2.order("userB", 20000);


         Assertions.assertThat(priceA).isEqualTo(10000);
    }


    static class TestConfig{
        @Bean
        public StatefulService statefulService(){
            return new StatefulService();
        }
    }
}
