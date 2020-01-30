package duke;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Deadline extends Task {

    protected String by = "";
    protected LocalDate todoDate;

    public Deadline(String description, String by) {
        super(description);
        this.by = by;
    }

    public Deadline(String description, LocalDate todoDate) {
        super(description);
        this.todoDate = todoDate;
    }

    public String getDeadline() {
        return this.by;
    }

    @Override
    public String toString() {
        if (!this.by.equals("")) {
            return "[D]" + getDescription() + " (by: " + this.by + ")";
        } else {
            String dateToPrint = this.todoDate.format(DateTimeFormatter.ofPattern("MMM d yyyy"));
            return "[D]" + getDescription() + " (by: " + dateToPrint + ")";
        }
    }
}