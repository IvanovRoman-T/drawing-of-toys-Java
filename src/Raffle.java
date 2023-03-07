public class Raffle {

//    Выбор выйгранной игрушки
    void startRaffle(ToysList toys){
        toys.alignWeight();
        double num = Math.random();
        double sumWeight = 0;
        for (Toy toy : toys.getToys()) {
            sumWeight += toy.getWeight() / 100;
            if (num <= sumWeight){

            }
        }
    }
}
