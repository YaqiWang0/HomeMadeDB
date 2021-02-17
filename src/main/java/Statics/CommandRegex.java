package Statics;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class CommandRegex {
    private static String fileNameRegex = "[0-9a-zA-Z][0-9a-zA-Z._]*";
    public static String createDatabase = "^create\\sdatabase\\s" + fileNameRegex;
    public static String dropDatabase = "^drop\\sdatabase\\s.*" + fileNameRegex;
    public static String useDatabase = "^use\\s.*" + fileNameRegex;
    public static String describeDatabase = "^(desc|describe)\\sdatabase\\s.*" + fileNameRegex;
    public static String describeTable = "^(desc|describe)\\stable\\s.*" + fileNameRegex;
    public static String createTable = "^create\\stable\\s.*" + fileNameRegex;
    public static String dropTable = "^drop\\stable\\s.*" + fileNameRegex;

    public Set<String> regexLib;

    public CommandRegex() {
        regexLib = new HashSet<String>();
        init();
    }

    private void init() {
        regexLib.add(createDatabase);
        regexLib.add(dropDatabase);
        regexLib.add(useDatabase);
        regexLib.add(describeDatabase);
        regexLib.add(describeTable);
        regexLib.add(createTable);
        regexLib.add(dropTable);
    }


}
