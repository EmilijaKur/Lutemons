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
    public static Storage getInstance(){//static, meaning you can call it without needing to create an object of the Storage class
        if (instance==null){
            instance=new Storage();
        }
        return instance;
    }
    public void addLutemon(Lutemon l){
        lutemonMap.put(l.getId(), l);
    }
    public ArrayList<Lutemon> getAllLutemons(){
        return new ArrayList<>(lutemonMap.values());
    }
    public Lutemon getLutemon(int id){
        return lutemonMap.get(id);
    }
}
