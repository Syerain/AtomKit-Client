package top.syewiki.atk.cli;

public class ClassThreadAwake extends Thread{

    public String hostAddr;
    public int hostPort;
    public ClassMsger msger;

    private void initThread(String hostAddr, int hostPort){
        this.msger = new ClassMsger(hostAddr,hostPort);
    }

    public void run(String hostAddr, int hostPort) {
        this.initThread(hostAddr,hostPort);
        this.msger.rcvMsg();
    }
}
