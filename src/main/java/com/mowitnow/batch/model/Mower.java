package com.mowitnow.batch.model;


import com.mowitnow.batch.utils.Orientation;
import lombok.Data;

@Data
public class Mower {

    private int x;
    private int y;
    private Orientation orientation;
    private String instructions;


    public Mower(int x, int y, Orientation orientation, String instructions) {
        this.x = x;
        this.y = y;
        this.orientation = orientation;
        this.instructions = instructions;
    }

    public Mower() {

    }

    public void move() {
        switch (orientation) {
            case N:
                y++;
                break;
            case E:
                x++;
                break;
            case S:
                y--;
                break;
            case W:
                x--;
                break;
        }
    }

    public void rotate(char direction) {
        if (direction == 'D') {
            orientation = orientation.right();
        } else if (direction == 'G') {
            orientation = orientation.left();
        }
    }

    public String getPosition() {
        return x + " " + y + " " + orientation;
    }


}





