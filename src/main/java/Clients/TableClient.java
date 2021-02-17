package Clients;

import Statics.PathConstants;

public class TableClient extends DBMSClient {
    public void processCommand(String cmd) {
        if(PathConstants.dbPath.equals("")) {
            System.out.println("Please select your database first");
            return;
        }
    }
}
