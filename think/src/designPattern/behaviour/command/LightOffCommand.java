package designPattern.behaviour.command;

/**
 * @Author: zyq-xiaoliuzi
 * @Description:
 * @Date: Created in 11:22 2020/8/7
 * @Modified By:
 */
public class LightOffCommand implements Command {
    Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.off();
    }
}
