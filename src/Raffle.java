public class Raffle {

//    Выбор выйгранной игрушки
    static void startRaffle(ToysList toys, ToysQueue toysQueue){
        toys.alignWeight();
        double num = Math.random();
        double sumWeight = 0;
        for (Toy toy : toys.getToys()) {
            sumWeight += toy.getWeight() / 100;
            if (num <= sumWeight){
                toysQueue.addToQueue(toy);
                break;
            }
        }
    }
}
