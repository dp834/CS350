
import java.util.*;

/**
 * 
 */
public class Essay extends Question {

	private static final long serialVersionUID = 4843303662256111181L;

    public Essay(Input in, Output out) {
		super(in, out);
    }

    public void display() {
       this.out.promptUser(this.prompt); 
    }

	protected String getQuestionType(){
		return "Essay";
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
