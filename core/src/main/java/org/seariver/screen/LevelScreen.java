package org.seariver.screen;

import com.badlogic.gdx.Gdx;
import org.seariver.BaseActor;
import org.seariver.BaseScreen;
import org.seariver.actor.Paddle;

public class LevelScreen extends BaseScreen {

    Paddle paddle;

    public void initialize() {

        BaseActor background = new BaseActor(0, 0, mainStage);
        background.loadTexture("space.png");
        BaseActor.setWorldBounds(background);

        paddle = new Paddle(320, 32, mainStage);
    }

    public void update(float deltaTime) {
        float mouseX = Gdx.input.getX();
        paddle.setX(mouseX - paddle.getWidth() / 2);
        paddle.boundToWorld();
    }
}
