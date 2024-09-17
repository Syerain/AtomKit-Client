
import top.syewiki.atk.cli.*;
//import top.syewiki.atk.cli.gui.*;
import top.syewiki.atk.cli.stdgui.*;

public class Main {
    public static void main(String[] args) {
        ClassGlobalConsts GlobalConsts = new ClassGlobalConsts("ATOM-Kit","atk","1.0","client-jdk21-commmon");

        ClassThreadAwake ThreadAwake = new ClassThreadAwake("syewiki.top",6001);

        ClassStdTabbedPaneBuilder tp = new ClassStdTabbedPaneBuilder(ThreadAwake);
        tp.drawPane(ThreadAwake);

        //ClassSimpleMsger simpleMsger = new ClassSimpleMsger("syewiki.top",6001);
        //simpleMsger.connectionK();

    }
}
