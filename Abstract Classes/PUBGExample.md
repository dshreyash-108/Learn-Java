# Learn abstract class with example of PUBG mobile

```java
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
```

### Explanation:

1. **Abstract Class `Gun`:**

   - Represents a generic gun with attributes `name`, `damage`, and `ammoCapacity`.
   - Has a constructor to initialize these attributes.
   - Declares an abstract method `shoot()` for shooting the gun.
   - Provides concrete methods `reload()` to simulate reloading and `displayInfo()` to display gun information.

2. **Concrete Subclass `AssaultRifle`:**

   - Extends `Gun` and adds an additional attribute `fireRate`.
   - Implements the `shoot()` method specific to assault rifles by printing a message about shooting.

3. **Concrete Subclass `SniperRifle`:**

   - Also extends `Gun` and adds an additional attribute `scopeMagnification`.
   - Implements the `shoot()` method specific to sniper rifles by printing a message about sniping.

4. **Main Class `PUBGExample`:**
   - Demonstrates the use of abstract class `Gun` and its concrete subclasses `AssaultRifle` and `SniperRifle`.
   - Creates instances of `AssaultRifle` and `SniperRifle`.
   - Calls methods like `displayInfo()`, `reload()`, and `shoot()` on these instances to demonstrate their behavior.

This example showcases the use of abstract classes and inheritance in Java. The `Gun` abstract class defines common attributes and behaviors for different types of guns, while its concrete subclasses `AssaultRifle` and `SniperRifle` provide specific implementations of shooting behavior tailored to their respective types. The `PUBGExample` class demonstrates polymorphism by treating instances of different subclasses uniformly through their common superclass interface.
