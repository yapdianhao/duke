import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Event extends Task {
    protected String at = "";
    protected LocalDate todoDate;

    public Event(String description, String at) {
        super(description);
        this.at = at;
    }

    public Event(String description, LocalDate todoDate) {
        super(description);
        this.todoDate = todoDate;
    }

    public String getTime() {
        return this.at;
    }

    @Override
    public String toString() {
        if (!this.at.equals("")) {
            return "[E]" + getDescription() + " (at: " + at + ")";
        } else {
            String dateToPrint = this.todoDate.format(DateTimeFormatter.ofPattern("MMM d yyyy"));
            return "[E]" + getDescription() + " (at: " + dateToPrint + ")";
        }
    }
}