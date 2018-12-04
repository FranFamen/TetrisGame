package com.mygdx.game.states;

import com.mygdx.game.AssetsNames;
import com.mygdx.game.Button;
import com.mygdx.game.Image;
import com.mygdx.game.eventInterfaces.OnExitListener;
import com.mygdx.game.eventInterfaces.OnResumeListener;

public class PauseMenuState extends AbstractState {
    public OnExitListener onExitListener;
    public OnResumeListener onResumeListener;
    private Image pausedImg;
    private Button exitBtn;
    private Button resumeBtn;
    public PauseMenuState() {
        pausedImg = new Image(AssetsNames.PAUSED_BTN);
        pausedImg.centerizeInTheScreen();
        exitBtn = new Button(AssetsNames.EXIT_TEXTURE);
        exitBtn.placeInBottomRightCorner();
        resumeBtn = new Button(AssetsNames.RESUME_BTN);
    }

    @Override
    public void update() {
        if(exitBtn.isClicked()){
            if(onExitListener != null){
                onExitListener.onExitRequested();
            }
        }
        if(resumeBtn.isClicked()){
            if(onResumeListener != null){
                onResumeListener.onResumeRequested();
            }
        }

    }

    @Override
    public void draw() {
        pausedImg.draw();
        exitBtn.draw();
        resumeBtn.draw();
    }

    @Override
    public void free() {

    }
}
