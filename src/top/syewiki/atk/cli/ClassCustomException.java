package top.syewiki.atk.cli;

// 这是一个自定义的错误类，继承于Exception，
// 在使用时调用构造方法写入错误信息，即可实现现写现用

public class ClassCustomException extends Exception{
    String msg;

    //构造方法，写入错误信息
    public ClassCustomException(String msg){
        this.msg = msg;
    }

    //返回错误消息
    public String getExcpMsg(){
        return this.msg;
    }

    //syso输出错误信息
    public void printExcpMsg(){
        System.out.println(this.msg);
    }
}
