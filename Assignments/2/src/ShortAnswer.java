
import java.util.*;

/**
 * 
 */
public class ShortAnswer extends Essay {

	private static final long serialVersionUID = -1063552229976242837L;
    protected int characterLimit;

    public ShortAnswer(Input in, Output out) {
		super(in,out);
    }

	protected String getQuestionType(){
		return "Short Answer";
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
