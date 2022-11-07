import java.util.Scanner;

/** Cafe child class of Building capable of selling and restocking coffee */
public class Cafe extends Building {

    private int nCoffeeOunces; // The number of ounces of coffee remaining in inventory
    private int nSugarPackets; // The number of sugar packets remaining in inventory
    private int nCreams; // The number of "splashes" of cream remaining in inventory
    private int nCups; // The number of cups remaining in inventory

    /** 
     * Constructor that constructs a Building with the given parameters, then initializes the Cafe supplies with user input
     * @param name
     * @param address
     * @param floors
     * */
    public Cafe(String name, String address, int floors) {
        super(name, address, floors);

        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the starting supplies...");

        System.out.print("Ounces of coffee: ");
        this.nCoffeeOunces = input.nextInt();

        System.out.print("Packets of sugar: ");
        this.nSugarPackets = input.nextInt();

        System.out.print("Creams: ");
        this.nCreams = input.nextInt();

        System.out.print("Cups: ");
        this.nCups = input.nextInt();
        
        System.out.println("You have built a cafe!");
    }

    /** 
     * Method that sells a single coffee; if there aren't enough supplies, it will restock first
     * @param size
     * @param nSugarPackets
     * @param nCreams
     */
    public void sellCoffee(int size, int nSugarPackets, int nCreams) {

        int coffeeRestock = 0;
        int sugarRestock = 0;
        int creamsRestock = 0;
        int cupsRestock = 0;

        // if there are enough supplies, the coffee is sold
        if (nCoffeeOunces >= size && this.nSugarPackets >= nSugarPackets && this.nCreams >= nCreams) {
            nCoffeeOunces = nCoffeeOunces - size;
            this.nSugarPackets = this.nSugarPackets - nSugarPackets;
            this.nCreams = this.nCreams - nCreams;
            this.nCups = this.nCups - 1;
        }

        // if there aren't enough supplies, the supplies needed are restocked
        else {
            if (size > nCoffeeOunces) {
                coffeeRestock = 100;
            }

            if (nSugarPackets > this.nSugarPackets) {
                sugarRestock = 100;
            }

            if (nCreams > this.nCreams) {
                creamsRestock = 100;
            }

            if (this.nCups < 1) {
                cupsRestock = 100;
            }
        }

        this.restock(coffeeRestock, sugarRestock, creamsRestock, cupsRestock);

        // coffee is made after restock
        nCoffeeOunces = nCoffeeOunces - size;
        this.nSugarPackets = this.nSugarPackets - nSugarPackets;
        this.nCreams = this.nCreams - nCreams;
        this.nCups = this.nCups - 1;

    }

    /** 
     * Getter for coffee ounces
     * @return this.nCoffeeOunces
     */
    public int getCoffeeOunces() {
        return this.nCoffeeOunces;
    }

    /** 
     * Getter for sugar packets
     * @return this.nSugarPackets
     */
    public int getSugarPackets() {
        return this.nSugarPackets;
    }

    /** 
     * Getter for creams
     * @return this.nCreams
     */
    public int getCreams() {
        return this.nCreams;
    }

    /** 
     * Getter for cups
     * @return this.nCups
     */
    public int getCups() {
        return this.nCups;
    }

    /** 
     * Restocks the shop with the given amounts of supplies
     * @param nCoffeeOunces
     * @param nSugarPackets
     * @param nCreams
     * @param nCups
     */
    private void restock(int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
        this.nCoffeeOunces = this.nCoffeeOunces + nCoffeeOunces;
        this.nSugarPackets = this.nSugarPackets + nSugarPackets;
        this.nCreams = this.nCreams + nCreams;
        this.nCups = this.nCups + nCups;
    }

    public static void main(String[] args) {
        Cafe myCafe = new Cafe("myCafe", "42 Selbur Drive", 2);
        System.out.println("coffee: " + myCafe.getCoffeeOunces() + " sugar: " + myCafe.getSugarPackets() + " creams: " + myCafe.getCreams() + " cups: " + myCafe.getCups());
        myCafe.sellCoffee(6,6,6);
        System.out.println("coffee: " + myCafe.getCoffeeOunces() + " sugar: " + myCafe.getSugarPackets() + " creams: " + myCafe.getCreams() + " cups: " + myCafe.getCups());

    }
    
}
