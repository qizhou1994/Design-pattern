package code.command.eg1;

/**
 * Created by qizhou on 19-1-23.
 */

public class Client {


    public static void main(String[] args){
        Receiver receiver = new Receiver();
        Command command = new ConcreateCommand(receiver);
        Invoker invoker = new Invoker();

        invoker.setCommand(command);
        invoker.excuteCommand();
    }
}
