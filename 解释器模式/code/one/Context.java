package code.one;

/**
 *
 * @author qizhou
 * @date 19-1-8
 *
 * Context就是单纯的传递全局参数，便于解释器更好的去解析程序
 */

public class Context {
    @Override
    public String toString() {
        return "Context{" +
                "input='" + input + '\'' +
                ", output='" + output + '\'' +
                '}';
    }

    private String input;

    private String output;


    public void setInput(String input) {
        this.input = input;
    }

    public void setOutput(String output) {
        this.output = output;
    }

    public String getInput() {
        return input;
    }

    public String getOutput() {
        return output;
    }
}

