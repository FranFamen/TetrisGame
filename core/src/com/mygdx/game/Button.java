package com.mygdx.game;

import com.badlogic.gdx.Gdx;

public class Button extends Image {

    public Button(String textureName) {
        super(textureName);
    }
    public boolean isClicked(){
        if(Gdx.input.justTouched()){
            int touchX = Gdx.input.getX();
            int touchY = Storage.getDeinvertedTouchY();
            return touchX >= x && touchX < x + texture.getWidth() && touchY >= y && touchY < y + texture.getHeight();
        }else {
            return false;
        }
    }
}
