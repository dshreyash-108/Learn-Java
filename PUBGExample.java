// Abstract class representing a Gun in PUBG
abstract class Gun {
    protected String name;
    protected int damage;
    protected int ammoCapacity;

    public Gun(String name, int damage, int ammoCapacity) {
        this.name = name;
        this.damage = damage;
        this.ammoCapacity = ammoCapacity;
    }

    // Abstract method for shooting the gun
    public abstract void shoot();

    // Concrete method for reloading the gun
    public void reload() {
        System.out.println(name + " is reloading.");
        // Logic for reloading
    }

    // Concrete method to display information about the gun
    public void displayInfo() {
        System.out.println("Gun: " + name);
        System.out.println("Damage: " + damage);
        System.out.println("Ammo Capacity: " + ammoCapacity);
    }
}

// Concrete subclass representing a specific type of Gun
class AssaultRifle extends Gun {
    private int fireRate;

    public AssaultRifle(String name, int damage, int ammoCapacity, int fireRate) {
        super(name, damage, ammoCapacity);
        this.fireRate = fireRate;
    }

    @Override
    public void shoot() {
        System.out.println("Shooting " + name + " with damage: " + damage);
        // Logic for shooting
    }
}

// Concrete subclass representing another type of Gun
class SniperRifle extends Gun {
    private int scopeMagnification;

    public SniperRifle(String name, int damage, int ammoCapacity, int scopeMagnification) {
        super(name, damage, ammoCapacity);
        this.scopeMagnification = scopeMagnification;
    }

    @Override
    public void shoot() {
        System.out.println("Sniping with " + name + " with damage: " + damage);
        // Logic for shooting with scope
    }
}

// Main class to demonstrate the use of abstract class and subclasses
public class PUBGExample {
    public static void main(String[] args) {
        Gun ar = new AssaultRifle("M416", 36, 30, 750);
        Gun sniper = new SniperRifle("AWM", 105, 5, 8);

        ar.displayInfo();
        ar.reload();
        ar.shoot();

        System.out.println();

        sniper.displayInfo();
        sniper.reload();
        sniper.shoot();
    }
}
