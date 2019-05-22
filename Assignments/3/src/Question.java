import java.io.Serializable;
import java.util.ArrayList;

public abstract class Question implements Serializable{

	private static final long serialVersionUID = -7734027287665266720L;
	protected String prompt;
    protected ResponseCorrectAnswer responses;
    protected transient Input in;
    protected transient Output out;

    public Question(Input in, Output out) {
    	this.in=in;
    	this.out=out;
		this.createQuestion();
		this.responses = new ResponseCorrectAnswer();
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
		this.responses.setCorrectAnswer(this.in.getUserResponse());
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
		this.addAnswer();
	}

    public void take() {
       this.out.promptUser(this.prompt);
	   this._take(); 

	   String response = "";
	   while(!this.validResponse(response)){
		   response = this.in.getUserResponse();
	   }
	   this.responses.addResponse(response);
    }

	protected boolean validResponse(String response){
		return response.length() > 0;
	}

	protected void _take(){
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
