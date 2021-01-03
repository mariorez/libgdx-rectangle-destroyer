package org.seariver.actor;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import org.seariver.BaseActor;

public class Item extends BaseActor {

    public enum Type {
        PADDLE_EXPAND,
        PADDLE_SHRINK,
        BALL_SPEED_UP,
        BALL_SPEED_DOWN
    }

    private Type type;

    public Item(float x, float y, Stage stage) {
        super(x, y, stage);

        setRandomType();
        setSpeed(100);
        setMotionAngle(270);
        setSize(50, 50);
        setOrigin(25, 25);
        setBoundaryRectangle();
        setScale(0, 0);
        addAction(Actions.scaleTo(1, 1, 0.25f));
    }

    public void setType(Type type) {

        this.type = type;

        if (type == Type.PADDLE_EXPAND)
            loadTexture("items/paddle-expand.png");
        else if (type == Type.PADDLE_SHRINK)
            loadTexture("items/paddle-shrink.png");
        else if (type == Type.BALL_SPEED_UP)
            loadTexture("items/ball-speed-up.png");
        else if (type == Type.BALL_SPEED_DOWN)
            loadTexture("items/ball-speed-down.png");
        else
            loadTexture("items/item-blank.png");
    }

    public void setRandomType() {
        int randomIndex = MathUtils.random(0, Type.values().length - 1);
        Type randomType = Type.values()[randomIndex];
        setType(randomType);
    }

    public Type getType() {
        return type;
    }

    public void act(float deltaTime) {
        super.act(deltaTime);
        applyPhysics(deltaTime);
        if (getY() < -50) remove();
    }
}
