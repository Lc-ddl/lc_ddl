public abstract class Animal {
    public abstract void feed();
    protected String name;
    public Animal(String name) {
        this.name = name;
    }


}

class Lion extends Animal{
    public  Lion(String name){
        super(name);
    }
    @Override
    public void feed() {
        System.out.println("狮子"+name+"吃肉");
    }
}

class Monkey extends Animal{
    public Monkey(String name){
        super(name);
    }
    @Override
    public void feed() {
        System.out.println("猴子"+name+"正在吃香蕉");
    }
}

class panda extends Animal{
    public panda(String name){
        super(name);
    }
    @Override
    public void feed() {
        System.out.println("熊猫"+name+"正在吃竹子");
    }
}

class AnimalFactory {
    public static Animal createAnimal(String type, String name) {
        switch (type.toLowerCase()) {
        case "lion":
            return new Lion(name);
        case "monkey":
            return new Monkey(name);
        case "panda":
            return new panda(name);
        default:
            // 抛出异常，而不是返回 null（更安全，强制调用者处理错误）
            throw new IllegalArgumentException("未知的动物类型：" + type);
    }
    }
}


