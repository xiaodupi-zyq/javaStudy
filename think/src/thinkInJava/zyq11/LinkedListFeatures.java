package thinkInJava.zyq11;

import java.util.*;

public class LinkedListFeatures {
    public static void main(String[] args){
        LinkedList<Pet> pets = new LinkedList<>(Pets.arrayList(5));
        System.out.println(pets);

        System.out.println("pets.getFirst(): " + pets.getFirst());
        System.out.println("pets.element(): " + pets.element());

        System.out.println("pets.peek(): "+pets.peek());

        System.out.println("pets.remove: " + pets.remove());
        System.out.println("pets.removeFirst: " + pets.removeFirst());

        System.out.println("pets.poll: " + pets.poll());
        System.out.println(pets);
        pets.addFirst(new Rat());
        System.out.println("After addFirst(): " + pets);
        pets.offer(Pets.randomPet());
        System.out.println("After offer(): " + pets);
        pets.add(Pets.randomPet());
        System.out.println("After add() " + pets);
        pets.addLast(new Hamster());
        System.out.println("After addLast() "+ pets);
        System.out.println("pets.removeLast(): " + pets.removeLast());
    }
}





////////////////////////////////////////////////////////////////////////////////////////////

class Individual implements Comparable<Individual> {
    private static long counter = 0;
    private final long id = counter++;
    private String name;
    public Individual(String name) { this.name = name; }
    // 'name' is optional:
    public Individual() {}
    @Override
    public String toString() {
        return getClass().getSimpleName() +
                (name == null ? "" : " " + name);
    }
    public long id() { return id; }
    @Override
    public boolean equals(Object o) {
        return o instanceof Individual &&
                Objects.equals(id, ((Individual)o).id);
    }
    @Override
    public int hashCode() {
        return Objects.hash(name, id);
    }
    @Override
    public int compareTo(Individual arg) {
        // Compare by class name first:
        String first = getClass().getSimpleName();
        String argFirst = arg.getClass().getSimpleName();
        int firstCompare = first.compareTo(argFirst);
        if(firstCompare != 0)
            return firstCompare;
        if(name != null && arg.name != null) {
            int secondCompare = name.compareTo(arg.name);
            if(secondCompare != 0)
                return secondCompare;
        }
        return (arg.id < id ? -1 : (arg.id == id ? 0 : 1));
    }
}
class Pet extends Individual {
    public Pet(String name) { super(name); }
    public Pet() { super(); }
}
abstract class PetCreator {
    private Random rand = new Random(47L);

    public PetCreator() {
    }

    public abstract List<Class<? extends Pet>> types();

    public Pet randomPet() {
        int n = this.rand.nextInt(this.types().size());

        try {
            return (Pet)((Class)this.types().get(n)).newInstance();
        } catch (InstantiationException var3) {
            throw new RuntimeException(var3);
        } catch (IllegalAccessException var4) {
            throw new RuntimeException(var4);
        }
    }

    public Pet[] createArray(int size) {
        Pet[] result = new Pet[size];

        for(int i = 0; i < size; ++i) {
            result[i] = this.randomPet();
        }

        return result;
    }

    public ArrayList<Pet> arrayList(int size) {
        ArrayList<Pet> result = new ArrayList();
        Collections.addAll(result, this.createArray(size));
        return result;
    }
}
class Dog extends Pet {
    public Dog(String name) { super(name); }
    public Dog() { super(); }
}
class Cat extends Pet {
    public Cat(String name) { super(name); }
    public Cat() { super(); }
}
class Rodent extends Pet {
    public Rodent(String name) { super(name); }
    public Rodent() { super(); }
}
class Mutt extends Dog {
    public Mutt(String name) { super(name); }
    public Mutt() { super(); }
}
class Pug extends Dog {
    public Pug(String name) { super(name); }
    public Pug() { super(); }
}
class EgyptianMau extends Cat {
    public EgyptianMau(String name) { super(name); }
    public EgyptianMau() { super(); }
}
class Manx extends Cat {
    public Manx(String name) { super(name); }
    public Manx() { super(); }
}
class Cymric extends Manx {
    public Cymric(String name) { super(name); }
    public Cymric() { super(); }
}
class Rat extends Rodent {
    public Rat(String name) { super(name); }
    public Rat() { super(); }
}
class Mouse extends Rodent {
    public Mouse(String name) { super(name); }
    public Mouse() { super(); }
}
class Hamster extends Rodent {
    public Hamster(String name) { super(name); }
    public Hamster() { super(); }
}

class LiteralPetCreator extends PetCreator {
    // No try block needed.
    @SuppressWarnings("unchecked")
    public static
    final List<Class<? extends Pet>> ALL_TYPES =
            Collections.unmodifiableList(Arrays.asList(
                    Pet.class, Dog.class, Cat.class, Rodent.class,
                    Mutt.class, Pug.class, EgyptianMau.class,
                    Manx.class, Cymric.class, Rat.class,
                    Mouse.class, Hamster.class));
    // Types for random creation:
    private static final
    List<Class<? extends Pet>> TYPES =
            ALL_TYPES.subList(ALL_TYPES.indexOf(Mutt.class),
                    ALL_TYPES.size());
    @Override
    public List<Class<? extends Pet>> types() {
        return TYPES;
    }
    public static void main(String[] args) {
        System.out.println(TYPES);
    }
}


class Pets {
    public static final PetCreator creator = new LiteralPetCreator();

    public Pets() {
    }

    public static Pet randomPet() {
        return creator.randomPet();
    }

    public static Pet[] createArray(int size) {
        return creator.createArray(size);
    }

    public static ArrayList<Pet> arrayList(int size) {
        return creator.arrayList(size);
    }
}
