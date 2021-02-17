import Clients.DBMSClient;
import Statics.CommandLibrary;
import Statics.CommandRegex;
import sun.jvm.hotspot.types.WrongTypeException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class InputManager {
    DatabaseClientFactory databaseClientFactory;

    public InputManager() {
        databaseClientFactory = new DatabaseClientFactory();
    }

    public void read() throws IOException {
        System.out.print("ZhangCaiSB > ");
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));

        // Reading data using readLine
        String cmd = reader.readLine();

        try {
            validate(cmd);
            DBMSClient client = databaseClientFactory.getDatabaseClient(cmd);
            client.processCommand(cmd);
        } catch ( WrongTypeException e) {
            System.out.println("wrong pattern");
        }
    }

    public void validate(String input) {
        boolean find = false;
        CommandRegex commandRegex  = new CommandRegex();
        CommandLibrary commandLibrary = new CommandLibrary();
        for(String regex : commandRegex.regexLib) {
            if(Pattern.matches(regex, input)) {
                find = true;
                break;
            }
        }

        for(String cmd : commandLibrary.commandLib) {
            if (cmd.equals(input)) {
                find = true;
                break;
            }
        }

        if(!find) {
           throw new WrongTypeException();
        }

    }
}
