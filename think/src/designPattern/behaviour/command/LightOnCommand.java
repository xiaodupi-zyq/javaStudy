package designPattern.behaviour.command;

/**
 * @Author: zyq-xiaoliuzi
 * @Description:
 * @Date: Created in 11:21 2020/8/7
 * @Modified By:
 */
public class LightOnCommand implements Command {
    Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.on();
    }
}
