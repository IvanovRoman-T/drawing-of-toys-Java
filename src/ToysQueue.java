import java.util.LinkedList;

public class ToysQueue {
    LinkedList<Toy> toyQueue;

    ToysQueue(){
        this.toyQueue = new LinkedList<>();
    }

    void addToQueue(Toy toy){
        this.toyQueue.add(toy);
    }

    Toy peekToy(){
        return this.toyQueue.peekFirst();
    }
}
