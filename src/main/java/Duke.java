import duke.Storage;
import duke.TaskList;
import duke.Ui;
import duke.DukeException;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * CS2103T AY 19/20 S2
 * Individual Project
 * @author Yap Dian Hao
 * @since 2020-01-30
 * <p>
 * Duke is a personal chatbot assistant to help you organize your tasks. Especially helpful
 * for people who love to procrastinate. Or procrastinate to procrastinate.
 * </p>
 */

public class Duke extends Application {

    private Storage storage;
    private TaskList taskList;
    private Ui ui;

    /**
     * Constructor of the Duke chatbot assistant.
     * Duke is able to perform CRUD operations (Create, Read, Update, Destroy) to manage tasks.
     * @param filePath A text file which functions as a database to store all tasks.
     */

    public Duke() {

    }

    public Duke(String filePath) {
        this.ui = new Ui();
        storage = new Storage(filePath);
        try {
            taskList = new TaskList(storage.load());
        } catch (DukeException e) {
            System.out.println(e);
        }
    }

    @Override
    public void start(Stage stage) {
        Label helloWorld = new Label("Hello World!"); // Creating a new Label control
        Scene scene = new Scene(helloWorld); // Setting the scene to be our Label
        stage.setScene(scene); // Setting the stage to show our screen
        stage.show(); // Render the stage.
    }

    /**
     * Starts the Duke bot by receiving user input, and stores all the data to the database
     * upon shutting down.
     */
    public void run() {
        ui.start(this.taskList);
        storage.write(this.taskList.getAllTasks());
        ui.end();
    }

    /**
     * The main driver function of Duke.
     * @param args The command line arguments entered by the user.
     */
    public static void main(String[] args) {
        new Duke("data/duke.txt").run();
    }
}