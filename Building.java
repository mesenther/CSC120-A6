/** 
 * Building class has name, address, number of floors, getters and setters for those attributes, 
 * and a toString() method to print info about an object
 */
public class Building {

    private String name = "<Name Unknown>";
    private String address = "<Address Unknown>";
    private int nFloors = 1;

    /**
     * Building constructor creates a Building object with given name, address, and floors
     * @param name
     * @param address
     * @param nFloors
     */
    public Building(String name, String address, int nFloors) {
        if (name != null) { this.name = name; }
        if (address != null) { this.address = address; } 
        if (nFloors < 1) {
            throw new RuntimeException("Cannot construct a building with fewer than 1 floor.");
        }
        this.nFloors = nFloors;
    }

    /**
     * Getter for name attribute
     * @return this.name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Getter for address attribute
     * @return this.address
     */
    public String getAddress() {
        return this.address;
    }

    /**
     * Getter for floors attribute
     * @return this.nFloors
     */
    public int getFloors() {
        return this.nFloors;
    }

    /**
     * Setter for name attribute
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Setter for address attribute
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Setter for floors attribute
     * @param floors
     */
    public void setFloors(int floors) {
        this.nFloors = floors;
    }

    /**
     * Overrides object toString() method, printing info about the Building instead of a memory address
     * @return String of Building info
     */
    public String toString() {
        return this.name + " is a " + this.nFloors + "-story building located at " + this.address;
    }

    public static void main(String[] args) {
        Building fordHall = new Building("Ford Hall", "100 Green Street Northampton, MA 01063", 4);
        System.out.println(fordHall);
    }

}