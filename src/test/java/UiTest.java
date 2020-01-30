import duke.Ui;

class UiTest {

    public static void main(String[] args) {
        Ui testUi = new Ui();
        testUiLine(testUi);
        testUiEnd(testUi);
    }

    static void testUiLine(Ui ui) {
        ui.showLine();
    }

    static void testUiEnd(Ui ui) {
        ui.end();
    }
}