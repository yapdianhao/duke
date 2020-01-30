import duke.*;

public class Duke {

    private Storage storage;
    private TaskList taskList;
    private Ui ui;

    public Duke(String filePath) {
        this.ui = new Ui();
        storage = new Storage(filePath);
        try {
            taskList = new TaskList(storage.load());
        } catch (DukeException e) {
            taskList = new TaskList();
        }
    }

    public void run() {
        ui.start(this.taskList);
        storage.write(this.taskList.getAllTasks());
        ui.end();
    }

    public static void main(String[] args) {
        new Duke("data/duke.txt").run();
    }
}