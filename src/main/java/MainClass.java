import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainClass {

    public static void main(String[] args) throws IOException {
        InputManager manager = new InputManager();
        // Enter data using BufferReader
        while(true) {
           manager.read();
        }
    }
}
