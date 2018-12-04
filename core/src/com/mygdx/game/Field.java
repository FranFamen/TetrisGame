package com.mygdx.game;

public class Field {
    private int cellSideLength;
    private int vertOffset;
    public Field() {

    }

    public void draw(){
        for(int iCol = 0; iCol < Constants.FIELD_COL_COUNT; iCol++) {
            for(int iRow = 0; iRow < Constants.FIELD_ROW_COUNT; iRow++) {
                Storage.batch.draw(Storage.getTexture(AssetsNames.FIELD_CELL_TEXTURE),
                        iCol * cellSideLength, vertOffset + iRow * cellSideLength, cellSideLength, cellSideLength);
            }
        }
    }

    public void setCellSideLength(int cellSideLength) {
        this.cellSideLength = cellSideLength;
    }

    public void setVertOffset(int vertOffset) {
        this.vertOffset = vertOffset;
    }
    public int getHeight(){
        return Constants.FIELD_ROW_COUNT * cellSideLength;
    }
}
