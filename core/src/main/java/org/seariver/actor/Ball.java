package org.seariver.actor;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Stage;
import org.seariver.BaseActor;

public class Ball extends BaseActor {

    public boolean paused;

    public Ball(float x, float y, Stage stage) {
        super(x, y, stage);
        loadTexture("ball.png");
        setSpeed(400);
        setMotionAngle(90);
        setBoundaryPolygon(12);
        setPaused(true);
    }

    public boolean isPaused() {
        return paused;
    }

    public void setPaused(boolean paused) {
        this.paused = paused;
    }

    public void act(float deltaTime) {

        super.act(deltaTime);

        // simulate gravity
        if (!isPaused()) {
            setAcceleration(10);
            accelerateAtAngle(270);
            applyPhysics(deltaTime);
        }
    }

    public void bounceOff(BaseActor other) {

        Vector2 overlap = this.preventOverlap(other);

        if (Math.abs(overlap.x) >= Math.abs(overlap.y)) // horizontal bounce
            this.velocityVec.x *= -1;
        else // vertical bounce
            this.velocityVec.y *= -1;
    }
}
