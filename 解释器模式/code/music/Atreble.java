package code.music;

/**
 * Created by qizhou on 19-1-8.
 */

public class Atreble extends MusicExpression {

    @Override
    public void excute(String value) {
        StringBuilder stringBuilder = new StringBuilder();
        for (char a : value.toCharArray()) {
            if(a>'5'){
                stringBuilder.append(a);
            }
        }
        System.out.println("解释5-9 是高音，Atreble = " + stringBuilder.toString());
    }
}
