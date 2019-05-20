import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

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

    public void modify() {
        
    }

    public void take() {
        
    }

    public void tabulate() {
        
    }

    public void grade() {
        
    }

	public Test loadFromFile() {
		@SuppressWarnings("static-access")
		File folder = new File(this.FOLDER_PATH);
		File files[] = folder.listFiles();
		Test test = this;
		if(files == null) {
			this.out.promptUser("Error getting saved " + this.getFormType());
			return test;
		}

		this.out.promptUser("Please enter the name of the " + this.getFormType() + " you would like to load");
		for(File file: files) {
			String f = file.getName();
			if(f.endsWith("." + this.getFormType())) {
				this.out.promptUser(f);
			}
		}
		String response = this.in.getUserResponse();
		
		try {
			@SuppressWarnings("static-access")
			FileInputStream streamIn = new FileInputStream(this.FOLDER_PATH + response);
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
		String prompt = "Please enter the number corresponding to your choice\n" + 
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
