
public class Ranking extends Matching {

	private static final long serialVersionUID = -8821892320996028489L;

    public Ranking(Input in, Output out) {
		super(in,out);
    }

	protected String getQuestionType(){
		return "Ranking";
	}

	public void getChoices(){
		while(numberOfChoices < 2){
			this.out.promptUser("Enter the number of choices for your " + this.getQuestionType() + " question.");
			try{
				numberOfChoices = Integer.parseInt(this.in.getUserResponse());
				if( numberOfChoices < 2){
					this.out.promptUser("Must have at least 2 options");
				}
			}catch(NumberFormatException e){
				this.out.promptUser("Must ender a number");
			}
		}
		this.choices = new String[1][numberOfChoices];
		for(int j = 0; j < this.choices.length; j++){
			for(int i = 0; i < numberOfChoices; i++){
				this.out.promptUser("Enter choice #" + (i + 1));
				this.choices[j][i] = this.in.getUserResponse();
			}
		}
	}
	
	protected String validAnswer(String response) {
		String result = "";	
		for(char a : response.toCharArray()){
			if(a == ' ' || a == ','){
				continue;
			}
			if(a - 'a' >= 0 && a - 'a' < this.numberOfChoices){
				if(result.length() == 0){
					result += a;
				}else{
					this.out.promptUser("Please select from the options above");
					return null;
				}
			}else {
				this.out.promptUser("Please select from the options above");
				return null;
			}
		}
		if(result.length() == 1){
			return result;
		}
		this.out.promptUser("Select One option at a time");
		return null;
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
		return String.join(":.;", allAnswers);
	}
	
	protected String answerToHumanReadable(String parsed){
		if(parsed == null) {
			return "";
		}
		String[] split = parsed.split(":.;");
		String humanReadable = "\n";
		for(String s : split){
			if(s.length() != 1){
				return "";
			}
			humanReadable += s.charAt(0);
			humanReadable += "\n";
		}
		return humanReadable;
	}
}
