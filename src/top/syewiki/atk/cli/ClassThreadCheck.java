package top.syewiki.atk.cli;

public class ClassThreadCheck extends Thread{

    public String hostAddr;
    public int hostPort;
    public ClassMsger msger;
    public int ifSrvReachable;

    private void initThread(String hostAddr, int hostPort){
        this.msger = new ClassMsger(hostAddr,hostPort);
    }

    public void run() {
        this.initThread(this.hostAddr,this.hostPort);
        try{
            this.ifSrvReachable = 0;
            System.out.println("0");
            this.msger.sendMsg("REQ:CHK_SRV_STATUS",false);
            this.ifSrvReachable = 1;
            System.out.println("1");
        }catch (Exception e){
            this.ifSrvReachable = 2;
            System.out.println("2");
        }
        //try{sleep(1000);}catch (Exception e){e.printStackTrace();}
        //this.ifSrvReachable = false;
        System.out.println("3");
    }

    public ClassThreadCheck(String hostAddr, int hostPort){
        this.hostAddr = hostAddr;
        this.hostPort = hostPort;
    }

}
