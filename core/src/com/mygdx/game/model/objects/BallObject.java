package com.mygdx.game.model.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

/**
 * Created by Kacper on 2017-05-16.
 */
public class BallObject extends GameObject {
    private float radius;
    private Sound gameOver;

    public float getRadius() {
        return radius;
    }

    public void setRadius(float radius) {
        this.radius = radius;
    }

    public BallObject(float radius){
        super();
        this.radius = radius;
        gameOver = Gdx.audio.newSound(Gdx.files.internal("gameOver.wav"));
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.end();
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(this.getColor());
        shapeRenderer.circle(this.getX(), this.getY(), this.getRadius());
        shapeRenderer.end();
        batch.begin();
    }

    @Override
    public void setDead(boolean dead) {
        super.setDead(dead);
        gameOver.play();
    }
}
