import duke.TaskList;
import duke.Task;
import java.util.List;
import java.util.ArrayList;

class TaskListTest {

    public static void main(String[] args) {
        TaskList testTaskList = new TaskList();
        testTaskListAdd(testTaskList);
        testTaskListDone(testTaskList);
    }

    static void testTaskListAdd(TaskList testTaskList) {
        for (int i = 0; i < 10; i++) {
            Task testTask = new Task("test case " + i);
            testTaskList.addTask(testTask);
        }
        System.out.println(testTaskList.list());
    }

    static void testTaskListDone(TaskList testTaskList) {
        for (int i = 0; i < 10; i++) {
            testTaskList.done(i + 1);
        }
        System.out.println(testTaskList.list());
    }


}