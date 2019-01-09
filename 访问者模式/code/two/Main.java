package code.two;


import code.two.imp.Amativeness;
import code.two.imp.Failing;
import code.two.imp.Man;
import code.two.imp.Success;
import code.two.imp.Woman;

/**
 * Created by qizhou on 19-1-9.
 */

public class Main {

    public static void main(String[] args){

        ObjectStructure objectStructure = new ObjectStructure();
        Woman woman = new Woman();
        objectStructure.attach(  woman);
        objectStructure.attach(new Man());

        //成功的时候
        Success success = new Success();
        objectStructure.display(success);

        //失败
        Failing failing = new Failing();
        objectStructure.display(failing);

        //恋爱
        Amativeness amativeness = new Amativeness();
        objectStructure.display(amativeness);

        objectStructure.detach(woman);
        objectStructure.display(amativeness);
    }
}
