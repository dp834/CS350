
import java.util.*;

/**
 * 
 */
public class Ranking extends Matching {

	private static final long serialVersionUID = -8821892320996028489L;
	protected String prompt;
    protected String correctAnswer;
    protected ResponseCorrectAnswer responses;
    protected String choices[][];
    protected Input in;
    protected Output out;

    public Ranking(Input in, Output out) {
		super(in,out);
    }

	protected String getQuestionType(){
		return "Ranking";
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
