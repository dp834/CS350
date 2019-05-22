import java.util.ArrayList;

public class TrueFalse extends MultipleChoice {

	private static final long serialVersionUID = -5349186905736383941L;
	
    public TrueFalse(Input in, Output out) {
		super(in, out);
    }

	protected String getQuestionType(){
		return "True/False";
	}

	public void getOptions(){
		this.numberOfChoices = 2;
		this.choices = new String[this.numberOfChoices];
		this.choices[0] = "True";
		this.choices[1] = "False";		
	}

	/* removes choice prompt */
	protected void _modify(){
	}

    public void _take() {
       this.out.promptUser("[T]rue|[F]alse"); 
    }

	protected boolean validResponse(String response){
		if(response.compareToIgnoreCase("t") == 0 || response.compareToIgnoreCase("true") == 0){
			return true;
		}else if(response.compareToIgnoreCase("false") == 0 || response.compareToIgnoreCase("false") == 0){
			return true;
		}
		return false;
	}

    public void tabulate() {
        
    }

    public ArrayList<Boolean> grade() {
		return null;
        
    }
}
