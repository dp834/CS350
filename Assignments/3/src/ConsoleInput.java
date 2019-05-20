import java.util.Scanner;

public class ConsoleInput implements Input {

    private Scanner scanner;

    public ConsoleInput() {
	this.scanner = new Scanner(System.in);
    }

    public String getUserResponse() {
        return scanner.nextLine(); 
    }

}
