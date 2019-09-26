package zyq15;

class Customer {
    private static long counter = 1;
    private final long id = counter++;
    private Customer(){}
    public String toString() {
        return "Customer " + id;
    }
    public static Generator<Customer> generator() {
        return new Generator<Customer>() {
            public Customer next() {
                return  new Customer();
            }
        };
    }
}

//class Teller {
//    private static long counter = 1;
//    private final long id = counter++;
//    private Teller() {}
//    public String toString() {
//        return "Teller " + id;
//    }
//    public String Generator<Teller> generator = new Generator<Teller>(){
//        public Teller next() {
//            return new Teller();
//        }
//    };
//
//}

public class BankTeller {
}
