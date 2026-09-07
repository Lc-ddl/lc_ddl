public class Zoo{
    public static void main(String[] args) {
        Animal lion =AnimalFactory.createAnimal("Lion","辛巴");
        lion.feed();
        Animal monkey =AnimalFactory.createAnimal("Monkey","悟空");
        monkey.feed();
        Animal panda =AnimalFactory.createAnimal("panda","团团");
        panda.feed();
    }
}
