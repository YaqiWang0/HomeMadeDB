package Clients;

import Statics.PathConstants;

import java.io.File;
import java.io.FilenameFilter;

public class DatabaseClient extends DBMSClient {
    public void processCommand(String cmd) {
        if(cmd.contains("create")) {
            createDatabase(cmd);
        } else if (cmd.contains("show")) {
           showDatabases();
        }
    }

    private void createDatabase (String cmd) {
        //get db name
        int index = cmd.lastIndexOf(" ");
        String name = cmd.substring(index + 1);
        File file = new File(PathConstants.dataRoot + "/" + name);
        if(!file.exists()) {
            file.mkdirs();
        } else {
            System.out.println("Database already exists");
        }
    }

    private void showDatabases () {
        File file = new File(PathConstants.dataRoot);
        String[] directories = file.list(new FilenameFilter() {

            public boolean accept(File dir, String name) {
                return new File(dir, name).isDirectory();
            }
        });

        for(String s : directories) {
            System.out.println(s);
        }
    }
}
