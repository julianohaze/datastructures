import java.util.Arrays;

/**
 * Created by julianosilva on 31/07/17.
 */
public class Vector {

    private Person[] all = new Person[100];

    private int size = 0;

    public void add(Person person) {
        if (this.size == this.all.length) {
            this.all = this.copyAndDoubleSize();
        }

        all[size] = person;
        this.size++;
    }

    private Person[] copyAndDoubleSize() {
        Person[] people = new Person[this.size * 2];
        for (int i = 0; i < all.length; i++) {
            people[i] = all[i];
        }
        return people;
    }

    public void remove(int index) {
        if (index > this.size) {
            throw new IllegalArgumentException("Index out of bounds");
        }

        for (int i = index; i < this.size; i++) {
            this.all[i] = this.all[i + 1];
        }

        this.size--;
    }

    public boolean contains(Person person) {
        for (int i = 0; i < this.size; i++) {
            Person p = all[i];

            if (p.equals(person)){
                return true;
            }
        }
        return false;
    }

    public int size() {
        return size;
    }

    public Person[] toArray() {
        Person[] people = new Person[this.size];
        for (int i = 0; i < this.size; i++) {
            people[i] = all[i];
        }
        return people;
    }

    @Override
    public String toString() {
        return "[" + Arrays.toString(all) + "]";
    }
}
