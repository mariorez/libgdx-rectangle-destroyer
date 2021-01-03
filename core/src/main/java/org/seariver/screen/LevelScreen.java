package org.seariver.screen;

import com.badlogic.gdx.Gdx;
import org.seariver.BaseActor;
import org.seariver.BaseScreen;
import org.seariver.actor.Paddle;
import org.seariver.actor.Wall;

public class LevelScreen extends BaseScreen {

    Paddle paddle;

    public void initialize() {

        BaseActor background = new BaseActor(0, 0, mainStage);
        background.loadTexture("space.png");
        BaseActor.setWorldBounds(background);

        paddle = new Paddle(320, 32, mainStage);

        new Wall(0, 0, 20, 600, mainStage); // left wall
        new Wall(780, 0, 20, 600, mainStage); // right wall
        new Wall(0, 550, 800, 50, mainStage); // top wall
    }

    public void update(float deltaTime) {
        float mouseX = Gdx.input.getX();
        paddle.setX(mouseX - paddle.getWidth() / 2);
        paddle.boundToWorld();
    }
}
