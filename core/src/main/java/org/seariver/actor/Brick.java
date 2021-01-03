package org.seariver.actor;

import com.badlogic.gdx.scenes.scene2d.Stage;
import org.seariver.BaseActor;

public class Brick extends BaseActor {

    public Brick(float x, float y, Stage stage) {
        super(x, y, stage);
        loadTexture("brick-gray.png");
    }
}
