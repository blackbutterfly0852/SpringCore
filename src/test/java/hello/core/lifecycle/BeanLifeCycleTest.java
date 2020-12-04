package hello.core.lifecycle;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class BeanLifeCycleTest {


    @Test
    public void lifeCycleTest(){
        // ApplicationContext <- ConfigurableApplicationContext <- AnnotationConfigApplicationContext
        // close() 를 사용하기 위해 ConfigurableApplicationContext 을 이용한다 .
        ConfigurableApplicationContext ac = new AnnotationConfigApplicationContext(LifeCycleConfig.class);
        NetworkClient client = ac.getBean(NetworkClient.class);
        ac.close();
    }



    @Configuration
    static class LifeCycleConfig{
        // 2. 등록 초기화, 소멸 메서드 지정
        //@Bean(initMethod = "init", destroyMethod = "close")

        // 3. 애노테이션 @PostConstruct, @PreDestroy
        @Bean
        public NetworkClient networkClient(){
            NetworkClient networkClient = new NetworkClient();
            networkClient.setUrl("http://hello-spring.dev");
            return networkClient;
        }
    }
}
