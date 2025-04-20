package com.example.lutemons.model;

public class Lutemon {
    protected String name, color;
    protected int attack, defense, experience, health, maxHealth, id;
    protected String location;
    private static int idCounter=0;
    //constructor
    public Lutemon(String name, String color, int attack, int defense, int maxHealth){
        this.name=name;
        this.color=color;
        this.attack=attack;
        this.defense=defense;
        this.experience=0;
        this.maxHealth=maxHealth;
        this.health=maxHealth;
        this.id=idCounter++;
        this.location = "home";
    }
    //Getters and a setter
    public String getName() { return name; }
    public int getHealth() { return health; }
    public int getMaxHealth() { return maxHealth; }

    public int getExperience() { return experience; }
    public int getDefense() { return defense; }
    public String getColor() { return color; }
    public int getId() { return id; }
    public static int getNumberOfCreatedLutemons(){
        return idCounter;
    }
    public int getAttackPower(){
        return attack+experience;

    }

    public String getLocation() {return location;}

    public void setLocation(String location) {this.location = location;}

    //Calculates damage and subtracts it from Lutemon HP
    public void defend(Lutemon attacker){
        int damage=(attacker.getAttackPower()-defense);
        this.health=this.health-damage;

    }
    //check if Lutemon is still alive
    public boolean isAlive(){
        return health>0;
    }
    //set health points to maximum
    public void restoreHealth(){
        this.health=this.maxHealth;
    }
    //Increase experience points
    public void gainXP(){
        this.experience=this.experience+1;
    }

}
