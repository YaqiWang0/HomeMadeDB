package Statics;

import java.util.HashSet;
import java.util.Set;

public class CommandLibrary {
    public static String showDataBases = "show databases";
    public static String showTables = "show tables";

    public Set<String> commandLib;

    public CommandLibrary() {
        commandLib = new HashSet<String>();
        commandLib.add(showDataBases);
        commandLib.add(showTables);
    }
}
