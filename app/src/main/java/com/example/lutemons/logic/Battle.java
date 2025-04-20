package com.example.lutemons.logic;

import com.example.lutemons.model.Lutemon;

public class Battle {
    private Lutemon attacker;
    private Lutemon defender;
    private boolean isBattleOngoing;
    //Constructor
    public Battle(Lutemon a, Lutemon b){
        this.attacker=a;
        this.defender=b;
        this.isBattleOngoing=true;


    }
    /**
     * Executes a single turn in the battle and returns the outcome log.
     * @return log message that says what happened in one turn of a battle between two Lutemons
     */
    public String executeTurn(){
        if (!isBattleOngoing) return "";
        StringBuilder turnLog=new StringBuilder();
        // Log the attack action
        turnLog.append(attacker.getColor()).append("(").append(attacker.getName()).append(") ")
                .append("attacks ")
                .append(defender.getColor()).append("(").append(defender.getName()).append(")\n");
       defender.defend(attacker);
        // Check if defender is still alive after the attack
        if(defender.isAlive()){
            // Battle continues, swap roles
            turnLog.append(defender.getColor()).append("(").append(defender.getName()).append(") ")
                    .append("manages to escape death.\n");
            Lutemon temp=attacker;
            attacker=defender;
            defender=temp;


        }else{
            // Defender is defeated
            turnLog.append(defender.getColor()).append("(").append(defender.getName()).append(") ")
                    .append("gets killed.\n")
                    .append("The battle is over.\n");
            // Update winner's XP, restore, and storage
            attacker.gainXP();
            Storage.getInstance().removeLutemon(defender.getId());
            attacker.setLocation("home");
            attacker.restoreHealth();
            isBattleOngoing = false;
        }
        return turnLog.toString();

    }
    /**
     * Checks if the battle is still ongoing.
     */
    public boolean isBattleOngoing() {
        return isBattleOngoing;
    }
    /**
     * Returns the Lutemon who will attack in the next turn.
     */
    public Lutemon getCurrentAttacker() {
        return attacker;
    }
    /**
     * Returns the Lutemon who will defend in the next turn.
     */
    public Lutemon getCurrentDefender() {
        return defender;
    }
}
