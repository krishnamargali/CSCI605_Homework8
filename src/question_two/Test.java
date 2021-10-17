package question_two;

import question_two.Address.Address;
import question_two.Address.StorageAddressImpl;
import question_two.Human.Human;
import question_two.Human.HumanStorageImpl;
import question_two.Integer.StorageIntegerImpl;
import question_two.MusicLP.MusicLP;
import question_two.MusicLP.StorageMusicImpl;
import question_two.String.StorageStringImpl;

import java.sql.Date;
import java.util.Scanner;

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

    private static MusicLP[] generateMusicLPObjects() {
        MusicLP[] musicLPS = new MusicLP[6];
        MusicLP musicLP = new MusicLP(1990, "Artist 1", "Song 1", 4.05f, 4);
        MusicLP musicLP2 = new MusicLP(1990, "Artist 2", "Song 2", 3.05f, 4);
        MusicLP musicLP3 = new MusicLP(1990, "Artist 3", "Song 3", 5.05f, 4);
        MusicLP musicLP4 = new MusicLP(1990, "Artist 4", "Song 4", 6.05f, 4);
        MusicLP musicLP5 = new MusicLP(1990, "Artist 5", "Song 5", 4.10f, 4);
        int counter = 0;
        musicLPS[counter++] = musicLP;
        musicLPS[counter++] = musicLP2;
        musicLPS[counter++] = musicLP3;
        musicLPS[counter++] = null;
        musicLPS[counter++] = musicLP4;
        musicLPS[counter++] = musicLP5;
        return musicLPS;
    }

    private static Human[] generateHumanObjects() {
        Human[] humans = new Human[4];
        Human human1 = new Human(Date.valueOf("1997-01-05"), "Minh", "1");
        Human human4 = new Human(Date.valueOf("1998-10-30"), "Andy", "2");
        int counter = 0;
        humans[counter++] = human1;
        humans[counter++] = null;
        humans[counter++] = null;
        humans[counter++] = human4;
        return humans;
    }

    private static Address[] generateAddressObjects() {
        Address[] addresses = new Address[5];
        Address address1 = new Address(1, "State Street", "Chicage", "IL", 60601);
        Address address2 = new Address(2, "College Street", "Beloit", "WI", 53511);
        Address address4 = new Address(4, "Massachusetts Avenue", "Boston", "MA", 10209);
        int counter = 0;
        addresses[counter++] = address1;
        addresses[counter++] = address2;
        addresses[counter++] = null;
        addresses[counter++] = address4;
        addresses[counter++] = null;
        return addresses;
    }

    private static int getUserChoice () {
        Scanner sc = new Scanner(System.in);
        System.out.println("What types of object do you want to test? Enter -1 to quit.");
        System.out.println("1. Strings ");
        System.out.println("2. Integers ");
        System.out.println("3. MusicLPs ");
        System.out.println("4. Human ");
        System.out.println("5. Address ");
        return Integer.parseInt(sc.nextLine());
    }

    private static void handleStringCases() {
        String[] strings = { "3", "4", "3", null, "10", "Hello", "Java", "Minh Le ABC"};
        StorageInterface<String> storageString = new StorageStringImpl();
        testStorage(strings, storageString);
    }

    private static void handleIntegerCase() {
        Integer[] integers = {1,3,2,null,-1,0};
        StorageInterface<Integer> storageInteger = new StorageIntegerImpl();
        testStorage(integers, storageInteger);
    }

    private static void handleAddressCase() {
        Address[] addresses = generateAddressObjects();
        StorageInterface<Address> storageAddress = new StorageAddressImpl();
        testStorage(addresses, storageAddress);
    }

    private static void handleHumanCase() {
        Human[] humans = generateHumanObjects();
        StorageInterface<Human> storageHuman = new HumanStorageImpl();
        testStorage(humans, storageHuman);
    }

    private static void handleMusicCase() {
        MusicLP[] musicLPS = generateMusicLPObjects();
        StorageInterface<MusicLP> storageMusic = new StorageMusicImpl();
        testStorage(musicLPS, storageMusic);
    }

    public static void main(String[] args) {
        while (true) {
            try {
                int userChoice = getUserChoice();
                if (userChoice == -1) {
                    System.out.println("Program Ending......");
                    break;
                }
                else if (userChoice == 1) {
                    handleStringCases();
                }
                else if (userChoice == 2) {
                    handleIntegerCase();
                }
                else if (userChoice == 3) {
                    handleMusicCase();
                }
                else if (userChoice == 4) {
                    handleHumanCase();
                }
                else if (userChoice == 5) {
                    handleAddressCase();
                }
                else {
                    System.out.println("Invalid choice");
                }
            }
            catch (NumberFormatException e) {
                System.out.println("Invalid number format. Please enter a number");
            }
        }
    }
}
