import java.util.Arrays;
import java.util.HashMap;

public class MultipleChoice extends Question {

	private static final long serialVersionUID = -7962475311863650987L;
	protected String[] choices;
	protected int numberOfChoices;
	protected int requiredAnswers;

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
				this.out.promptUser("Must enter a number");
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
		while(this.requiredAnswers >= this.numberOfChoices || this.requiredAnswers < 1){
			this.out.promptUser("How many choices should be selected?");
			try{
				this.requiredAnswers = Integer.parseInt(this.in.getUserResponse());
				if(this.requiredAnswers >= this.numberOfChoices){
					this.out.promptUser("Must require less than the total number of options");
				}else if (this.requiredAnswers < 0) {
					this.out.promptUser("Must require at least one option");
				}
			}catch(NumberFormatException e){
				this.out.promptUser("Must enter a number");
			}
		}

	}

    public void display() {
		this.out.promptUser(this.prompt);
		this.out.promptUser("Must select " + this.requiredAnswers + " options");
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
	
	protected String _take(){
    	return super._take();
	}
	
	protected void showChoices() {
		char choice = 'a';
    	for( String opt : this.choices ){
			this.out.promptUser(choice++ + ") " + opt);   
		} 
	}

	protected String validResponse(String response){
		char[] answers = new char[this.requiredAnswers];	
		int i = 0;
		for(char a : response.toLowerCase().toCharArray()){
			if( a == ' ' || a == ','){
				continue;
			}
			if( a - 'a' >= 0 && a - 'a' < this.numberOfChoices){
				if( i < answers.length){
					answers[i] = a;
					i += 1;
				}else{
					this.out.promptUser("Please select from the options above");
					return null;
				}
			}else{
				this.out.promptUser("Please select from the options above");
				return null;
			}
		}
		if(i != this.requiredAnswers){
			this.out.promptUser("Please selected " + this.requiredAnswers + " options entered on the same line (ex ab or ac)");
			return null;
		}
		Arrays.sort(answers);
		return new String(answers);
	}
	
	protected void _showTabulation(HashMap<String, Integer> tab) {
    	if(this.requiredAnswers > 1) {
    		for(String key : tab.keySet()) {
    			this.out.promptUser(tab.get(key) + "\n" + this.answerToHumanReadable(key));
    		}
    	}else {
    		char choice = 'a';
        	for(int i = 0; i < this.numberOfChoices; i++) {
        		Object count = tab.get(Character.toString(choice));
        		this.out.promptUser(choice++ + ": " + ((count == null)? 0 : (int)count));
        	}
        }
    }
}
