package com.example.lutemons.model;

public class Lutemon {
    protected String name, color;
    protected int attack, defense, experience, health, maxHealth, id;
    private static int idCounter=0;
    public Lutemon(String name, String color, int attack, int defense, int maxHealth){
        this.name=name;
        this.color=color;
        this.attack=attack;
        this.defense=defense;
        this.experience=0;
        this.maxHealth=maxHealth;
        this.health=maxHealth;
        this.id=idCounter++;
    }
    public String getName() { return name; }
    public int getHealth() { return health; }
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
    /* attack can be counted in battle class
    int damage = Math.max(0, attacker.getAttackPower() - defender.defense);
    public void attack(){

    }*/
    public void defend(Lutemon attacker){
        int damage=(attacker.getAttackPower()-defense);
        this.health=this.health-damage;

    }
    public boolean isAlive(){
        return health>0;
    }
    public void restoreHealth(){
        this.health=this.maxHealth;
    }
    public void gainXP(){
        this.experience=this.experience+1;
    }

}
