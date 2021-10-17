package question_two;

import question_two.String.StorageStringImpl;

public class Test {
    private static void testStringStorage(String[] toInsert) {
        System.out.println("BST handling " + toInsert[0].getClass().getSimpleName());
        StorageInterface<String> aStorage = new StorageStringImpl();

        System.out.println("Adding...");
        for (String comparable : toInsert) {
            System.out.println("Adding \"" + comparable + "\": " + aStorage.add(comparable));
        }

        System.out.println("Finding...");
        for (String comparable : toInsert) {
            System.out.println("Finding \"" + comparable + "\": " + aStorage.find(comparable));
        }

        System.out.println("Deleting...");
        for (String comparable : toInsert) {
            System.out.println("Deleting \"" + comparable + "\": " + aStorage.delete(comparable));
        }

        System.out.println("Finding again...");
        for (String comparable : toInsert) {
            System.out.println("Finding \"" + comparable + "\" again: " + aStorage.find(comparable));
        }
        System.out.println("_______________________________________________________________");

    }


    public static void main(String[] args) {
        String[] strings = { "3", "4", "3", null, "10", "Hello", "Java", "Minh Le ABC"};
        testStringStorage(strings);
    }
}
