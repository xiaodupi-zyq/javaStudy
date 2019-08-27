package zyq10.test;

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
    public static NewGameFactory factory = new NewGameFactory() {
        @Override
        public NewGame getNewGame() {
            return new Coin();
        }
    };
}
//class CoinFactory implements NewGameFactory{
//    public NewGame getNewGame(){
//        return new Coin();
//    }
//}

class Dice implements NewGame{
    public void play(){
        Random random = new Random();
        System.out.println("Dice this times is " + (random.nextInt(6)+1));
    }
    public static NewGameFactory factory = new NewGameFactory() {
        @Override
        public NewGame getNewGame() {
            return new Dice();
        }
    };
}
//class DiceFactory implements NewGameFactory{
//    public NewGame getNewGame(){
//        return new Dice();
//    }
//}

class NewGames {
    public static void play(NewGameFactory newGameFactory){
        newGameFactory.getNewGame().play();
    }
    public static void main(String[] args){
        play(Coin.factory);
        play(Dice.factory);
    }
}
