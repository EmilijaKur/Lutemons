package com.example.lutemons.logic;

import com.example.lutemons.model.Lutemon;

public class Battle {
    private Lutemon attacker;
    private Lutemon defender;
    private boolean isBattleOngoing;

    public Battle(Lutemon a, Lutemon b){
        this.attacker=a;
        this.defender=b;
        this.isBattleOngoing=true;


    }

    public String executeTurn(){
        if (!isBattleOngoing) return "";
        StringBuilder turnLog=new StringBuilder();
        turnLog.append(attacker.getColor()).append("(").append(attacker.getName()).append(") ")
                .append("attacks ")
                .append(defender.getColor()).append("(").append(defender.getName()).append(")\n");
       defender.defend(attacker);
        if(defender.isAlive()){
            turnLog.append(defender.getColor()).append("(").append(defender.getName()).append(") ")
                    .append("manages to escape death.\n");
            Lutemon temp=attacker;
            attacker=defender;
            defender=temp;


        }else{
            turnLog.append(defender.getColor()).append("(").append(defender.getName()).append(") ")
                    .append("gets killed.\n")
                    .append("The battle is over.\n");
            attacker.gainXP();
            Storage.getInstance().removeLutemon(defender.getId());
            attacker.setLocation("home");
            attacker.restoreHealth();
            isBattleOngoing = false;
        }
        return turnLog.toString();

    }

    public boolean isBattleOngoing() {
        return isBattleOngoing;
    }

    public Lutemon getCurrentAttacker() {
        return attacker;
    }
    public Lutemon getCurrentDefender() {
        return defender;
    }
}
