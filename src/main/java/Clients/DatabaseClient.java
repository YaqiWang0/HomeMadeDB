package Clients;

import Statics.PathConstants;

import java.io.File;
import java.io.FilenameFilter;

public class DatabaseClient extends DBMSClient {
    //TODO better check method to avoid edge cases when table name contains those key words
    public void processCommand(String cmd) {
        if(cmd.contains("create")) {
            createDatabase(cmd);
        } else if (cmd.contains("show")) {
           showDatabases();
        } else if (cmd.contains("drop")) {
            dropDatabases(cmd);
        } else if (cmd.contains("use")) {
            useDatabase(cmd);
        }
    }

    private void createDatabase (String cmd) {
        //get db name
        String name = getDBName(cmd);
        if(dbExist(name)) {
            System.out.println("DB already exists");
            return;
        }
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

    private void dropDatabases(String cmd) {
        String name = getDBName(cmd);
        if(!dbExist(name)) {
            System.out.println("DB not exist");
            return;
        }
        //get db name
        File directory = new File(PathConstants.dataRoot + "/" + name);
        String[] files = directory.list();
        for(String file: files){
            File currentFile = new File(directory.getPath(),file);
            currentFile.delete();
        }
        directory.delete();
    }

    private void useDatabase(String cmd) {
        String name = getDBName(cmd);
        if(!dbExist(name)) {
            System.out.println("DB not exist");
            return;
        }
        PathConstants.dbPath = name;
        System.out.println(PathConstants.dbPath);
    }

    private String getDBName(String cmd) {
        int index = cmd.lastIndexOf(" ");
        String name = cmd.substring(index + 1);
        return name;
    }

    private boolean dbExist(String name) {
        File dir = new File(PathConstants.dataRoot + "/" + name);
        return dir.exists();
    }
}
