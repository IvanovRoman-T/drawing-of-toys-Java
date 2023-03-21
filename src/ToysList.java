import java.util.ArrayList;

// клас, хранящий список всех игрушек
public class ToysList {
    private ArrayList<Toy> toys;

    ToysList(){
        this.toys = new ArrayList<>();
    }

    void addToy(Toy toy){
        toys.add(toy);
    }

//    выводит список игрушек вместе с количеством и весом
    String show(){
        this.alignWeight();
        StringBuilder s = new StringBuilder();
        for (Toy toy : this.toys) {
            s.append(toy.toString());
            s.append('\n');
        }
        return s.toString();
    }

//    выводит список названий игрушек
    String showNames(){
        StringBuilder s = new StringBuilder();
        for (Toy toy : this.toys) {
            s.append(toy.getName());
            s.append(", ");
        }
        s.deleteCharAt(s.length() - 2);
        return s.toString();
    }

    public ArrayList<Toy> getToys() {
        return toys;
    }

//    уравнивание весов игрушек, чтобы их сумма была равноа 100
    void alignWeight(){
        double sumWeight = 0;
        for (Toy toy : this.toys) {
            sumWeight += toy.getWeight();
        }
        for (Toy toy : this.toys) {
            toy.setWeight((toy.getWeight() / sumWeight) * 100);
        }
    }
}
