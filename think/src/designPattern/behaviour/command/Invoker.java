package designPattern.behaviour.command;

/**
 * @Author: zyq-xiaoliuzi
 * @Description:
 * @Date: Created in 11:23 2020/8/7
 * @Modified By:
 */
public class Invoker {
    private Command[] onCommands;
    private Command[] offCommands;
    private final int slotNum = 7;
    public Invoker(){
        this.onCommands = new Command[slotNum];
        this.offCommands = new Command[slotNum];
    }
    public void setOnCommand(Command command,int slot){
        onCommands[slot] = command;
    }
    public void setOffCommand(Command command, int slot) {
        offCommands[slot] = command;
    }

    public void onButtonWasPushed(int slot) {
        onCommands[slot].execute();
    }

    public void offButtonWasPushed(int slot) {
        offCommands[slot].execute();
    }
}
