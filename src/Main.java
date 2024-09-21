
import top.syewiki.atk.cli.*;
//import top.syewiki.atk.cli.gui.*;
import top.syewiki.atk.cli.stdgui.*;

public class Main {
    public static void main(String[] args) {
        //实例化全局常量
        ClassGlobalConsts GlobalConsts = new ClassGlobalConsts("ATOM-Kit","atk","1.0","client-jdk21-commmon");

        //实例化唤醒线程
        ClassThreadAwake ThreadAwake = new ClassThreadAwake("syewiki.top", 6001);

        //实例化先行线程
        //ClassThreadCheck ThreadCheck = new ClassThreadCheck("syewiki.top", 6001);

        //实例化窗体并绑定线程
        ClassStdTabbedPaneBuilder tp = new ClassStdTabbedPaneBuilder(ThreadAwake /*ThreadCheck*/);
        tp.drawPane(ThreadAwake/*ThreadCheck*/);

        //ClassSimpleMsger simpleMsger = new ClassSimpleMsger("syewiki.top",6001);
        //simpleMsger.connectionK();

    }
}
