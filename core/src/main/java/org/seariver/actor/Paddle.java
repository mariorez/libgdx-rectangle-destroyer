package org.seariver.actor;

import com.badlogic.gdx.scenes.scene2d.Stage;
import org.seariver.BaseActor;

public class Paddle extends BaseActor {

    public Paddle(float x, float y, Stage stage) {
        super(x, y, stage);
        loadTexture("paddle.png");
    }
}
