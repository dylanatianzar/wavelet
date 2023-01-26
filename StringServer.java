import java.io.IOException;
import java.net.URI;

class Handler implements URLHandler{
    public String handleRequest(URI url){
        return "404 not found!";
    }
}

public class StringServer {
    
}
