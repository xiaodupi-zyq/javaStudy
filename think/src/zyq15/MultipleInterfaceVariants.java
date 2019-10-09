package zyq15;

public class MultipleInterfaceVariants {

}

interface Playable<T> {}

class Employee implements Playable{}
class Hourly extends Employee implements Playable{}
