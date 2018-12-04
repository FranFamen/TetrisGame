package com.mygdx.game.states;

import com.badlogic.gdx.Gdx;
import com.mygdx.game.AssetsNames;
import com.mygdx.game.Button;
import com.mygdx.game.Constants;
import com.mygdx.game.Field;
import com.mygdx.game.Storage;
import com.mygdx.game.eventInterfaces.OnGameOverListener;
import com.mygdx.game.eventInterfaces.OnPauseListener;

public class PlayState extends AbstractState {
    public OnGameOverListener onGameOverListener;
    public OnPauseListener onPauseListener;

    private Button menuBtn;

    public PlayState() {
        menuBtn = new Button(AssetsNames.MENU_TEXTURE);
        menuBtn.placeInTopRightCorner();
        Storage.field = new Field();
        Storage.field.setCellSideLength((int)(Storage.getScreenWidth() *
                Constants.FIELD_WIDTH_TO_SCREEN_WIDTH_RATIO / Constants.FIELD_COL_COUNT));
        Storage.field.setVertOffset(Storage.getScreenHeight() - Storage.field.getHeight());
    }
    @Override
    public void update() {
        if(menuBtn.isClicked()){
            if(onPauseListener != null){
                onPauseListener.onPauseRequested();
            }
        }
        if(Gdx.input.justTouched()){
            if(Gdx.input.getX() < Storage.getScreenWidth()/2){
                onGameOverListener.onGameOverRequested();
            }
        }
    }
    @Override
    public void draw() {
        Storage.field.draw();
        menuBtn.draw();
        Storage.font.draw(Storage.batch, "PLAY STATE", 300, 400);
        Storage.font.draw(Storage.batch, "Lose the game", 100, 200);
    }
    @Override
    public void free() {

    }
}
