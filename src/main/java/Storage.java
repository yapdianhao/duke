import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

class Storage {

    private String path;

    public Storage(String path) {
        this.path = path;
    }

    public List<Task> load() throws DukeIOException {
        List<Task> storedTasks = new ArrayList<>();
        try {
            BufferedReader bfr = new BufferedReader(new FileReader(this.path));
            Parser parser = new Parser();
            String line = bfr.readLine();
            while (line != null) {
                parser.processInputFromFile(line, storedTasks);
                line = bfr.readLine();
            }
        } catch (IOException io) {
            throw new DukeIOException();
        } finally {
            return storedTasks;
        }
    }

    public void write(List<Task> toStore) {
        try {
            FileWriter fw = new FileWriter(this.path);
            for (int i = 0; i < toStore.size(); i++) {
                Task curr = toStore.get(i);
                if (curr instanceof Deadline) {
                    fw.write("D | ");
                    fw.write((curr.getStatus() ? "1" : "0") + " | ");
                    fw.write(curr.getDescriptionWithoutIcon() + " | ");
                    fw.write(((Deadline) curr).getDeadline().trim());
                } else if (curr instanceof Event) {
                    fw.write("E | ");
                    fw.write((curr.getStatus() ? "1" : "0") + " | ");
                    fw.write(curr.getDescriptionWithoutIcon() + " | ");
                    fw.write(((Event) curr).getTime().trim());
                } else {
                    fw.write("T | ");
                    fw.write((curr.getStatus() ? "1" : "0") + " | ");
                    fw.write(curr.getDescriptionWithoutIcon());
                }
                if (i != toStore.size() - 1) {
                    fw.write(System.lineSeparator());
                }
            }
            fw.close();
        } catch (IOException e) {
            System.out.println("OOPS! An error occurred while writing the file.");
        }
    }
}