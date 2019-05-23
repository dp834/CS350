import java.util.HashMap;

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

	public void display(){
		this.out.promptUser(this.prompt);	
    	this.out.promptUser("[T]rue\n[F]alse"); 
	}


    public String _take() {
    	String response = "";
    	this.out.promptUser("[T]rue\n[F]alse");
  	   	do{
  	   		response = this.validResponse(this.in.getUserResponse());
  	   	}while(response == null);
  	   	return response;
    	
    }

	protected String validResponse(String response){
		if(response.compareToIgnoreCase("t") == 0 || response.compareToIgnoreCase("true") == 0){
			return "True";
		}else if(response.compareToIgnoreCase("f") == 0 || response.compareToIgnoreCase("false") == 0){
			return "False";
		}
		this.out.promptUser("Please enter t/true for true or f/false for false");
		return null;
	}
	
	protected void _showTabulation(HashMap<String, Integer> tab) {
    	Object count = tab.get("True");
		this.out.promptUser("True" + ": " + ((count == null)? 0 : (int)count));
		count = tab.get("False");
		this.out.promptUser("False" + ": " + ((count == null)? 0 : (int)count));
    	
	}
}
