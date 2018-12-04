package com.mygdx.game.states;

import com.mygdx.game.AssetsNames;
import com.mygdx.game.Button;
import com.mygdx.game.Image;
import com.mygdx.game.eventInterfaces.OnExitListener;
import com.mygdx.game.eventInterfaces.OnNewGameListener;

public class GameOverMenuState extends AbstractState{
    public OnExitListener onExitListener;
    public OnNewGameListener onNewGameListener;
    private Image gameOverImg;
    private Button closeBtn;
    private Button replayBtn;

    public GameOverMenuState() {
        gameOverImg = new Image(AssetsNames.GAME_OVER);
        gameOverImg.centerizeInTheScreen();
        closeBtn = new Button(AssetsNames.EXIT_TEXTURE);
        closeBtn.placeInBottomRightCorner();
        replayBtn = new Button(AssetsNames.REPLAY_BTN);
    }

    @Override
    public void update() {
        if(closeBtn.isClicked()){
            if(onExitListener != null){
                onExitListener.onExitRequested();
            }
        }
        if(replayBtn.isClicked()){
            if(onNewGameListener != null){
                onNewGameListener.onNewGameRequested();
            }
        }
    }

    @Override
    public void draw() {
        gameOverImg.draw();
        closeBtn.draw();
        replayBtn.draw();
    }

    @Override
    public void free() {

    }
}
