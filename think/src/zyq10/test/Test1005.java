package zyq10.test;

class Out{
    class In{}
}

public class Test1005 {
    Out out = new Out();
    Out.In in = out.new In();
}
