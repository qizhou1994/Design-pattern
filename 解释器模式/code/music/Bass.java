package code.music;

/**
 * Created by qizhou on 19-1-8.
 * 低音 0-4
 */

public class Bass extends MusicExpression {

    @Override
    public void excute(String value) {
        StringBuilder stringBuilder = new StringBuilder();
        for (char a : value.toCharArray()) {
            if (a < '5') {
                stringBuilder.append(a);
            }
        }
        System.out.println("解释0-4 是低音，Bass = " + stringBuilder.toString());
    }
}
