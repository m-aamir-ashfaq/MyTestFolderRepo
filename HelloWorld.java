package example;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;

/**
 * Created by amirashfaq on 29/07/15.
 */
@WebService()
public class HelloWorld {
  @WebMethod
  public String sayHelloWorldFrom(String from) {
    String result = "Hello, world, from " + from;
    System.out.println(result);
    return result;
  }
  public static void main(String[] argv) {
    Object implementor = new HelloWorld ();
    String address = "http://localhost:9000/HelloWorld";
    Endpoint.publish(address, implementor);
 } 


ALL TOGATHER
@this is a change again    tsddf  dbvdhgfffggfffghghf   morning......
@lets work with MasterCC..that is a localcopy of Master..
@    MASSTTTETERRR
@combined
@    saved,,?

@<<<<<<< HEAD
@finaly edited after a merge
@=======
@>>>>>>> refs/heads/masterCC
}
