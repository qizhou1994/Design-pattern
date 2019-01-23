package code.command.eg1;

/**
 * Created by qizhou on 19-1-23.
 * 要求该命令执行这个Command请求
 */

public class Invoker {

    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }


    public void excuteCommand() {
        if(command!=null) {
            command.excute();
        }
    }
}
