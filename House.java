import java.util.ArrayList;

/**
 * House child class of Building with a list of residents that can be searched or edited
 */
public class House extends Building {

    private ArrayList<String> residents; // The <String> tells Java what kind of data we plan to store IN the ArrayList
    private boolean hasDiningRoom;

    /**
     * House constructor calls Building constructor and initializes attributes
     * @param name
     * @param address
     * @param floors
     * @param hasDining
     */
    public House(String name, String address, int floors, boolean hasDining) {
      super(name, address, floors);
      residents = new ArrayList<String>();
      hasDiningRoom = hasDining;

      System.out.println("You have built a house!");
    }

    /**
     * Getter for dining attribute
     * @return hasDiningRoom
     */
    public boolean hasDiningRoom() {
      return hasDiningRoom;
    }

    /**
     * Finds the total number of people living in the house
     * @return residents.size()
     */
    public int nResidents() {
      return residents.size();
    }

    /**
     * Adds a resident to the house
     * @param name
     */
    public void moveIn(String name) {
      residents.add(name);
    }

    /**
     * Removes a resident from the house
     * @param name
     * @return name
     */
    public String moveOut(String name) {
      residents.remove(name);
      return name;
    }

    /**
     * Checks if someone is a resident
     * @param person
     * @return residents.contains(person)
     */
    public boolean isResident(String person) {
      return residents.contains(person);
    }

    /**
     * Overrides Building toString() with more detailed House specific info
     */
    public String toString() {
      return this.getName() + " is a " + this.getFloors() + "-story residence hall in the " + this.getAddress() + " area of campus";
    }

    public static void main(String[] args) {
      House myHouse = new House("Morris", "Green Street", 4, true);
      System.out.println(myHouse.toString());
      myHouse.moveIn("Bob");
      System.out.println(myHouse.nResidents());
      System.out.println(myHouse.isResident("Bob"));
      myHouse.moveOut("Bob");
      System.out.println(myHouse.nResidents());


    }

}