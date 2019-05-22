import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class Survey implements Serializable{

	private static final long serialVersionUID = 1L;

	protected static final int MENU_OPTION_INVALID = 0;
	protected static final int MENU_OPTION_CREATE  = 1;
	protected static final int MENU_OPTION_DISPLAY = 2;
	protected static final int MENU_OPTION_LOAD    = 3;
	protected static final int MENU_OPTION_SAVE    = 4;
	protected static final int MENU_OPTION_MODIFY  = 5;
	protected static final int MENU_OPTION_TAKE    = 6;
	protected static final int MENU_OPTION_TABULATE= 7;
	protected static final int MENU_OPTION_QUIT    = 8;

	protected static final int QUESTION_OPTION_INVALID   = 0;
	protected static final int QUESTION_OPTION_T_F       = 1;
	protected static final int QUESTION_OPTION_M_C       = 2;
	protected static final int QUESTION_OPTION_SHORT_ANS = 3;
	protected static final int QUESTION_OPTION_ESSAY     = 4;
	protected static final int QUESTION_OPTION_RANKING   = 5;
	protected static final int QUESTION_OPTION_MATCHING  = 6;
	protected static final int QUESTION_OPTION_DONE      = 7;

	protected static final int PROMPT_QUESTION = 1;

	protected final static String FOLDER_PATH = "resources/Forms/";

	protected String name;
	protected ArrayList<Question> questions;
	protected transient Input in;
	protected transient Output out;


	public Survey(Input input, Output output) {
		this.in  = input;
		this.out = output;
		this.questions = new ArrayList<Question>();
		this.name = "";
	}

	public Survey createNew() {
		Survey survey = new Survey(this.in, this.out);
		survey.getNameFromUser();
		survey.getQuestionsFromUser();
		return survey;
	}

	protected void getNameFromUser(){
		this.out.promptUser("Name your " + this.getFormType() + ":");
		this.name = this.in.getUserResponse();
	}

	protected void printPrompt(int prompt){
		switch(prompt){
			case PROMPT_QUESTION:
				{
					String p = "1) Add a new T/F question\n" +
						"2) Add a new multiple choice question\n" +
						"3) Add a new short answer question\n" +
						"4) Add a new essay question\n" +
						"5) Add a new ranking question\n" +
						"6) Add a new matching question\n" +
						"7) Done adding question\n";
					this.out.promptUser(p);
					break;
				}
			default:{break;}
		}
	}

	protected void getQuestionsFromUser(){
		int userResponse = Survey.QUESTION_OPTION_INVALID;
		do{
			this.printPrompt(PROMPT_QUESTION);			
			try{
				userResponse = Integer.parseInt(this.in.getUserResponse());
				this.out.promptUser("\n");
				switch(userResponse)
				{
					case QUESTION_OPTION_T_F:
						{
							this.addQuestion(new TrueFalse(this.in, this.out));
							break;
						}
					case QUESTION_OPTION_M_C:
						{
							this.addQuestion(new MultipleChoice(this.in, this.out));
							break;
						}
					case QUESTION_OPTION_SHORT_ANS:
						{
							this.addQuestion(new ShortAnswer(this.in, this.out));
							break;
						}
					case QUESTION_OPTION_ESSAY:
						{
							this.addQuestion(new Essay(this.in, this.out));
							break;
						}
					case QUESTION_OPTION_RANKING:
						{
							this.addQuestion(new Ranking(this.in, this.out));
							break;
						}
					case QUESTION_OPTION_MATCHING:
						{
							this.addQuestion(new Matching(this.in, this.out));
							break;
						}
					case QUESTION_OPTION_DONE:
						{
							break;
						}
					default:
						{
							this.out.promptUser("Invalid option select a number corresponding to the option you want");
							userResponse = Survey.QUESTION_OPTION_INVALID;
							break;
						}
				}
			}catch(NumberFormatException e){
				this.out.promptUser("Invalid input must be a number corresponding to an option");
			}
		}while(userResponse != QUESTION_OPTION_DONE);
	}

	protected String getFormType(){
		return "Survey";
	}

	public void display() {
		int i = 1;
		this.out.promptUser(this.getFormType() + ": " + this.name);
		for(Question q : this.questions){
			this.out.promptUser(i++ + ")");
			q.display();
			this.out.promptUser("\n");
		}
	}

	/**
	 * Anything you want to do with a question right after it is made
	 * Nothing special in survey
	 */
	public void addQuestion(Question question) {
		this.questions.add(question);
		return;	
	}

	public void saveToFile() {
		if(this.name == null || this.name.compareTo("") == 0 ){
			this.out.promptUser("Cannot save " + this.getFormType() + " with no name");
			return;
		}
		try{
			File f = new File(Survey.FOLDER_PATH + this.name + "." + this.getFormType());
			f.getParentFile().mkdirs();
			FileOutputStream file = new FileOutputStream(f);

			ObjectOutputStream out = new ObjectOutputStream(file);

			out.writeObject(this);

			out.close();
			file.close();

			this.out.promptUser("Saved " + this.getFormType());
		}catch(IOException e){
			this.out.promptUser("Failed to save " + this.getFormType());
			e.printStackTrace();
		}

	}

	public void modify() {
		if(this.name == null || this.name.compareTo("") == 0){
			this.out.promptUser("Please load a " + this.getFormType() + " to modify\n\n");
			return;
		}
		this.display();
		this.out.promptUser("Which question would you like to modify? (Enter the number)");
		int userResponse = -1;
		while(userResponse < 1 || userResponse > this.questions.size()){
			try{
				userResponse = Integer.parseInt(this.in.getUserResponse());
			}catch(NumberFormatException e){
				this.out.promptUser("Invalid input must be a number corresponding to an option");
			}
		}
		this._modify(userResponse-1);
	}

	protected void _modify(int questionOption){
		this.questions.get(questionOption).modify();
	}

	public void take() {
		if(this.name == null || this.name.compareTo("") == 0){
			this.out.promptUser("Please load a " + this.getFormType() + " to take\n\n");
			return;
		}
		for(Question q : this.questions){
			q.take();
		}
		this.saveToFile();
	}

	public void tabulate() {

	}

	public Survey loadFromFile() {
		@SuppressWarnings("static-access")
		File folder = new File(this.FOLDER_PATH);
		File files[] = folder.listFiles();
		if(files == null) {
			this.out.promptUser("Error getting saved " + this.getFormType());
			return this;
		}

		this.out.promptUser("Please enter the name of the " + this.getFormType() + " you would like to load");
		for(File file: files) {
			String f = file.getName();
			if(f.endsWith("." + this.getFormType())) {
				this.out.promptUser(f);
			}
		}
		return this._loadFromFile(this.in.getUserResponse());
		
	}

	private Survey _loadFromFile(String fileName){
		Survey survey = this;
		try {
			@SuppressWarnings("static-access")
			FileInputStream streamIn = new FileInputStream(this.FOLDER_PATH + fileName);
			ObjectInputStream objStreamIn = new ObjectInputStream(streamIn);
			survey = (Survey) objStreamIn.readObject();
			objStreamIn.close();
		}catch(FileNotFoundException e) {
			this.out.promptUser("Could not find file, check spelling?");
		}catch(IOException e) {
			this.out.promptUser("Error loading file, please try again");
		}catch(ClassNotFoundException e) {
			this.out.promptUser("Error loading file, please try again");
		}
		
		survey.setIO(this.in, this.out);
		for(Question q : survey.questions){
			q.setIO(survey.in, survey.out);
		}

		return survey;
	}

	public void setIO(Input in, Output out) {
		this.in = in;
		this.out = out;
	}
	
	public String getMenuPrompt(){
		String prompt = "Please enter the number corresponding to your choice\n" + 
			"Survey Menu\n" +
			"1) Create new Survey\n" +
			"2) Display a Survey\n" +
			"3) Load a Survey\n" +
			"4) Save a Survey\n" +
			"5) Modify an existing Survey\n" +
			"6) Take a Survey\n" +
			"7) Tabulate a Survey\n" +
			"8) Quit\n";
		return prompt;
	}
	public Survey menuHandler(int choice){
		switch(choice)
		{
			case MENU_OPTION_CREATE:
				{
					return this.createNew();
				}
			case MENU_OPTION_DISPLAY:
				{
					this.display();
					break;
				}
			case MENU_OPTION_LOAD:
				{
					return this.loadFromFile();
				}
			case MENU_OPTION_SAVE:
				{
					this.saveToFile();
					out.promptUser("Cannot save an empty form");
					break;
				}
			case MENU_OPTION_MODIFY:
				{
					this.modify();
					break;
				}
			case MENU_OPTION_TAKE:
				{
					this.take();
					break;
				}
			case MENU_OPTION_TABULATE:
				{
					this.tabulate();
					break;
				}
			case MENU_OPTION_QUIT:
				{
					return null;
				}
			default:
				{
					this.out.promptUser("Invalid input must be a number corresponding to an option");
					break;
				}
		}
		return this;
	}
}
