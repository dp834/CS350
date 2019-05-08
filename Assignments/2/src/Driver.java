
import java.util.*;

/**
 * 
 */
public class Driver {

    /**
     * Default constructor
     */
    public Driver() {
    }

    /**
     * 
     */
    private Survey currentForm;

    /**
     * 
     */
    private int currentFormType;




    /**
     * @param args 
     * @return
     */
    public void main(String args) {
        // TODO implement here
        
    }

    /**
     * @return
     */
    private void selectType() {
        // TODO implement here
        
    }


	public static void main(String[] args){
		Input in = new ConsoleInput();
		Output out = new ConsoleOutput();
		out.promptUser("Enter your name");
		out.promptUser("Hello " + in.getUserResponse());
		
	}

}
