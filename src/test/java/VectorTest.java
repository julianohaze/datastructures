import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by julianosilva on 31/07/17.
 */
public class VectorTest {
    @Test
    public void add() throws Exception {
        Person juliano = new Person("Juliano");

        Vector vector = new Vector();
        vector.add(juliano);

        assertEquals(1, vector.size());

        Person person = vector.toArray()[0];
        assertEquals(person, juliano);
    }

    @Test
    public void shouldBeAbleToAddMoreThanTheLimit() {
        Vector vector = new Vector();
        for (int i = 0; i < 300; i++) {
             vector.add(new Person("Person " + i));
        }

        assertEquals(300, vector.size());

        Person[] people = vector.toArray();
        for (int i = 0; i < people.length; i++) {
            assertEquals("Person " + i, people[i].getName());
        }
    }

    @Test
    public void remove() throws Exception {
        Person a = new Person("a");
        Person b = new Person("b");
        Person c = new Person("c");

        Vector vector = new Vector();
        vector.add(a);
        vector.add(b);
        vector.add(c);

        vector.remove(1);

        Person[] people = vector.toArray();
        assertEquals(2, vector.size());
        assertEquals(2, people.length);

        assertEquals(a, people[0]);
        assertEquals(c, people[1]);
    }

    @Test
    public void cointainsShouldReturnTrue() throws Exception {
        Person a = new Person("a");
        Person b = new Person("b");
        Person c = new Person("c");

        Vector vector = new Vector();
        vector.add(a);
        vector.add(b);
        vector.add(c);

        assertTrue(vector.contains(b));
    }

    @Test
    public void cointainsShouldReturnFalse() throws Exception {
        Person a = new Person("a");
        Person b = new Person("b");
        Person c = new Person("c");

        Vector vector = new Vector();
        vector.add(a);
        vector.add(c);

        assertFalse(vector.contains(b));
    }

    @Test
    public void size() throws Exception {
        Person a = new Person("a");
        Person b = new Person("b");
        Person c = new Person("c");

        Vector vector = new Vector();
        vector.add(a);
        vector.add(b);
        vector.add(c);

        assertEquals(3, vector.size());

        vector.remove(1);

        assertEquals(2, vector.size());
    }

}