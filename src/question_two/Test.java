package question_two;

import question_two.Integer.StorageIntegerImpl;
import question_two.String.StorageStringImpl;

public class Test {

    private static <T> void testStorage(T[] toInsert, StorageInterface<T> aStorage) {
        System.out.println("BST handling " + toInsert[0].getClass().getSimpleName());

        System.out.println("Adding...");
        for (T comparable : toInsert) {
            System.out.println("Adding \"" + comparable + "\": " + aStorage.add(comparable));
        }

        System.out.println("Finding...");
        for (T comparable : toInsert) {
            System.out.println("Finding \"" + comparable + "\": " + aStorage.find(comparable));
        }

        System.out.println("Deleting...");
        for (T comparable : toInsert) {
            System.out.println("Deleting \"" + comparable + "\": " + aStorage.delete(comparable));
        }

        System.out.println("Finding again...");
        for (T comparable : toInsert) {
            System.out.println("Finding \"" + comparable + "\" again: " + aStorage.find(comparable));
        }
        System.out.println("_______________________________________________________________");

    }

    public static void main(String[] args) {
        String[] strings = { "3", "4", "3", null, "10", "Hello", "Java", "Minh Le ABC"};
        Integer[] integers = {1,3,2,null,-1,0};
        StorageInterface<String> storageString = new StorageStringImpl();
        StorageInterface<Integer> storageInteger = new StorageIntegerImpl();

        testStorage(strings, storageString);
        testStorage(integers, storageInteger);

    }
}
