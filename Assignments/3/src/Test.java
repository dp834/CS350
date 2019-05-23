import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class Test extends Survey {

	private static final long serialVersionUID = 5120122415979633417L;	

	protected static final int MENU_OPTION_GRADE = Survey.MENU_OPTION_QUIT;
	protected static final int MENU_OPTION_QUIT  = MENU_OPTION_GRADE + 1;

    public Test(Input input, Output output) {
		super(input, output);
    }

	@Override
	protected String getFormType(){
		return "Test";
	}

	@Override
	public Survey createNew() {
		Test test = new Test(this.in, this.out);
		test.getNameFromUser();
		test.getQuestionsFromUser();
		return test;
	}

    public void addQuestion(Question question) {
    	question.addAnswer(); 
    	questions.add(question);
    }

	protected void _modify(int questionOption){
		super._modify(questionOption);
		this.questions.get(questionOption).modifyAnswer();	
	}

    public void grade() {
    	if(this.name == null || this.name.compareTo("") == 0){
			this.out.promptUser("Please load a " + this.getFormType() + " to tabulate\n\n");
			return;
		}
    	ArrayList<ArrayList<Boolean>> gradedQuestions = new ArrayList<ArrayList<Boolean>>();
		for(Question q : this.questions){
			gradedQuestions.add(q.grade());
		} 
		this.showAllGrades(gradedQuestions);
		
    }
    
    protected void showAllGrades(ArrayList<ArrayList<Boolean>> allGrades) {
    	for(int i = 0; i < allGrades.get(0).size(); i++) {
    		int j=0;
    		int correct = 0;
    		int possible = 0;
    		this.out.promptUser("***************************************************");
    		this.out.promptUser("Grading response " + (j+1));
    		for(Question q : this.questions) {
    			this.out.promptUser("\nQuestion" + (j + 1) + ":");
    			q.display();
    			this.out.promptUser("Response: ");
    			this.out.promptUser(q.getResponseN(i));
    			if(allGrades.get(j) == null) {
    				this.out.promptUser("Question wasn't Graded");
    			}else {
    				possible++;
    				if(allGrades.get(j).get(i)) {
    					correct++;
    					this.out.promptUser("Correct");
    				}else {
    					this.out.promptUser("Incorrect");
    				}
    			}
    			j++;
    		}
    		this.out.promptUser("Score: " + correct + "/" + possible + " = " + ((double)correct)/possible*100 + "%");
    	}
    }

	protected Test _loadFromFile(String fileName){
		Test test = this;
		try {
			@SuppressWarnings("static-access")
			FileInputStream streamIn = new FileInputStream(this.FOLDER_PATH + fileName);
			ObjectInputStream objStreamIn = new ObjectInputStream(streamIn);
			test = (Test) objStreamIn.readObject();
			objStreamIn.close();
		}catch(FileNotFoundException e) {
			this.out.promptUser("Could not find file, check spelling?");
		}catch(IOException e) {
			this.out.promptUser("Error loading file, please try again");
		}catch(ClassNotFoundException e) {
			this.out.promptUser("Error loading file, please try again");
		}
		
		test.setIO(this.in, this.out);
		for(Question q : test.questions){
			q.setIO(test.in, test.out);
		}

		return test;
	}


	public Test menuHandler(int choice){
		switch(choice)
		{
			case MENU_OPTION_GRADE:
			{
				this.grade();
				break;
			}
			case MENU_OPTION_QUIT:
			{
				return null;
			}
			default:
			{		
				return (Test) super.menuHandler(choice);
			}
		}
		return this;
	}
    
	public String getMenuPrompt(){
		String prompt = "\n------------------------------------------------\n" + 
			"Please enter the number corresponding to your choice\n" + 
			"Test Menu\n" +
			"1) Create new Test \n" +
			"2) Display a Test \n" +
			"3) Load a Test \n" +
			"4) Save a Test \n" +
			"5) Modify an existing Test\n" +
			"6) Take a Test\n" +
			"7) Tabulate a Test\n" +
			"8) Grade a Test\n" +
			"9) Quit\n";
		return prompt;
	}

}
