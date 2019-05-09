
import java.util.*;

/**
 * 
 */
public class Survey {

	public static final int MENU_OPTION_INVALID = 0;
	public static final int MENU_OPTION_CREATE  = 1;
	public static final int MENU_OPTION_DISPLAY = 2;
	public static final int MENU_OPTION_LOAD    = 3;
	public static final int MENU_OPTION_SAVE    = 4;
	public static final int MENU_OPTION_QUIT    = 5;


    private static long serialVersionUID;
    protected String name;
    protected ArrayList<Question> questions;
    protected Input in;
    protected Output out;








    /**
     * @param input 
     * @param output
     */
    public Survey(Input input, Output output) {
		this.in  = input;
		this.out = output;
    }

    /**
     * @return
     */
    public static Survey createNew(Input in, Output out) {
        // TODO implement here
       	out.promptUser("Create New"); 
		return null;
    }

    /**
     * @return
     */
    public void display() {
        // TODO implement here
       	out.promptUser("Display"); 
    }

    /**
     * @return
     */
    public void addQuestion() {
        // TODO implement here
        
    }

    public void saveToFile() {
		out.promptUser("Save to File");
    }

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
    public void menu() {
        // TODO implement here
        
    }

    /**
     * @param input 
     * @param output 
     * @return
     */
    public static Survey loadFromFile(Input in, Output out) {
		out.promptUser("Load from File");
		return null;
    }

	public static String getMenuPrompt(){
		String prompt = "Please enter the number corresponding to your choice\n" + 
			"Survey Menu\n" +
			"1) Create new Survey\n" +
			"2) Display a Survey\n" +
			"3) Load a Survey\n" +
			"4) Save a Survey\n" +
			"5) Quit\n";
		return prompt;
	}
}
