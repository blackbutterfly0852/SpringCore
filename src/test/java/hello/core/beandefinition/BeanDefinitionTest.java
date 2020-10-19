package hello.core.beandefinition;

import hello.core.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class BeanDefinitionTest {

    //AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class); // factory 메소드를 통해 우회적으로 빈 등록
    GenericXmlApplicationContext ac = new GenericXmlApplicationContext("appConfig.xml"); // 빈 직접 등록

    @Test
    @DisplayName("빈 설정 메타정보 확인")
    public void findApplicationBean() throws Exception {
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName);
            // 아래 메타정보를 가지고 실제 인스턴스 생성
            if (beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) {
                System.out.println("beanDefinition = " + beanDefinitionName + " beanDefinition  = " + beanDefinition);
            }
        }
    }


}
