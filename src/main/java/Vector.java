import java.util.Arrays;

/**
 * Created by julianosilva on 31/07/17.
 */
public class Vector {

    private Person[] all = new Person[100];

    private int size = 0;

    public void add(Person person) {
        doubleSizeIfNecessary();

        all[size] = person;
        this.size++;
    }

    public void add(int index, Person person) {
        if (index > this.size) {
            throw new IndexOutOfBoundsException();
        }

        if (index == this.size) {
            this.add(person);
        } else {
            doubleSizeIfNecessary();

            for (int i = this.size - 1; i >= index; i--) {
                this.all[i + 1] = this.all[i];
            }

            this.all[index] = person;
            this.size++;
        }
    }

    private void doubleSizeIfNecessary() {
        if (this.size == this.all.length) {
            this.all = this.copyAndDoubleSize();
        }
    }

    private Person[] copyAndDoubleSize() {
        Person[] people = new Person[this.size * 2];
        for (int i = 0; i < all.length; i++) {
            people[i] = all[i];
        }
        return people;
    }

    public Person get(int index) {
        if (outOfBounds(index)) {
            throw new IndexOutOfBoundsException();
        }
        return this.all[index];
    }

    private boolean outOfBounds(int index) {
        return index < 0 || index >= this.size;
    }

    public void remove(int index) {
        if (index >= this.size) {
            throw new IndexOutOfBoundsException();
        }

        for (int i = index; i < this.size; i++) {
            this.all[i] = this.all[i + 1];
        }

        this.size--;
    }

    public boolean contains(Person person) {
        for (int i = 0; i < this.size; i++) {
            Person p = all[i];

            if (p.equals(person)) {
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
