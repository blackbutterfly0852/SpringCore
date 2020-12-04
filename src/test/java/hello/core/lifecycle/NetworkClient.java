package hello.core.lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class NetworkClient {
        // 1. 인터페이스 InitializingBean, DisposableBean
        //implements InitializingBean, DisposableBean {

    private String url;

    public NetworkClient(){
        System.out.println("생성자 호출, url = " + url);
        connect();
        call("초기화 연결 메세지");
    }

    public void setUrl(String url) {
        this.url = url;
    }

    // 서비스 시작시 호출

    public void connect(){
        System.out.println("connect = " + url);
    }


    public void call(String message){
        System.out.println("call = " + url + " "  + "message = " + message);
    }

    // 서비스 종료시 호출
    public void disconnect(){
        System.out.println("close = " + url );
    }


    // 1. 인터페이스 InitializingBean, DisposableBean
//    @Override
//    // 스프링 객체 생성 후 호출(초기화 지원)
//    public void afterPropertiesSet() throws Exception {
//        connect();
//        call("초기화 연결 메세지");
//    }
//
//    @Override
//    // 스프링 소멸 직전 호출
//    public void destroy() throws Exception {
//        disconnect();
//    }


    // 3. 애노테이션 @PostConstruct, @PreDestroy
    @PostConstruct
    public void init() throws Exception {
        connect();
        call("초기화 연결 메세지");
    }
    @PreDestroy
    public void close() throws Exception {
        disconnect();
    }
}
