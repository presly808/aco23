package generics.utils;

import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class SortUtilsTest {

    private List<String> strings;
    private List<Integer> integers;
    private List<User> users;

    @Before
    public void setUp() {
        strings = new ArrayList<>(Arrays.asList("Andrey", "Serhii", "Taras", "Oleh", "Anton"));
        integers = new LinkedList<>(Arrays.asList(20, 19, 37, 16, 24, 525, 305));
        users = new ArrayList<>(Arrays.asList(
                new User(12, "Les", "London"),
                new User(0, "Les", "New York"),
                new User(0, "1Les", "New York"),
                new User(3, "Fox", "Boston")
        ));
    }

    @Test
    public void mergeSortStrings() {
        Comparator<String> comparator = String::compareTo;

        List<String> sortedList = SortUtils.mergeSort(strings, comparator);
        strings.sort(String::compareTo);

        assertThat(sortedList, CoreMatchers.equalTo(strings));
    }

    @Test
    public void mergeSortIntegers() {
        Comparator<Integer> comparator = (o1, o2) -> o1 - o2;
        List<Integer> sortedList = SortUtils.mergeSort(integers, comparator);
        integers.sort(Integer::compareTo);

        assertThat(sortedList, CoreMatchers.equalTo(integers));
    }

    @Test
    public void mergeSortUsers() {
        Comparator<User> comparator = User::compareTo;
        List<User> sortedList = SortUtils.mergeSort(users, comparator);
        users.sort(User::compareTo);

        assertThat(sortedList, CoreMatchers.equalTo(users));
    }

    @Test
    public void compareStrings() {
        String s1 = "Some str";
        String s2 = "Some str";
        assertTrue(SortUtils.compare(s1, s2) == 0);
    }

    @Test
    public void compareIntegers() {
        Integer i1 = 200;
        Integer i2 = 500;

        assertTrue(SortUtils.compare(i1, i2) < 0);
        assertTrue(SortUtils.compare(i2, i1) > 0);
    }

    @Test
    public void compareUsers() {
        User u1 = new User(12, "Les", "London");
        User u2 = new User(12, "Les", "New York");
        User u3 = new User(0, "Les", "London");

        assertTrue(SortUtils.compare(u1, u2) == 0);
        assertTrue(SortUtils.compare(u1, u3) > 0);
    }


    private static class User implements Comparable<User> {

        private int id;
        private String name;
        private String city;

        public User() {
        }

        public User(int id, String name, String city) {
            this.id = id;
            this.name = name;
            this.city = city;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getCity() {
            return city;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            User user = (User) o;

            return id == user.id;
        }

        @Override
        public int hashCode() {
            return id;
        }

        @Override
        public int compareTo(User o) {
            if (this.id > o.id)
                return 1;
            if (this.id < o.id)
                return -1;

            return this.name.compareTo(o.name);
        }
    }
}