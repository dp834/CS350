
import java.util.*;

/**
 * 
 */
public class MultipleChoice extends Question {

	private static final long serialVersionUID = -7962475311863650987L;
	protected String[] choices;

    public MultipleChoice(Input in, Output out) {
		super(in, out);
    }

    public void createQuestion() {
    	this.getPrompt();
		this.getOptions();  
    }

	protected String getQuestionType(){
		return "Multiple Choice";
	}

	public void getOptions(){
		
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
		return null;
        // TODO implement here
        
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
