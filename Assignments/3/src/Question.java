import java.io.Serializable;
import java.util.ArrayList;

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

    public void modify() {
		if(this.getYesNo("Do you wish to modify the prompt?")){
			this._modifyPrompt();
		}
		this._modify();
    }

	protected void _modify(){
		if(this.getYesNo("Do you wish to modify the choices?")){
			this._modifyChoices();
		}
	}

	protected boolean getYesNo(String prompt){
		this.out.promptUser(prompt);
		String userResponse = this.in.getUserResponse();
		while(userResponse.compareToIgnoreCase("yes") != 0 && userResponse.compareToIgnoreCase("no") != 0){
			this.out.promptUser("Enter yes or no");
			userResponse = this.in.getUserResponse();	
		}
		if(userResponse.compareToIgnoreCase("no") == 0){
			return false;
		}
		return true;
	}


	protected void _modifyChoices(){
		
	}

	protected void _modifyPrompt(){
		this.out.promptUser(this.prompt);
		this.out.promptUser("\nEnter a new prompt:");
		this.prompt = this.in.getUserResponse();
	}

	public void modifyAnswer(){
		if(this.getYesNo("Do you wish to modify the answer? (yes/no)")){
			this._modifyAnswer();
		}
	}

	protected void _modifyAnswer(){
	}

    public void take() {
        
    }

    public void tabulate() {
        
    }

    /**
     * @return
     */
    public ArrayList<Boolean> grade() {
    	return null;    
    }

    public void setIO(Input in, Output out) {
    	this.in = in;
    	this.out = out;
    }

}
