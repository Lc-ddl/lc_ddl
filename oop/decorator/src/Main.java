abstract class Coffee{
    public abstract String getDescription();
    public abstract double cost();
}
class Espresso extends Coffee{
    public String getDescription(){
        return "Espresso";
    }
    public double cost(){
        return 25.0;
    }
}

class Americano extends Coffee{
    public String getDescription(){
        return "Americano";
    }
    public double cost(){
        return 20.0;
    }
}

class Latte extends Coffee{
    public String getDescription(){
        return "Latte";
    }
    public double cost(){
        return 30.0;
    }
}


abstract class CoffeeDecorator extends Coffee{
    protected Coffee coffee;
    public CoffeeDecorator(Coffee coffee){
        this.coffee = coffee;
    }
}

class milk extends CoffeeDecorator{
    public milk(Coffee coffee){
        super(coffee);
    }
    @Override
    public String getDescription(){
        return coffee.getDescription() + " milk";
    }
    @Override
    public double cost(){
        return coffee.cost() + 5.0;
    }
}

class sugar extends CoffeeDecorator{
    public sugar(Coffee coffee){
        super(coffee);
    }
    @Override
    public String getDescription(){
        return coffee.getDescription() + " sugar";
    }
    @Override
    public double cost(){
        return coffee.cost() + 2.0;
    }
}

class whip extends CoffeeDecorator{
    public whip(Coffee coffee){
        super(coffee);
    }
    @Override
    public String getDescription(){
        return coffee.getDescription() + " whip";
    }
    @Override
    public double cost(){
        return coffee.cost() + 4.0;
    }
}

class chocolate extends CoffeeDecorator{
    public chocolate(Coffee coffee){
        super(coffee);
    }
    @Override
    public String getDescription(){
        return coffee.getDescription() + " chocolate";
    }
    @Override
    public double cost(){
        return coffee.cost() + 6.0;
    }
}

class memberDiscount extends CoffeeDecorator{
    public memberDiscount(Coffee coffee){
        super(coffee);
    }

    @Override
    public String getDescription() {
        return coffee.getDescription()+" memberDiscount";
    }
    public double cost(){
        return coffee.cost() * 0.9;
    }
}
public class Main {
    public static void main(String[] args) {
        Coffee coffee1 = new Espresso();
        System.out.println(coffee1.getDescription()+ " "+ coffee1.cost());
        Coffee coffee2= new sugar(new milk(new Americano()));
        System.out.println(coffee2.getDescription()+ " "+ coffee2.cost());
        Coffee coffee3 = new whip(new chocolate(new Latte()));
        System.out.println(coffee3.getDescription()+ " "+ coffee3.cost());
        Coffee coffee4 = new memberDiscount(new whip(new chocolate(new Latte())));
        System.out.println(coffee4.getDescription()+ " "+ coffee4.cost());
    }
}