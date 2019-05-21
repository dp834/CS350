import java.util.ArrayList;

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
		this.choices = new String[1][numberOfChoices];
		for(int j = 0; j < this.choices.length; j++){
			for(int i = 0; i < numberOfChoices; i++){
				this.out.promptUser("Enter choice #" + (i + 1));
				this.choices[j][i] = this.in.getUserResponse();
			}
		}
	}
	
    public void take() {
        
    }

    public void tabulate() {
        
    }

    public ArrayList<Boolean> grade() {
		return null;
    }
}
