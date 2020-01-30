package duke;

/**
 * A Duke exception which warns about input and output errors.
 */
class DukeIOException extends DukeException {

    public String toString() {
        return "OOPS! Something is wrong with the input/output.";
    }
}