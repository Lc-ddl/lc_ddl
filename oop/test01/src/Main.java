interface DiscountStrategy {
    double getDiscount(double price);
}
class noDiscount implements DiscountStrategy {
    @Override
    public double getDiscount(double price) {
        return price;
    }
}
class MemberDiscount implements DiscountStrategy {
    @Override
    public double getDiscount(double price) {
        return price * 0.8;
    }
}
class FULLDiscount implements DiscountStrategy {
    @Override
    public double getDiscount(double price) {
        if(price >= 200){return price - 30;}
        else{return price;}
    }
}
class HoildayDiscount implements DiscountStrategy {
    @Override
    public double getDiscount(double price) {
        return price * 0.7;
    }
}

class Pricecalculator{
    DiscountStrategy strategy;

    public Pricecalculator(DiscountStrategy strategy){
        this.strategy = strategy;
    }
    public double setStrategy(double price){
        return strategy.getDiscount(price);
    }
}
public class Main {
    public static void main(String[] args) {
        Pricecalculator pricecalculator;
        pricecalculator = new Pricecalculator(new noDiscount());
        System.out.println("原价：" + pricecalculator.setStrategy(100));
        pricecalculator = new Pricecalculator(new MemberDiscount());
        System.out.println("会员折扣：" + pricecalculator.setStrategy(100));
        pricecalculator = new Pricecalculator(new FULLDiscount());
        System.out.println("满减后：" + pricecalculator.setStrategy(100));
        pricecalculator = new Pricecalculator(new HoildayDiscount());
        System.out.println("节日折扣：" + pricecalculator.setStrategy(100));
    }
}