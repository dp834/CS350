
import java.util.*;

/**
 * 
 */
public class ConsoleInput implements Input {

    public Scanner scanner;
    /**
     * Default constructor
     */
    public ConsoleInput() {
	this.scanner = new Scanner(System.in);
    }


    /**
     * @return
     */
    public String getUserResponse() {
        return scanner.next(); 
    }

}
