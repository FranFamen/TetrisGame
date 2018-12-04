package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Storage {
    public static SpriteBatch batch;
    public static AssetManager assetManager;
    public static BitmapFont font;
    public static Field field;

    public static void  loadTexture(String textureName){
        assetManager.load(textureName, Texture.class);
    }
    public static Texture getTexture(String textureName){
        return assetManager.get(textureName, Texture.class);
    }
    public static int getScreenHeight(){
        return Gdx.graphics.getHeight();
    }
    public static int getScreenWidth(){
        return Gdx.graphics.getWidth();
    }
    public static int getDeinvertedTouchY(){
        return getScreenHeight() - Gdx.input.getY();
    }
}
