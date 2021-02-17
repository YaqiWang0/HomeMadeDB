import Clients.DBMSClient;
import Clients.DatabaseClient;
import Clients.TableClient;

public class DatabaseClientFactory {
    public DBMSClient getDatabaseClient(String cmd) {
        DBMSClient client = null;
        if(cmd.contains("database")) {
            client =  new DatabaseClient();
        } else if(cmd.contains("table")){
            client =  new TableClient();
        }

        return client;
    }
}
