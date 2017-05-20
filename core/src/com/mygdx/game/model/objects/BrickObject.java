package com.mygdx.game.model.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

/**
 * Created by Kacper on 2017-05-16.
 */
public class BrickObject extends GameObject{
    private Sound beep;

    public BrickObject(){
        super();
        this.setColor(88/255f, 14/255, 2/255, 1);
        beep = Gdx.audio.newSound(Gdx.files.internal("beep.wav"));
    }
    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.end();
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(this.getColor());
        shapeRenderer.rect(this.getX() - this.getWidth()/2, this.getY() - this.getHeight()/2, this.getWidth(), this.getHeight());
        shapeRenderer.end();
        batch.begin();
    }

    @Override
    public void setDead(boolean dead) {
        super.setDead(dead);
        beep.play();
    }
}
