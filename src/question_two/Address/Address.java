package question_two.Address;

public class Address implements Comparable<Address> {
    int houseNumber;
    String streetName;
    String nameOfTown;
    String state;
    int zipCode;

    public Address(int houseNumber, String streetName, String nameOfTown, String state, int zipCode) {
        this.houseNumber = houseNumber;
        this.streetName = streetName;
        this.nameOfTown = nameOfTown;
        this.state = state;
        this.zipCode = zipCode;
    }

    @Override
    public int compareTo(Address anotherAddress) {
        return this.streetName.compareTo(anotherAddress.streetName);
    }

    @Override
    public String toString() {
        return "Address{" +
                "houseNumber=" + houseNumber +
                ", streetName='" + streetName + '\'' +
                ", nameOfTown='" + nameOfTown + '\'' +
                ", state='" + state + '\'' +
                ", zipCode=" + zipCode +
                '}';
    }
}
