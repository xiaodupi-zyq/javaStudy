package thinkInJava.zyq09;

import java.util.Random;

interface NewGame {
    void play();
}

interface NewGameFactory{
    NewGame getNewGame();
}

class Coin implements NewGame{
    public void play(){
        Random random = new Random();
        System.out.println("Coin this times is " + random.nextInt(2));
    }
}
class CoinFactory implements NewGameFactory{
    public NewGame getNewGame(){
        return new Coin();
    }
}

class Dice implements NewGame{
    public void play(){
        Random random = new Random();
        System.out.println("Dice this times is " + (random.nextInt(6)+1));
    }
}
class DiceFactory implements NewGameFactory{
    public NewGame getNewGame(){
        return new Dice();
    }
}

public class NewGames {
    public static void play(NewGameFactory newGameFactory){
        newGameFactory.getNewGame().play();
    }
    public static void main(String[] args){
        play(new CoinFactory());
        play(new DiceFactory());
    }
}
