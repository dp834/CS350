
import java.util.*;

/**
 * 
 */
public class Test extends Survey {

    private static long serialVersionUID;

    /**
     * @param input 
     * @param output
     */
    public Test(Input input, Output output) {
		super(input, output);
    }



    /**
     * @return
     */
	/*
    public static Test createNew() {
    }
	*/

    /**
     * @return
     */
    /**public void display() {
        // TODO implement here
        
    }*/

    /**
     * @return
     */
    public void addQuestion() {
        // TODO implement here
        
    }

    /**
     * @return
     */
/*    public void saveToFile() {
        // TODO implement here
        
    }
*/
    /**
     * @param input 
     * @param output 
     * @return
     */
/*
    public static Test loadFromFile(Input input, Output output) {
		return null;
        // TODO implement here
        
    }
	*/

    /**
     * @return
     */
    public void modify() {
        // TODO implement here
        
    }

    /**
     * @return
     */
    public void take() {
        // TODO implement here
        
    }

    /**
     * @return
     */
    public void tabulate() {
        // TODO implement here
        
    }

    /**
     * @return
     */
    public void grade() {
        // TODO implement here
        
    }

    /**
     * @return
     */
    public void menu() {
        // TODO implement here
        
    }

	public static String getMenuPrompt(){
		String prompt = "Please enter the number corresponding to your choice\n" + 
			"Test Menu\n" +
			"1) Create new Test \n" +
			"2) Display a Test \n" +
			"3) Load a Test \n" +
			"4) Save a Test \n" +
			"5) Quit\n";
		return prompt;
	}

}
