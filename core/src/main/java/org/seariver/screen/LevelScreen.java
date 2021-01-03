package org.seariver.screen;

import com.badlogic.gdx.Gdx;
import org.seariver.BaseActor;
import org.seariver.BaseScreen;
import org.seariver.actor.Ball;
import org.seariver.actor.Brick;
import org.seariver.actor.Paddle;
import org.seariver.actor.Wall;

public class LevelScreen extends BaseScreen {

    Paddle paddle;
    Ball ball;

    public void initialize() {

        BaseActor background = new BaseActor(0, 0, mainStage);
        background.loadTexture("space.png");
        BaseActor.setWorldBounds(background);

        paddle = new Paddle(320, 32, mainStage);

        new Wall(0, 0, 20, 600, mainStage); // left wall
        new Wall(780, 0, 20, 600, mainStage); // right wall
        new Wall(0, 550, 800, 50, mainStage); // top wall

        ball = new Ball(0, 0, mainStage);

        Brick tempBrick = new Brick(0, 0, mainStage);
        float brickWidth = tempBrick.getWidth();
        float brickHeight = tempBrick.getHeight();
        tempBrick.remove();

        int totalRows = 10;
        int totalCols = 10;
        float marginX = (800 - totalCols * brickWidth) / 2;
        float marginY = (600 - totalRows * brickHeight) - 120;

        for (int rowNum = 0; rowNum < totalRows; rowNum++) {
            for (int colNum = 0; colNum < totalCols; colNum++) {
                float x = marginX + brickWidth * colNum;
                float y = marginY + brickHeight * rowNum;
                new Brick(x, y, mainStage);
            }
        }
    }

    public void update(float deltaTime) {
        float mouseX = Gdx.input.getX();
        paddle.setX(mouseX - paddle.getWidth() / 2);
        paddle.boundToWorld();

        if (ball.isPaused()) {
            ball.setX(paddle.getX() + paddle.getWidth() / 2 - ball.getWidth() / 2);
            ball.setY(paddle.getY() + paddle.getHeight() / 2 + ball.getHeight() / 2);
        }
    }

    public boolean touchDown(int screenX, int screenY, int pointer, int button) {

        if (ball.isPaused()) {
            ball.setPaused(false);
        }

        return false;
    }
}
