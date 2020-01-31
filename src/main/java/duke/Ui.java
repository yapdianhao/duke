package duke;
import java.util.Scanner;

/**
 * This is the User Interface of the Duke. Accepts keyboard input from user,
 * and shows the output after the operations.
 */
public class Ui {

    private Scanner sc;
    private Parser parser;

    /**
     * Ui Constructor. Has a Parser attribute to process inputs,
     * and a Scanner to accept inputs. Shows a logo to greet the user.
     */
    public Ui() {
        this.sc = new Scanner(System.in);
        this.parser = new Parser();
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
    }

    /**
     * Starts the UI. The UI will continue to receive inputs, and terminates
     * when the user wishes to.
     * @param taskList
     */
    public void start(TaskList taskList) {
        showLine();
        while (true){
            try {
                String command = sc.nextLine().trim();
                String output = parser.processCommand(command, taskList);
                if (!output.equals("")) {
                    System.out.println(output);
                }
                showLine();
            } catch (DukeTerminateException e) {
                System.out.println("Bye");
                return;
            } catch (InvalidInputException e) {
                System.out.println(e);
            } catch (DukeException e) {
                System.out.println(e);
            }
        }
    }
    /**
     * Prints a horizontal line.
     */
    public void showLine() {
        System.out.println("============================================================");
    }

    /**
     * Prints a goodbye message to the user upon shutdown.
     */
    public void end() {
        System.out.println("See you again!");
    }
}
