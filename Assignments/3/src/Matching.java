import java.util.Arrays;

public class Matching extends Question {

	private static final long serialVersionUID = 381684151351862186L;
    protected String choices[][];
	protected int numberOfChoices;

    public Matching(Input in, Output out) {
		super(in, out);
    }

    public void createQuestion() {
		this.getPrompt();
		this.getChoices();
    }
	
	public void getChoices(){
		while(numberOfChoices < 2){
			this.out.promptUser("Enter the number of choices for your Matching question.");
			try{
				numberOfChoices = Integer.parseInt(this.in.getUserResponse());
				if( numberOfChoices < 2){
					this.out.promptUser("Must have at least 2 options");
				}
			}catch(NumberFormatException e){
				this.out.promptUser("Must ender a number");
			}
		}
		this.choices = new String[2][numberOfChoices];
		for(int j = 0; j < this.choices.length; j++){
			this.out.promptUser("Column " + (j + 1));
			for(int i = 0; i < numberOfChoices; i++){
				this.out.promptUser("Enter choice #" + (i + 1));
				this.choices[j][i] = this.in.getUserResponse();
			}
		}
	}

	protected String getQuestionType(){
		return "Matching";
	}

    public void display() {
		this.out.promptUser(this.prompt);	
		char choices[] = {'a', '1'};
		for(int i = 0; i < numberOfChoices; i++){
			String str = "";
			for(int j = 0; j < this.choices.length; j++){
				str +=(choices[j]++ + ") " + this.choices[j][i] + "\t\t");
			}
			this.out.promptUser(str);
		}
		if(this.getCorrectAnswer() != null  && this.getCorrectAnswer().compareTo("") != 0){
			this.out.promptUser("The correct choice is: " + this.getCorrectAnswer());
		}
    }

    public void _modifyChoices() {
    	String temp = this.responses.getCorrectAnswer();
		this.responses.setCorrectAnswer(null);
		this.display();
		this.responses.setCorrectAnswer(temp);
		int column = 0, choice = 0;	
		boolean flag = true;
		do{
			this.out.promptUser("Enter the character corresponding to the choice you would like to modify");	
			String userResponse = this.in.getUserResponse();
			if(userResponse.length() == 1){
				if(userResponse.charAt(0) - 'a' >= 0 && userResponse.charAt(0) - 'a' < this.choices[0].length){
					column = 0;
					choice = userResponse.charAt(0) - 'a';
					flag = false;
					break;
				}
			}
			try{
				choice = Integer.parseInt(userResponse) - 1;
				column = 1;
				flag = false;
				break;
			}catch(NumberFormatException e){}
		}while(flag);
		
		this.out.promptUser("Enter the new option");
		this.choices[column][choice] = this.in.getUserResponse();
    }
    
    protected void showChoices() {
    	char choices[] = {'a', '1'};
		for(int i = 0; i < numberOfChoices; i++){
			String str = "";
			for(int j = 0; j < this.choices.length; j++){
				str +=(choices[j]++ + ") " + this.choices[j][i] + "\t\t");
			}
			this.out.promptUser(str);
		}
    }
    
	protected String _take(){
		String[] allAnswers = new String[this.numberOfChoices];
		String currentAnswer   = "";
		int i;
		for( i = 0; i < this.numberOfChoices; i++){
			do{
				currentAnswer = validAnswer(this.in.getUserResponse());
			}while(currentAnswer == null);
			allAnswers[i] = currentAnswer;
		}
		Arrays.sort(allAnswers);
		return String.join(":.;", allAnswers);
	}

	protected String answerToHumanReadable(String parsed){
		if(parsed == null) {
			return "";
		}
		String[] split = parsed.split(":.;");
		String humanReadable = "\n";
		for(String s : split){
			if(s.length() != 2){
				return "";
			}
			humanReadable += s.charAt(0);
			humanReadable += " ";
			humanReadable += s.charAt(1);
			humanReadable += "\n";
		}
		return humanReadable;
	}

	public void addAnswer(){
		this.display();
		this.out.promptUser("Enter the correct answer");
		this.responses.setCorrectAnswer(this._take());
	}

    protected String validAnswer(String response) {
		char[] result = new char[2];
		for(char a : response.toCharArray()){
			if(a == ' ' || a == ','){
				continue;
			}
			if(a - 'a' >= 0 && a - 'a' < this.numberOfChoices){
				if(result[0] == 0){
					result[0] = a;
					continue;
				}else{
					this.out.promptUser("Please select from the options above");
					return null;
				}
			}
			if(a - '0' >= 0 && a - '9' < this.numberOfChoices){
				if(result[1] == 0){
					result[1] = a;
					continue;
				}else{
					this.out.promptUser("Please select from the options above");
					return null;
				}
			}
		}
		
		if( result[0] != 0 && result[1] != 0){
			return new String(result);
		}
		this.out.promptUser("Please enter each match on their own line ex:\na 3\n b 1\n c 2");
		return null;

	}
}
