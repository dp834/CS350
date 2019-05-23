import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

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
		String answer = null;
		this.display();
		while(answer == null){
			this.out.promptUser("Enter the correct Answer");
			answer = this.validResponse(this.in.getUserResponse());
		}
		this.responses.setCorrectAnswer(answer);
	}

    abstract public void display(); 

    public void modify() {
		if(this.getYesNo("Do you wish to modify the prompt?")){
			this._modifyPrompt();
		}
		this._modify();
    }

	protected String getCorrectAnswer(){
		return this.answerToHumanReadable(this.responses.getCorrectAnswer());
	}

	protected String answerToHumanReadable(String parsed){
		if(parsed == null) {
			return "";
		}
		return parsed;
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
		this.out.promptUser("Previous Answer:");
		this.out.promptUser(this.getCorrectAnswer());
		this.responses.setCorrectAnswer(null);
		this.addAnswer();
	}

    public void take() {
       this.out.promptUser(this.prompt);
       this.showChoices();
	   String response = this._take(); 
	   this.responses.addResponse(response);
    }
    
    protected void showChoices() {
    	
    }

	protected String validResponse(String response){
		if(response.length() > 0){
			return "";
		}
		this.out.promptUser("Please enter your response");
		return null;
	}

	protected String _take(){
	   String response = "";
	   do{
		   response = this.validResponse(this.in.getUserResponse());
	   }while(response == null);
	   return response;
	}

    public void tabulate() {
    	this.out.promptUser("Question:");
    	this.display();
    	this.out.promptUser("Replies:");
    	for(String response : this.responses.getResponses()) {
    		this.out.promptUser(this.answerToHumanReadable(response));
    	}
    	this.out.promptUser("Tabulation:");
    	this._showTabulation(this.responses.tabulate());
    	    
    }
    
    protected void _showTabulation(HashMap<String, Integer> tab) {
    	for(String key : tab.keySet()) {
    		this.out.promptUser(tab.get(key) + "\n" + this.answerToHumanReadable(key));
    	}
    }
    
    public String getResponseN(int i) {
    	if(this.responses.getResponses().size() <= i) {
    		return "";
    	}
    	return this.answerToHumanReadable(this.responses.getResponses().get(i));
    }

    public ArrayList<Boolean> grade() {
    	return this.responses.grade();    
    }
    
    public void setIO(Input in, Output out) {
    	this.in = in;
    	this.out = out;
    }
}
