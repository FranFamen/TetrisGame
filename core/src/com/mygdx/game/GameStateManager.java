package com.mygdx.game;

import com.mygdx.game.states.AbstractState;

import java.util.ArrayList;

public class GameStateManager {
    private ArrayList<AbstractState> states;

    public GameStateManager() {
        states = new ArrayList<AbstractState>();
    }
    public void add(AbstractState state){
        states.add(state);
    }
    public void remove(AbstractState state){
        states.remove(state);
    }
    public boolean contains(AbstractState state){
        return states.contains(state);
    }
    public void update(){
        if(states.size() != 0) {
            states.get(states.size() - 1).update();
        }
    }
    public void draw(){
        if(states.size() != 0) {
            states.get(states.size() - 1).draw();
        }
    }
}
