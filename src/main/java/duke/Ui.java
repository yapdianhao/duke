package duke;

import java.util.Scanner;


public class Ui {

    private Scanner sc;
    private Parser parser;

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

    public void start(TaskList taskList) {
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

    public void showLine() {
        System.out.println("============================================================");
    }

    public void end() {
        System.out.println("See you again!");
    }
}
