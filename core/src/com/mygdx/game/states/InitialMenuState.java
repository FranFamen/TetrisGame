package com.mygdx.game.states;


import com.mygdx.game.AssetsNames;
import com.mygdx.game.Button;
import com.mygdx.game.Image;
import com.mygdx.game.eventInterfaces.OnExitListener;
import com.mygdx.game.eventInterfaces.OnNewGameListener;

public class InitialMenuState extends AbstractState {

    public OnExitListener onExitListener;
    public OnNewGameListener onRestartListener;
    private Button exitBtn;
    private Button startBtn;
    private Image tetrisLogoImg;

    public InitialMenuState() {
        exitBtn = new Button(AssetsNames.EXIT_TEXTURE);
        exitBtn.placeInBottomRightCorner();
        startBtn = new Button(AssetsNames.START_TEXTURE);
        startBtn.centerizeInTheScreen();
        tetrisLogoImg = new Image(AssetsNames.TETRIS_LOGO_TEXTURE);
        tetrisLogoImg.placeAtTheTop();
        tetrisLogoImg.centerizeHorizontally();
    }
    @Override
    public void update() {
        if(exitBtn.isClicked()){
            if(onExitListener != null) {
                onExitListener.onExitRequested();
            }
        }
        if(startBtn.isClicked()){
            if(onRestartListener != null){
                onRestartListener.onNewGameRequested();
            }
        }
    }
    @Override
    public void draw(){
        exitBtn.draw();
        startBtn.draw();
        tetrisLogoImg.draw();
    }
    @Override
    public void free() {
    }
}
