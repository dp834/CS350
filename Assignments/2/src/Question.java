
import java.io.Serializable;
import java.util.*;

/**
 * 
 */
public abstract class Question implements Serializable{

	private static final long serialVersionUID = -7734027287665266720L;
	protected String prompt;
    protected String correctAnswer;
    protected ResponseCorrectAnswer responses;
    protected transient Input in;
    protected transient Output out;

    public Question(Input in, Output out) {
    	this.in=in;
    	this.out=out;
		this.createQuestion();
    }

    /**
     * @return
     */
    public void createQuestion() {
       this.getPrompt(); 
    }

	protected void getPrompt(){
		this.out.promptUser("Enter the prompt for your " + this.getQuestionType() + " question");
		this.prompt = this.in.getUserResponse();	
	}

	abstract protected String getQuestionType();

	public void addAnswer(){
		this.out.promptUser("Enter the correct Answer");
		this.correctAnswer = this.in.getUserResponse();
	}

    abstract public void display(); 

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

    public void setIO(Input in, Output out) {
    	this.in = in;
    	this.out = out;
    }

}
