import java.util.ArrayList;

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
				str +=(choices[j]++ + ") " + this.choices[j][i] + "\t");
			}
			this.out.promptUser(str);
		}
		if(this.responses.getCorrectAnswer() != null ){
			this.out.promptUser("The correct choice is: " + this.responses.getCorrectAnswer());
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

    public void take() {
        
    }

    public void tabulate() {
        
    }

    public ArrayList<Boolean> grade() {
		return null;
    }

}
