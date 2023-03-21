import java.io.IOException;
import java.util.Scanner;

public class UI {
    boolean flag = true;
    ToysList toys = new ToysList();
    ToysQueue toysQueue = new ToysQueue();
    Scanner scanner = new Scanner(System.in);

    void start() throws IOException {
        FileManager.readToys(this.toys);
        this.help();
        while (this.flag){
            this.command();
        }
    }

    private void command() throws IOException {
        System.out.println("\nВведите комманду: ");
        String com = this.scanner.next();
        switch (com) {
            case "help" -> help();
            case "1" -> showToys();
            case "2" -> addToy();
            case "3" -> raffle();
            case "4" -> getToy();
            case "0" -> exit();
            default -> System.out.println("Неизвестная комманда.");
        }
    }

    private void help(){
        System.out.println("""
        Список комманд:
        help - вывести список комманд
        1 - показать список игрушек
        2 - добавить игрушку
        3 - запустить розыгрыш 
        4 - забрать выйгрыш
        0 - выход""");
    }

    private void exit() throws IOException {
        FileManager.saveToys(toys);
        this.flag = false;
    }

    private void showToys(){
        System.out.print(this.toys.showNames());
    }

    private void addToy(){
        System.out.print("Введите название игрушки: ");
        scanner.nextLine();
        String name = this.scanner.nextLine();
        System.out.print("Введите количество игрушек: ");
        int amount = this.scanner.nextInt();
        System.out.print("Введите вес игрушки (в % от 100): ");
        double weight = this.scanner.nextDouble();
        Toy toy = new Toy(name, amount, weight, this.toys);
    }

    private void raffle(){
        Raffle.startRaffle(this.toys, this.toysQueue);
        System.out.printf("Вы выиграли %s, чтобы забрать выйгрыш введите комманду 4", this.toysQueue.peekLastToy());

    }

    private void getToy() throws IOException {
        if (!this.toysQueue.isEmpty()) {
            FileManager.addWinner(this.toysQueue.peekFirstToy());
            System.out.printf("Ваш выйгрыш: %s", this.toysQueue.getFirstToy());

        }
        else {
            System.out.println("В очереди на выдачу нет игрушек.");
        }
    }


}
