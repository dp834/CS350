public class Driver {

	public static final int FORM_INVALID = 0;
	public static final int FORM_SURVEY  = 1;
	public static final int FORM_TEST    = 2;
	public static final int FORM_EXIT	 = 3;

	private static final int MENU_PROMPT_FORM_CHOICE = 1;
	private static final int MENU_PROMPT_FORM = 2;
	

	
	private Input in;
	private Output out;
	
    private Survey currentForm;
    private int currentFormType;

    public Driver(Output out, Input in) {
		this.out = out;
		this.in = in;
		this.currentFormType = FORM_INVALID;

    }


	public void run(){
		this.selectType();
		while(this.currentFormType != Driver.FORM_EXIT){
			this.formMenu();	
			this.selectType();
		}
		this.out.promptUser("Exiting, goodbye");
	}


    private void selectType() {
		do{	
			this.printPrompt(Driver.MENU_PROMPT_FORM_CHOICE);
			try{
				switch(Integer.parseInt(this.in.getUserResponse()))
				{
					case FORM_SURVEY:
					{
						this.currentFormType = Driver.FORM_SURVEY;
						this.currentForm = new Survey(in, out);
						break;
					}
					case FORM_TEST:
					{
						this.currentFormType = Driver.FORM_TEST;
						this.currentForm = new Test(in, out);
						break;
					}
					case FORM_EXIT:
					{
						this.currentFormType = Driver.FORM_EXIT;
						break;
					}
					default:
					{
						this.out.promptUser("Number does not correspond to any option");
					}
				}
			}catch(NumberFormatException e){
				this.out.promptUser("Invalid input must be a number corresponding to an option");
			}
		}while(this.currentFormType == Driver.FORM_INVALID);		
		this.out.promptUser("\n");
    }
	
	private void formMenu(){
		do{
			this.printPrompt(Driver.MENU_PROMPT_FORM);
			try{
				this.out.promptUser("\n");
				this.currentForm = this.currentForm.menuHandler(Integer.parseInt(this.in.getUserResponse()));
			}catch(NumberFormatException e){
				this.out.promptUser("Invalid input must be a number corresponding to an option");
			}
		}while(this.currentForm != null);
					
	}

	private void printPrompt(int menuPrompt){
		switch( menuPrompt )
		{
			case MENU_PROMPT_FORM_CHOICE :
			{
				String prompt = "Please enter the number corresponding to your choice\n" + 
								"1) Survey\n" +
							    "2) Test\n" + 
								"3) Quit\n";
				this.out.promptUser(prompt);
				break;
			}
			case MENU_PROMPT_FORM:
			{
				String prompt = this.currentForm.getMenuPrompt();
				this.out.promptUser(prompt);
				break;
			}
			default:{break;}
		}
	}


	public static void main(String[] args){
		Driver driver = new Driver(new ConsoleOutput(), new ConsoleInput());
		driver.run();
	}

}
