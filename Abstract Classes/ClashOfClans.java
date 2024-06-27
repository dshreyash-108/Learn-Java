abstract class Troop{
    protected String name;
    protected int size;
    protected int damage;
    protected int elixirReq;
    
    public Troop(String name, int damage, int size){
        this.name = name;
        this.damage = damage;
        this.size = size;
    }
    
    public abstract void attack();
    
    public void training(){
        System.out.println(name + " is training right now");
    }
    
    public void displayInfo(){
        System.out.println(name + " is of size: " + size);
        System.out.println("And it deals " + damage + " damage.");
    }
}

class DefenseTroop extends Troop{
    private int speed;
    
    public DefenseTroop(String name, int damage, int size,int speed){
        super(name, damage, size);
        this.speed = speed;
    }
    
    @Override
    public void attack(){
        System.out.println(name + " attacks defenses first, with the speed " + speed);
    }
}

public class ClashOfClans{
    public static void main(String[] kuchBhiLikhdoKyahiFarkPadtahe){
        DefenseTroop giant = new DefenseTroop("Giant", 15, 5, 3);
        
        giant.attack();
        giant.displayInfo();
    }
}

