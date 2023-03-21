import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class FileManager {
    static void saveToys(ToysList toys) throws IOException {
        toys.alignWeight();
        StringBuilder res = new StringBuilder();
        for (Toy toy: toys.getToys()) {
            res.append(toy.toString());
            res.append("\n");
        }
        Files.writeString(Path.of("ToysFile.txt"), res.toString());
    }

    static void readToys(ToysList toys) throws IOException {
        ArrayList<String> list = (ArrayList<String>) Files.readAllLines(Path.of("ToysFile.txt"));
        for (String str : list) {
            String[] a = str.split(";");
            int id = Integer.parseInt(a[0].split(": ")[1]);
            String name = a[1].split(": ")[1];
            int amount = Integer.parseInt(a[2].split(": ")[1]);
            double weight = Double.parseDouble(a[3].split(": ")[1].replace("%", "").replace(',', '.'));
            Toy b = new Toy(name, amount, weight, toys, id);
        }
    }

    static void addWinner(String toy) throws IOException {
        var path = Path.of("Winners.txt");
        String str = Files.readString(path);
        str = str + "\n" + toy;
        Files.writeString(path, str);
    }
}
