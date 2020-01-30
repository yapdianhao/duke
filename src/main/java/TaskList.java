import java.util.List;
import java.util.ArrayList;

class TaskList {
    private List<Task> tasks;

    public TaskList() {
        this.tasks = new ArrayList<>();
    }

    public TaskList(List<Task> tasks) {
        this.tasks = tasks;
    }

    public String addTask (Task task) {
        this.tasks.add(task);
        String res = "Got it. I've added this task:" + "\n";
        res += task + "\n";
        res += "Now you have " + this.tasks.size()
                + (this.tasks.size() > 1 ? " tasks" : " task") + " in the list";
        return res;
    }

    public String addDeadline(Deadline deadline) {
        this.tasks.add(deadline);
        String res = "Got it. I've added this deadline:" + "\n";
        res += deadline + "\n";
        res += "Now you have " + this.tasks.size()
                + (this.tasks.size() > 1 ? " tasks" : " task") + " in the list";
        return res;
    }

    public String addEvent(Event event) {
        this.tasks.add(event);
        String res = "Got it. I've added this deadline:" + "\n";
        res += event + "\n";
        res += "Now you have " + this.tasks.size()
                + (this.tasks.size() > 1 ? " tasks" : " task") + " in the list";
        return res;
    }

    public String list() {
        String res = "";
        for (int i = 0; i < this.tasks.size(); i++) {
            res += (i + 1) + "." + this.tasks.get(i);
            if (i != this.tasks.size() - 1) {
                res += "\n";
            }
        }
        return res;
    }

    public String find(String key) {
        String res = "Here are the matching tasks in your list:" + "\n";
        List<Task> filteredTasks = new ArrayList<>();
        for (Task task : this.tasks) {
            if (task.getDescriptionWithoutIcon().contains(key)) {
                filteredTasks.add(task);
            }
        }
        for (int i = 0; i < filteredTasks.size(); i++) {
            res += (i + 1) + "." + filteredTasks.get(i);
        }
        return res;
    }

    public String done(int idx) {
        String res = "";
        Task curr = this.tasks.get(idx);
        curr.setDone();
        res += "Nice! I've marked this task as done:" + "\n";
        res += curr;
        return res;
    }

    public String delete(int idx) throws InvalidIndexException {
        String res = "";
        if (idx < 0 || idx >= tasks.size()) {
            String message = "OOPS! Invalid task number. You only have " + this.tasks.size()
                    + (this.tasks.size() > 1 ? " tasks" : " task") + " in the list";
            throw new InvalidIndexException(message);
        }
        Task toDelete = this.tasks.get(idx);
        this.tasks.remove(idx);
        res += ("Noted. I've removed this task: \n");
        res += (toDelete + "\n");
        res += ("Now you have " + this.tasks.size()
                    + " " + (this.tasks.size() > 1 ? "tasks" : "task") + " in the list");
        return res;
    }
}