
import java.util.*;

/**
 * 
 */
public class ConsoleOutput implements Output {

    public ConsoleOutput() {
    }

    /**
     * @param output 
     * @return
     */
    public void promptUser(String output) {
       System.out.println(output); 
    }

}
