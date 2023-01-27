import java.io.IOException;
import java.net.URI;
import java.util.*;

class Handler implements URLHandler{
    String wholeList = "";

    public String handleRequest(URI url){
        if (url.getQuery() == null) {
            return "Add a message to string with /add-message";
        }
        String[] parameters = url.getQuery().split("=");
        if (url.getPath().contains("/add-message") && 
                parameters[0].equals("s")){
            wholeList += parameters[1] + "\n";
            return wholeList;
        }
        return "404 not found!";
    }
}

public class StringServer {
    public static void main(String[] args) throws IOException{
        if (args.length == 0) {
            System.out.println("Missing Port Number!");
            return;
        }

        int port = Integer.parseInt(args[0]);
        Server.start(port, new Handler());
    }
}
