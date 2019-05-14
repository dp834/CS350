
import java.util.*;

/**
 * 
 */
public class TrueFalse extends MultipleChoice {

	private static final long serialVersionUID = -5349186905736383941L;
	
    public TrueFalse(Input in, Output out) {
		super(in, out);
    }

	protected String getQuestionType(){
		return "True/False";
	}

	public void getOptions(){
		this.numberOfChoices = 2;
		this.choices = new String[this.numberOfChoices];
		this.choices[0] = "True";
		this.choices[1] = "False";		
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

}
