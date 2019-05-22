import java.util.ArrayList;

public class MultipleChoice extends Question {

	private static final long serialVersionUID = -7962475311863650987L;
	protected String[] choices;
	protected int numberOfChoices;

    public MultipleChoice(Input in, Output out) {
		super(in, out);
    }

    public void createQuestion() {
    	this.getPrompt();
		this.getOptions();  
    }

	protected String getQuestionType(){
		return "Multiple Choice";
	}

	public void getOptions(){
		while(numberOfChoices < 2){
			this.out.promptUser("Enter the number of choices for your multiple-choice question.");
			try{
				numberOfChoices = Integer.parseInt(this.in.getUserResponse());
				if( numberOfChoices < 2){
					this.out.promptUser("Must have at least 2 options");
				}
			}catch(NumberFormatException e){
				this.out.promptUser("Must ender a number");
			}
		}
		this.choices = new String[numberOfChoices];
		for(int i = 0; i < numberOfChoices; i++){
			if(this.choices[i] != null){
				continue;
			}
			this.out.promptUser("Enter choice #" + (i + 1));
			this.choices[i] = this.in.getUserResponse();
		}
	}

    public void display() {
		this.out.promptUser(this.prompt);	
		char choice = 'a';
    	for( String opt : this.choices ){
			this.out.promptUser(choice++ + ") " + opt);   
		} 
		if(this.responses.getCorrectAnswer() != null ){
			this.out.promptUser("The correct choice is: " + this.responses.getCorrectAnswer());
		}
    }

	protected void _modifyChoices(){
		this.out.promptUser("Which choice do you want to modify?");
		char choice = 'a';
    	for( String opt : this.choices ){
			this.out.promptUser(choice++ + ") " + opt);   
		} 
		String userResponse = this.in.getUserResponse();
		while(userResponse.length() != 1 || userResponse.charAt(0) < 'a' || userResponse.charAt(0) > 'a'+this.numberOfChoices){
			this.out.promptUser("Please enter the character corresponding to your choice");
		}
		this.out.promptUser("Enter the new choice");
		this.choices[userResponse.charAt(0) - 'a'] = this.in.getUserResponse();
	}
	
	protected void _take(){
		char choice = 'a';
    	for( String opt : this.choices ){
			this.out.promptUser(choice++ + ") " + opt);   
		} 
	}

	protected boolean validResponse(String response){
		boolean valid = false;	
		if(response.length() < 1){
			return false;
		}

		for(char a : response.toCharArray()){
			if( a == ' ' || a == ','){
				continue;
			}
			if( a - 'a' >= 0 && a - 'a' < this.numberOfChoices){
				valid = true;
			}else{
				return false;
			}
		}
		return valid;
	}

    public void tabulate() {
        
    }

    public ArrayList<Boolean> grade() {
		return null;
        
    }
}
