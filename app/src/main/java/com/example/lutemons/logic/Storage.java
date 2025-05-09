package com.example.lutemons.logic;
import com.example.lutemons.model.Lutemon;

import java.util.ArrayList;
import java.util.HashMap;

public class Storage {
    //holds the single instance of the Storage class, static so that it belongs to the class itself and not to any specific instance
    private static Storage instance;//ensures singleton pattern, reference to storage object class
    private HashMap<Integer, Lutemon> lutemonMap=new HashMap<>();
    // constructor below
    private Storage(){};
    /**
     * Returns the single instance of Storage.
     * Creates a new one if it doesn't exist yet.
     */
    public static Storage getInstance(){//static, meaning you can call it without needing to create an object of the Storage class
        if (instance==null){
            instance=new Storage();
        }
        return instance;
    }

     //Adds a new Lutemon to the storage.

    public void addLutemon(Lutemon l){
        lutemonMap.put(l.getId(), l);
    }
    //returns all Lutemons as a list
    public ArrayList<Lutemon> getAllLutemons(){
        return new ArrayList<>(lutemonMap.values());
    }
    //Filters and returns Lutemons based on their location (home, training field, battle arena).
    public ArrayList<Lutemon> getLutemonsByLocation(String location) {
        ArrayList<Lutemon> result = new ArrayList<>();
        for (Lutemon l : lutemonMap.values()) {
            if (l.getLocation().equals(location)) {
                result.add(l);
            }
        }
        return result;
    }
    public Lutemon getLutemon(int id){
        return lutemonMap.get(id);
    }
    //Removes Lutemon from the map by its ID.
    public void removeLutemon(int id) {
        lutemonMap.remove(id);
    }
    //Removes a Lutemon by its name (searches for it first).
    public void removeLutemonByName(String name){
        Lutemon toRemove=null;
        for(Lutemon l: lutemonMap.values()){
            if(l.getName().equals(name)){
                toRemove=l;
                break;
            }
        }
        if (toRemove!=null){
            lutemonMap.remove(toRemove.getId());
        }
    }
    //Updates a Lutemon's data. Specifically, the method is used when Lutemon changes its location.
    public void updateLutemon(Lutemon l) {
        lutemonMap.put(l.getId(), l);
    }
}
