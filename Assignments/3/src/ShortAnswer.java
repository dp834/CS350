import java.util.ArrayList;

public class ShortAnswer extends Essay {

	private static final long serialVersionUID = -1063552229976242837L;
    protected int characterLimit;

    public ShortAnswer(Input in, Output out) {
		super(in,out);
    }

	protected String getQuestionType(){
		return "Short Answer";
	}


	public void createQuestion(){
		super.createQuestion();
		this.getCharacterLimit();
	}

    public void display() {
        this.out.promptUser(this.prompt);
		this.out.promptUser("Character limit: " + this.characterLimit);
		if(this.responses.getCorrectAnswer() != null){
			this.out.promptUser("The correct choice is: " + this.responses.getCorrectAnswer());
		}
    }

	protected void getCharacterLimit(){
		this.characterLimit = -1;
		while(this.characterLimit < 1){
			this.out.promptUser("Enter a character limit, minimum 1");
			try{
				this.characterLimit = Integer.parseInt(this.in.getUserResponse());
			}catch(NumberFormatException e){
				this.out.promptUser("Please enter a number");
			}
		}
	}

    public void _modify() {
    	if(this.getYesNo("Do you wish to change the character limit?")){
			this._modifyCharacterLimit();
		}
    }

	protected void _modifyCharacterLimit(){
		this.getCharacterLimit();
	}

	protected String validResponse(String response){
		if(super.validResponse(response) == null) {
			return null;
		}
		String resp = (response.length() <= this.characterLimit) ? response : null;
		if(resp == null) {
			this.out.promptUser("Too many characters entered. Limit is " + this.characterLimit);
		}
		return resp;
		
	}	
	
    public ArrayList<Boolean> grade() {
    	return this.responses.grade();    
    }
	
    public String _take() {
       this.out.promptUser("Character limit: " + this.characterLimit); 
       return super._take();
    }
}