package Clients;

import Statics.PathConstants;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;

public class TableClient extends DBMSClient {
    public void processCommand(String cmd) {
        if(PathConstants.dbPath.equals("")) {
            System.out.println("Please select your database first");
            return;
        }

        //TODO better check method to avoid edge cases when table name contains those key words
        if(cmd.contains("create")) {
           createTable(cmd);
        } else if (cmd.contains("show")) {
            showTables();
        } else if (cmd.contains("drop")) {
            dropTables(cmd);
        }
    }

    private void showTables () {
        File file = new File(PathConstants.dataRoot + "/" + PathConstants.dbPath);
        String[] files = file.list(new FilenameFilter() {

            public boolean accept(File dir, String name) {
                return new File(dir, name).isFile();
            }
        });

        for(String s : files) {
            String[] splits = s.split("\\.");
            System.out.println(splits[0]);
        }
    }

    private void createTable(String cmd) {
        //TODO: Add optional command handle
        //get table name
        String name = getTableName(cmd);
        if(tableExist(name)) {
            System.out.println("table already exists");
            return;
        }
        File file = new File(PathConstants.dataRoot + "/" + PathConstants.dbPath + "/" + name + ".csv");
        try {
            file.createNewFile();
        } catch (IOException e) {
            System.out.println("Table already exists");
        }
    }

    private void dropTables(String cmd) {
        String name = getTableName(cmd);
        if(!tableExist(name)) {
            System.out.println("table not exist");
            return;
        }
        File file = new File(PathConstants.dataRoot + "/" + PathConstants.dbPath + "/" + name + ".csv");
        file.delete();
    }


    private String getTableName(String cmd) {
        int index = cmd.lastIndexOf(" ");
        String name = cmd.substring(index + 1);
        return name;
    }

    private boolean tableExist(String name) {
        File file = new File(PathConstants.dataRoot + "/" + PathConstants.dbPath + "/" + name + ".csv");
        return file.exists();
    }


}
