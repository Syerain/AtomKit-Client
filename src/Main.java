import javafx.stage.Stage;
import top.syewiki.atk.cli.*;
//import top.syewiki.atk.cli.gui.*;
import top.syewiki.atk.cli.stdgui.*;

public class Main {
    public static void main(String[] args) {
        //System.out.println("Hello world!");

        //ClassStdFrameBuilder fb = new ClassStdFrameBuilder();
        //fb.drawUI();

        ClassStdTabbedPaneBuilder tp = new ClassStdTabbedPaneBuilder();
        tp.drawPane();

        //thrdFX thrdfx = new thrdFX();
        //thrdfx.run();


    }
}

/*class thrdFX extends Thread{
    public void run() {
        ClassStdFrameBuilderFX fx = new ClassStdFrameBuilderFX();
        Stage stage = new Stage();
        fx.start(stage);
    }
}*/