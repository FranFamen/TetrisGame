package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class Image {
    protected Texture texture;
    protected int x;
    protected int y;
    public Image(String textureName) {
        texture = Storage.getTexture(textureName);
    }
    public void draw(){
        Storage.batch.draw(texture, x, y);
    }
    public void setCoords(int x, int y){
        this.x = x;
        this.y = y;
    }
    public void placeInBottomRightCorner(){
        placeToTheRight();
        y = 0;
    }
    public void centerizeInTheScreen(){
        centerizeHorizontally();
        centerizeVertically();
    }
    public void placeInTopRightCorner(){
        placeAtTheTop();
        placeToTheRight();
    }
    public void placeAtTheTop(){
        y = Gdx.graphics.getHeight() - texture.getHeight();
    }
    public void centerizeHorizontally(){
        x = (Gdx.graphics.getWidth() - texture.getWidth()) / 2;
    }
    public void centerizeVertically(){
        y = (Gdx.graphics.getHeight() - texture.getHeight()) / 2;
    }
    public void placeToTheRight(){x = Gdx.graphics.getWidth() - texture.getWidth();}
}
