
public class Driver{

//	private Survey currentForm;
	private int currentFormType;
	private Input input;
	private Output output;	

	public static void main(String args[]){
		Input in  = new ConsoleInput();
		Output out = new ConsoleOutput();
		out.promptUser("Please enter your name");
		String resp = in.getUserResponse();
		out.promptUser("Hello " + resp);
	}

	public void selectType(){
		
	}

}
