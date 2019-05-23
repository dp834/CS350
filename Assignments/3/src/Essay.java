import java.util.ArrayList;

public class Essay extends Question {

	private static final long serialVersionUID = 4843303662256111181L;

    public Essay(Input in, Output out) {
		super(in, out);
    }

    public void display() {
       this.out.promptUser(this.prompt); 
    }

	protected String getQuestionType(){
		return "Essay";
	}

    public void _modify() {
        
    }

	protected String validResponse(String response){
		String resp = (response.length() > 0) ? response : null;
		if(resp == null) {
			this.out.promptUser("Please enter your response");
		}
		return resp;
	}	

	/* Essays cannot be graded */
	public ArrayList<Boolean> grade() {
		return null;
    }
}
