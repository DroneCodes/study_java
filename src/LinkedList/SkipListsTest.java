package LinkedList;

/**
 * A simple test class for the SkipList.
 */
public class SkipListsTest {
    public static void main(String[] args) {
        SkipList<Integer, Integer> s = new SkipList<>();
        s.add(1, 100);
        s.add(2, 200);
        s.add(3, 300);
        s.add(4, 400);
        System.out.println(s.get(3));
    }
}
