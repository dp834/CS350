
import java.util.*;

/**
 * 
 */
public class Matching extends Question {

	private static final long serialVersionUID = 381684151351862186L;
    protected String choices[][];

    public Matching(Input in, Output out) {
		super(in, out);
    }

    public void createQuestion() {
		this.getPrompt();
		this.getChoices();
    }
	
	public void getChoices(){

	}

	protected String getQuestionType(){
		return "Matching";
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
