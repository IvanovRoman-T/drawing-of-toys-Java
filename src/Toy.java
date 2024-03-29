public class Toy {
    private int id;
    private final String name;
    private int amount;
    private double weight;

    Toy(String name, int amount, double weight, ToysList toys, int id){
        this.id = id;
        this.name = name;
        this.amount = amount;
        this.weight = weight;
        toys.addToy(this);
    }

    Toy(String name, int amount, double weight, ToysList toys){
        this(name, amount, weight, toys, Math.round((float) Math.random() * 10000));
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public int getAmount() {
        return amount;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return String.format("Id: %d; Name: %s; Amount: %d; Weight: %.2f%%", this.id, this.name, this.amount, this.weight);
    }
}
