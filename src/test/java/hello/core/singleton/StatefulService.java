package hello.core.singleton;

public class StatefulService {
//    1. 싱글톤 빈의 상태를 유지하게 설계하면 안된다.
//    private int price; // 상태를 유지하는 필드 -> 10000원에서 20000원으로 변경
//
//    public void order(String name, int price){
//        System.out.println("name : " + name + " price = " + price);
//        this.price = price; // 여기가 문제
//    }
//
//    public int getPrice(){
//        return price;
//    }


//  2. 싱글 톤 빈의 상태를 무상태로 변경
    public int order(String name, int price){
        System.out.println("name : " + name + " price = " + price);

        return price;
    }
}
