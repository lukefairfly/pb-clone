package com.pbclone.project;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;

public class MainGameClass extends ApplicationAdapter {
	private SpriteBatch batch;
	private Texture ball;
	private Texture arrow;
	private OrthographicCamera mCamera;
	private Vector3 mTouchedPosition;
	private Sprite arrowSprite;
	private Sprite ballSprite;

	private boolean ballMovingFlag;

	private float y;
	private float x;

	private float angle = 90;

	private static final int SPEED_FACTOR = 15;


	BitmapFont font;

	@Override
	public void create () {

		mCamera = new OrthographicCamera();
		mCamera.setToOrtho(false,Gdx.graphics.getWidth(),Gdx.graphics.getHeight());

		batch = new SpriteBatch();
		ball = new Texture("ball_sprite.png");
		arrow = new Texture("arrow.png");
		arrowSprite = new Sprite(arrow);
		ballSprite = new Sprite(ball);

		font = new BitmapFont();

		x = Gdx.graphics.getWidth() / 2 - ball.getWidth() / 2;
		y = 0;
		ballSprite.setPosition(x,y);


	}

	@Override
	public void render () {

		mCamera.update();
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		batch.begin();


		if (y < Gdx.graphics.getHeight() - ball.getHeight() - SPEED_FACTOR) {

			ballMovingFlag = true;
			x += ( float ) ( Math.cos(Math.toRadians(angle)) * SPEED_FACTOR );
			y += ( float ) ( Math.sin(Math.toRadians(angle)) * SPEED_FACTOR );
		}
		else {
			ballMovingFlag = false;
		}




		if(Gdx.input.isTouched()) {
			int touchedX = Gdx.input.getX();
			if (touchedX < Gdx.graphics.getWidth()/2) arrowSprite.setRotation(arrowSprite.getRotation()+1);
			if (touchedX > Gdx.graphics.getWidth()/2) arrowSprite.setRotation(arrowSprite.getRotation()-1);
			angle = 90+arrowSprite.getRotation();
			x = Gdx.graphics.getWidth() / 2 - ball.getWidth() / 2;
			y = 0;
		}
		font.draw(batch, String.valueOf(angle), 50, 160);


		arrowSprite.setPosition(Gdx.graphics.getWidth() / 2 - arrow.getWidth() / 2  , 55);
		ballSprite.setPosition(x,y);
		arrowSprite.draw(batch);
		ballSprite.draw(batch);

		if (x <= 0 || x >= (Gdx.graphics.getWidth()-ball.getWidth())) {
			angle = 180-angle;
		}

		batch.end();
	}

	@Override
	public void dispose () {
		batch.dispose();
		ball.dispose();
		arrow.dispose();

	}
}
