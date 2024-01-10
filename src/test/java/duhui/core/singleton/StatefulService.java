package duhui.core.singleton;

public class StatefulService {

    private int price; // 상태를 유지하는 필드

//    유상태
//    public void order(String name, int price){
//        System.out.println("name = " + name + "price = " + price);
//        this.price = price;
//    }

    // 무상태
    public int order(String name, int price){
        System.out.println("name = " + name + "price = " + price);
//        this.price = price;
        return price;
    }

//    public int getPrice(){
//        return price;
//    }

}
