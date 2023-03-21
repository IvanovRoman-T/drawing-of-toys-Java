import java.util.LinkedList;

public class ToysQueue {
    LinkedList<Toy> toyQueue;

    ToysQueue(){
        this.toyQueue = new LinkedList<>();
    }

    void addToQueue(Toy toy){
        this.toyQueue.addLast(toy);
    }

    String getFirstToy(){
        this.toyQueue.peekFirst().setAmount(this.toyQueue.peekFirst().getAmount() - 1);
        return this.toyQueue.removeFirst().getName();
    }

    String peekLastToy(){
        return this.toyQueue.peekLast().getName();
    }

    String  peekFirstToy(){
        return this.toyQueue.peekFirst().getName();
    }

    boolean isEmpty(){
        return this.toyQueue.isEmpty();
    }

}
