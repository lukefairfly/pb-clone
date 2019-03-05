package com.pbclone.project;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Ball {

    private Texture texture;
    private Sprite sprite;

    private float x, y; //Position


    public Ball(int ballColor) {

        switch(ballColor) {
            case 0:
                texture = new Texture("ball_sprite.png");
                break;
            case 1:
                //Todo: Implement
                break;
            case 2:
                //Todo: Implement
                break;
            default:
                //Todo: Implement
        }

        sprite = new Sprite(texture);
    }


    public void setPosition (float x_value, float y_value) {
        x = x_value;
        y = y_value;
    }

    public void setPositionAsStarting () {
        x = Gdx.graphics.getWidth() / (float)2 - sprite.getWidth() / (float)2;
        y = 0;
    }


    public void update() {
        // Before this update character velocity, position, etc...
        sprite.setPosition(this.x, this.y);
    }


    public void draw(Batch batch) {
        // Behave as a sprite offering draw method
        sprite.draw(batch);
    }


}
