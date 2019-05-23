import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class ResponseCorrectAnswer implements Serializable{

	private static final long serialVersionUID = -7734013244817190389L;
    private String correctAnswer;
    private ArrayList<String> responses;

    public ResponseCorrectAnswer() {
		this.responses = new ArrayList<String>();
    }

    public ArrayList<String> getResponses() {
		return responses;
    }

    public void setCorrectAnswer(String answer) {
		this.correctAnswer = answer;
    }
    
    public String getCorrectAnswer() {
    	return this.correctAnswer;
    }

    public void addResponse(String response) {
		this.responses.add(response);
    }

    public ArrayList<Boolean> grade() {
		ArrayList<Boolean> results = new ArrayList<Boolean>();
		if(this.correctAnswer == null || this.correctAnswer.compareTo("") == 0){
			return null;
        }
		for(String response : this.responses) {
			results.add(response.compareToIgnoreCase(this.correctAnswer) == 0);
		}
		return results;
    }


    public HashMap<String, Integer> tabulate() {
		HashMap<String, Integer> tabulated = new HashMap<String, Integer>();
		for(String response : this.responses) {
			tabulated.merge(response, 1, Integer::sum);
		}	
		return tabulated;
    }

}
