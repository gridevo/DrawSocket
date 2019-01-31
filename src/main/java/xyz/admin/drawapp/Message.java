/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyz.admin.drawapp;

/**
 *
 * @author Administratör
 */
public class Message {

    private String colorCode;
    private int posX;
    private int posY; 

    public String getColorCode() {
        return colorCode;
    }

    public void setColorCode(String colorCode) {
        this.colorCode = colorCode;
    }

    public int getCoordX() {
        return posX;
    }

    public void setCoordX(int coordX) {
        this.posX = coordX;
    }

    public int getCoordY() {
        return posY;
    }

    public void setCoordY(int coordY) {
        this.posY = coordY;
    }

    public Message(String colorCode, int posX, int posY) {
        this.colorCode = colorCode;
        this.posX = posX;
        this.posY = posY;
    }

}
