abstract class Pizza{
    protected String name;
    protected String dough;
    protected String sauce;

    abstract void prepare();

    public void bake(){
        System.out.println("烘焙");
    }
    public void cut(){
        System.out.println("切片");
    }
    public void box(){
        System.out.println("包装");
    }
}

class NYCheesePizza extends Pizza{
    public NYCheesePizza(){
        name = "纽约芝士披萨";
        dough = "薄脆面团";
        sauce = "番茄酱";
    }

    @Override
    public void prepare() {
        System.out.println("准备" + name);
        System.out.println("面团" + dough);
        System.out.println("酱汁" + sauce);
    }
}

class NYPepperoniPizza extends Pizza{
    public NYPepperoniPizza(){
        name = "纽约胡椒披萨";
        dough = "薄脆面团";
        sauce = "烧烤酱";
    }

    @Override
    public void prepare() {
        System.out.println("准备" + name);
        System.out.println("面团" + dough);
        System.out.println("酱汁" + sauce);
    }
}

class ChicagoCheesePizza extends Pizza{
    public ChicagoCheesePizza(){
        name = "芝加哥芝士披萨";
        dough = "厚面团";
        sauce = "番茄酱";
    }

    @Override
    public void prepare() {
        System.out.println("准备" + name);
        System.out.println("面团" + dough);
        System.out.println("酱汁" + sauce);
    }
}

class ChicagoPepperoniPizza extends Pizza{
    public ChicagoPepperoniPizza(){
        name = "芝加哥胡椒披萨";
        dough = "厚面团";
        sauce = "烧烤酱";
    }

    @Override
    public void prepare() {
        System.out.println("准备" + name);
        System.out.println("面团" + dough);
        System.out.println("酱汁" + sauce);
    }
}

abstract class PizzaStore{
    public abstract Pizza createPizza(String type);

    public Pizza orderPizza(String type){
        Pizza pizza = createPizza(type);
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
        return pizza;
    }
}

class NYPizzaStore extends PizzaStore{
    @Override
    public Pizza createPizza(String type) {
        if(type.equals("cheese")){
            return new NYCheesePizza();
        } else if(type.equals("pepperoni")){
            return new NYPepperoniPizza();
        }
        return null;
    }
}

class ChicagoPizzaStore extends PizzaStore{
    @Override
    public Pizza createPizza(String type) {
        if(type.equals("cheese")){
            return new ChicagoCheesePizza();
        } else if(type.equals("pepperoni")){
            return new ChicagoPepperoniPizza();
        }
        return null;
    }
}

public class Main {
    public static void main(String[] args) {
        PizzaStore pizzaStore = new NYPizzaStore();
        Pizza pizza = pizzaStore.orderPizza("cheese");
        System.out.println("订单：" + pizza.name);
    }
}