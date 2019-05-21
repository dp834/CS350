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

    public void take() {
        
    }

    public void tabulate() {
        
    }

    public ArrayList<Boolean> grade() {
		return null;
    }
}
