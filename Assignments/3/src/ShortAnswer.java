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
		if(this.correctAnswer != null){
			this.out.promptUser("The correct choice is: " + this.correctAnswer);
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

    public void take() {
        
    }

    public void tabulate() {
        
    }

    public ArrayList<Boolean> grade() {
		return null;
        
    }
}
