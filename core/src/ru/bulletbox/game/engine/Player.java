package ru.bulletbox.game.engine;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;

public class Player extends Sprite {
    /** player muved
     * ahahahahahahahahahahahah muved
     * really?
     * london is capital of great britain
     * */
    public float x, y, mspeed;
    private float gravity, vspeed;
    private float maximumSkorostiPoVerticaliRazvivaemoyPriPadenii;

    private boolean moveHor(double speed) {
        x += speed;
        return true;
    }

    public Player(Sprite sprite, int x, int y){
        super(sprite);
        this.x = (float)x;
        this.y = (float)y;
        mspeed = 5;
        vspeed = 0;
        gravity = 0.8f;
        maximumSkorostiPoVerticaliRazvivaemoyPriPadenii = 12;
    }

    @Override
    public void draw(Batch batch) {
        setPosition(x,y);
        update(Gdx.graphics.getDeltaTime());
        super.draw(batch);
    }

    public void update(float delta){

        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) moveHor(-mspeed);
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) moveHor(mspeed);

        // GRAVITY DEFINED
        if (vspeed + gravity < maximumSkorostiPoVerticaliRazvivaemoyPriPadenii)
            vspeed += gravity;
        else vspeed = maximumSkorostiPoVerticaliRazvivaemoyPriPadenii;

        y -= vspeed;

    }
}
