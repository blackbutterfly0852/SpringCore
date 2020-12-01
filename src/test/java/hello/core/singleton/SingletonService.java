package hello.core.singleton;

public class SingletonService {
    // 1. 자기 자신을 static final 로 지정 -> 어플리케이션에서 실행시 바로 초기화 한다. -> static 영역에 하나만 올려진다.
    private static final SingletonService instance = new SingletonService();
    // 2. 생성자 private 지정 -> 다른 곳에서 new 생성 못하도록 한다.
    private SingletonService(){

    }
    // 3. 객체 조회시 -> 항상 동일한 객체를 리턴한다.
    public static SingletonService getInstance(){
        return instance;
    }

    public void logic(){
        System.out.println("싱글톤 객체 로직 호출");
    }


}
