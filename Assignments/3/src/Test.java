import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * 
 */
public class Test extends Survey {

    /**
	 * 
	 */
	private static final long serialVersionUID = 5120122415979633417L;

    /**
     * @param input 
     * @param output
     */
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

    /**
     * @return
     */
    public void addQuestion(Question question) {
    	question.addAnswer(); 
    	questions.add(question);
    }

    /**
     * @return
     */
/*    public void saveToFile() {
        // TODO implement here
        
    }
*/
    /**
     * @param input 
     * @param output 
     * @return
     */
/*
    public static Test loadFromFile(Input input, Output output) {
		return null;
        // TODO implement here
        
    }
	*/

    /**
     * @return
     */
    public void modify() {
        // TODO implement here
        
    }

    /**
     * @return
     */
    public void take() {
        // TODO implement here
        
    }

    /**
     * @return
     */
    public void tabulate() {
        // TODO implement here
        
    }

    /**
     * @return
     */
    public void grade() {
        // TODO implement here
        
    }

	/** 
	 * @return
	 */
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
    
	public String getMenuPrompt(){
		String prompt = "Please enter the number corresponding to your choice\n" + 
			"Test Menu\n" +
			"1) Create new Test \n" +
			"2) Display a Test \n" +
			"3) Load a Test \n" +
			"4) Save a Test \n" +
			"5) Quit\n";
		return prompt;
	}

}
