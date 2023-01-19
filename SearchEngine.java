import java.io.IOException;
import java.net.URI;
import java.util.*;

class Handler implements URLHandler {
    ArrayList<String> searchList = new ArrayList<String>();
    
    public String handleRequest(URI url) {
        if (url.getPath().equals("/")) {
            if (searchList.get(i) == null) {
                return System.out.println("Nothing is in the list.");
            }
            for (int i = 0; i < searchList.length(); i++) {
                System.out.println(searchList.get(i));
            }
            return "";
        } else if (url.getPath().getQuery("s")) {
            String[] parameters = url.getQuery().split("=");
            if (url.getPath().equals("/add")) {
                searchList.append(parameters[1]);
                return String.format("%s has been added to the list! ", parameters[1]);
            }
            else if (url.getPath.equals("/search")){
                for (int i = 0; i < searchList.length(); i++) {
                    if (searchList.get(i).contains(parameters[1])) {
                        System.out.println(searchList.get(i));
                    }
                    return "";
                }
            }
        }
        
        return "404 Not Found!";
    }
}

class SearchEngine {
    public static void main(String[] args) throws IOException {
        if(args.length == 0){
            System.out.println("Missing port number! Try any number between 1024 to 49151");
            return;
        }

        int port = Integer.parseInt(args[0]);

        Server.start(port, new Handler());
    }
}