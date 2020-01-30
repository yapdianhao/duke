package duke;
import java.util.List;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class Parser {

    public Parser() {

    }

    public String  processCommand(String command, TaskList taskList) throws DukeTerminateException,
            InsufficientInputException, InvalidIndexException, InvalidTodoException, InvalidEventException, InvalidDeadlineException,
            InvalidInputException {
        String output = "";
        if (command.equals("bye")) { // exit
                throw new DukeTerminateException();
            } else if (command.equals("list")) {
                output = taskList.list();
            } else if (command.split(" ")[0].equals("find")) { //find
                if (command.split(" ").length < 2) {
                    throw new InsufficientInputException();
                }
                String key = command.split(" ")[1].trim();
                output = taskList.find(key);
            } else if (command.split(" ")[0].equals("done")) { // done
                if (command.split(" ").length < 2) {
                    throw new InsufficientInputException();
                }
                int idx = Integer.parseInt(command.split(" ")[1]) - 1;
                output = taskList.done(idx);
            } else if (command.split(" ")[0].equals("delete")) { // delete
                if (command.split(" ").length < 2) {
                    throw new InsufficientInputException();
                }
                int idx = Integer.parseInt(command.split(" ")[1]) - 1;
                output = taskList.delete(idx);
            } else if (command.split(" ")[0].equals("find")) { // find
                if (command.split(" ").length < 2) {
                    throw new InsufficientInputException();
                }
                String key = command.split(" ")[1].trim();
                output = taskList.find(key);
            } else if (command.split(" ")[0].equals("todo")) { // add todo
                if (command.split(" ").length < 2) {
                    throw new InvalidTodoException();
                }
                command = command.substring(command.split(" ")[0].length() + 1, command.length());
                Task task = new Task(command);
                output = taskList.addTask(task);
            } else if (command.split(" ")[0].equals("deadline")) { // deadline
                command = command.substring(command.split(" ")[0].length() + 1, command.length()).trim();
                if (command.split("/by").length == 0) {
                    throw new InvalidDeadlineException("OOPS! The description and time is missing. " +
                            "Format: description /by time");
                } else if (command.split("/by").length == 1) {
                    if (command.split("/by")[0].equals("")) {
                        throw new InvalidEventException("OOPS! The description and time is missing. " +
                                "Format: description /by time");
                    } else {
                        throw new InvalidEventException("OOPS! The time is missing. " +
                                "Format: description /by time");
                    }
                } else if (command.split("/by").length == 2) {
                    if (command.split("/by")[0].equals("")) {
                        throw new InvalidDeadlineException("OOPS! The description is missing. " +
                                "Format: description /by time");
                    }
                }
                String name = command.split(" /by")[0].trim();
                String time = command.split(" /by")[1].trim();
                if (isValidDate(time)) {
                    LocalDate todoDate = LocalDate.parse(time);
                    Deadline deadline = new Deadline(name, todoDate);
                    output = taskList.addDeadline(deadline);
                } else {
                    Deadline deadline = new Deadline(name, time);
                    output = taskList.addDeadline(deadline);
                }
            } else if (command.split(" ")[0].equals("event")) { // event
                command = command.substring(command.split(" ")[0].length() + 1, command.length()).trim();
                if (command.split("/at").length == 0) {
                    throw new InvalidEventException("OOPS! The description and time is missing. " +
                            "Format: description /at time");
                } else if (command.split("/at").length == 1) {
                    if (command.split("/at")[0].equals("")) {
                        throw new InvalidEventException("OOPS! The description and time is missing. " +
                                "Format: description /at time");
                    } else {
                        throw new InvalidEventException("OOPS! The time is missing. " +
                                "Format: description /at time");
                    }
                } else if (command.split("/at").length == 2) {
                    if (command.split("/at")[0].equals("")) {
                        throw new InvalidEventException("OOPS! The description is missing.");
                    }
                }
                String name = command.split(" /at")[0].trim();
                String time = command.split(" /at")[1].trim();
                if (isValidDate(time)) {
                    LocalDate todoDate = LocalDate.parse(time);
                    Event event = new Event(name, todoDate);
                    output = taskList.addEvent(event);
                } else {
                    Event event = new Event(name, time);
                    output = taskList.addEvent(event);
                }
            } else {
                throw new InvalidInputException();
            }
        return output;
        }


    public void processInputFromFile(String line, List<Task> storedTasks) {
        String[] split = line.split(" | ");
        String type = split[0];
        switch (type) {
            case "T":
                Task task = new Task(split[2]);
                if (Integer.parseInt(split[1]) == 1) {
                    task.setDone();
                }
                storedTasks.add(task);
                break;
            case "E":
                String eventTime = split[3];
                String eventDescription = split[2];
                int eventStatus = Integer.parseInt(split[1]);
                if (isValidDate(eventTime)) {
                    LocalDate eld = LocalDate.parse(eventTime);
                    Event event = new Event(eventDescription, eld);
                    if (eventStatus == 1) {
                        event.setDone();
                    }
                    storedTasks.add(event);
                } else {
                    Event event = new Event(eventDescription, eventTime);
                    if (eventStatus == 1) {
                        event.setDone();
                    }
                    storedTasks.add(event);
                }
                break;
            case "D":
                String deadlineTime = split[3];
                String deadlineDescription = split[2];
                int deadlineStatus = Integer.parseInt(split[1]);
                if (isValidDate(deadlineTime)) {
                    LocalDate dld = LocalDate.parse(deadlineTime);
                    Deadline deadline = new Deadline(deadlineDescription, dld);
                    if (deadlineStatus == 1) {
                        deadline.setDone();
                    }
                    storedTasks.add(deadline);
                } else {
                    Deadline deadline = new Deadline(deadlineDescription, deadlineTime);
                    if (deadlineStatus == 1) {
                        deadline.setDone();
                    }
                    storedTasks.add(deadline);
                }
                break;
            default:
                break;
        }
    }

    static boolean isValidDate(String str) {
        try {
            LocalDate.parse(str);
        } catch (DateTimeParseException e) {
            return false;
        }
        return true;
    }

}