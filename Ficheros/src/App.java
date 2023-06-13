import java.io.BufferedWriter;
import java.io.FileWriter;

public class App {
    public static void main(String[] args) throws Exception {
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("archivo.txt"))) {
            writer.write("holaaaa");
        }


    }
}
