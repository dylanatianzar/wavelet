import java.io.IOException;
import java.net.URI;
import java.util.*;

class Handler implements URLHandler {
    ArrayList<String> searchList = new ArrayList<String>();
    
    public String handleRequest(URI url) {
        String[] parameters;
        if (url.getPath().equals("/")) {
            if (searchList.size() == 0) {
                return "No elements have been added to the list.";
            }
            String list = "";
            for (int i = 0; i < searchList.size()-1; i++) {
                list += searchList.get(i) + ",";
            }
            list+=searchList.get(searchList.size()-1);
            return list;
        } else if (url.getPath().contains("/add")) {
            parameters = url.getQuery().split("=");
            if (parameters[0].equals("s")) {
                searchList.add(parameters[1]);
                return String.format("%s has been added to the list! ", parameters[1]);
            }
        } else if (url.getPath().contains("/search")){
            parameters = url.getQuery().split("=");
            if (parameters[0].equals("s")) {
                String list = "";
                for (int i = 0; i < searchList.size()-1; i++) {
                    if (searchList.get(i).contains(parameters[1])) {
                        list += searchList.get(i) + ",";
                    }
                    list+=searchList.get(searchList.size()-1);
                    return list;
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