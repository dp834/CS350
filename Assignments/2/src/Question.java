
import java.util.*;

/**
 * 
 */
public abstract class Question {

    /**
     * Default constructor
     */
    public Question() {
    }

    /**
     * 
     */
    private static long serialVersionUID;

    /**
     * 
     */
    protected String prompt;

    /**
     * 
     */
    protected String correctAnswer;

    /**
     * 
     */
    protected ResponseCorrectAnswer responses;

    /**
     * 
     */
    protected Input input;

    /**
     * 
     */
    protected Output output;





    /**
     * @return
     */
    public void createQuestion() {
        // TODO implement here
        
    }

    /**
     * @return
     */
    public void display() {
        // TODO implement here
        
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
    public ArrayList<Boolean> grade() {
        // TODO implement here
    	return null;    
    }

    /**
     * @param input 
     * @return
     */
    public void setInput(Input input) {
        // TODO implement here
        
    }

    /**
     * @param output 
     * @return
     */
    public void setOutput(Output output) {
        // TODO implement here
        
    }

}
