package code;

import java.util.ArrayList;
import java.util.List;

import code.music.Atreble;
import code.music.Bass;
import code.music.MusicExpression;
import code.music.PlayContext;
import code.one.AbstractExpress;
import code.one.Context;
import code.one.NotTerminalExpression;
import code.one.TerminalExpression;

/**
 * @author qizhou
 * @date 19-1-8
 */

public class MainExp {

    public static void main(String[] args) {

       /*
        //one代码的客户端示例
       Context context = new Context();
        List<AbstractExpress> list = new ArrayList<>();
        list.add(new TerminalExpression());
        list.add(new NotTerminalExpression());
        list.add(new TerminalExpression());
        list.add(new NotTerminalExpression());
        for (AbstractExpress abstractExpress:list) {
            abstractExpress.interpret(context);
        }*/

       //播放音乐 按照数字作为字符解释区分演奏内容中高低音
        PlayContext playContext = new PlayContext();
        playContext.setPlayStr("123456789123456789");
        MusicExpression musicExpression = null;
        for (char a:playContext.getPlayStr().toCharArray()) {
            if(a<'5'){
                musicExpression = new Bass();
            }else {
                musicExpression = new Atreble();
            }
            musicExpression.interpret(playContext);
        }

    }
}
