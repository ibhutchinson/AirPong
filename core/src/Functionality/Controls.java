package Functionality;

import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;
import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;

import States.GameStateManager;
import States.ScoreScreen;

public class Controls {
	private int orangeHeight;
	private int blueHeight;
	private final int ORANGEBARWIDTH;
	private final int BLUEBARWIDTH;
	private final int TOP_BAR_STOP;
	private final int BOTTEM_BAR_STOP;
	private int ballX;
	private int ballY;
	private int xVelocity;
	private int yVelocity;
	private Music ballc;
	private Music ballg;
	private Rectangle2D ballBorders;
	private Shape player1;
	private Shape player1Back;
	private Shape player2;
	private Shape player2Back;
	private Shape goalZoneC;
	private Shape goalZoneC2;
	private Texture orangeBar;
	private Texture blueBar;
	private Texture ball;
	private Texture goalZone;
	private int p1Score;
	private int p2Score;
	private Random rand;
	private boolean aiOn;
	private GameStateManager gsm;
    /*
     * The Controls method is the constructor for the Controls class
     * 
     * 
     */
	public Controls() {
		orangeHeight = 250;
		blueHeight = 250;
		TOP_BAR_STOP = 630;
		BOTTEM_BAR_STOP = 1;
		ORANGEBARWIDTH = 1118;
		BLUEBARWIDTH = 290;
		ballX = 690;
		ballY = 360;
		xVelocity = -4;
		yVelocity = 4;
		ballc = Gdx.audio.newMusic(Gdx.files.internal("ballcollision.mp3"));
		ballg = Gdx.audio.newMusic(Gdx.files.internal("goalEffect.mp3"));
		orangeBar = new Texture("orangepongbar.png");
		blueBar = new Texture("bluepongbar.png");
		ball = new Texture("ball.png");
		goalZone = new Texture("goalzone.png");
		p1Score = 0;
		p2Score = 0;
		rand = new Random();
		aiOn = false;
		gsm = new GameStateManager();
	}

	/*
	 * blueControl handles the movement for the blue paddle in the game. This
	 * method also toggles the AI on and off. When the player presses the w key
	 * the system will increase the height at where the blue bar is rendered.
	 * When the player presses the s key the system will decrease the height at
	 * where the blue bar is rendered.
	 * 
	 * 
	 */

	public void blueControl() {
		int w = Keys.W;
		int s = Keys.S;
		if (Gdx.input.isKeyJustPressed(Keys.C)) {
			aiOn = true;
		}
		if (Gdx.input.isKeyJustPressed(Keys.V)) {
			aiOn = false;
		}
		if (!aiOn) {
			if (Gdx.input.isKeyPressed(w) && blueHeight < TOP_BAR_STOP) {
				blueHeight = blueHeight + 10;
			}
			if (Gdx.input.isKeyPressed(s) && blueHeight > BOTTEM_BAR_STOP) {
				blueHeight = blueHeight - 10;
			}
		} else {
			this.Ai();
		}

	}

	/*
	 * orangeControl handles the movement for the orange paddle in the game.
	 * This method also toggles the AI on and off. When the player presses the
	 * UP key the system will increase the height at where the orange bar is
	 * rendered. When the player presses the DWN key the system will decrease
	 * the height at where the orange bar is rendered.
	 * 
	 * 
	 */
	public void orangeControl() {
		int up = Keys.UP;
		int dwn = Keys.DOWN;
		if (Gdx.input.isKeyPressed(up) && orangeHeight < TOP_BAR_STOP) {
			orangeHeight = orangeHeight + 10;

		}
		if (Gdx.input.isKeyPressed(dwn) && orangeHeight > BOTTEM_BAR_STOP) {
			orangeHeight = orangeHeight - 10;

		}

	}

	/*
	 * ballMovement handles the property on how the ball moves around the field.
	 * 
	 * 
	 */

	public void ballMovement() {
		ballX = ballX + xVelocity;
		ballY = ballY + yVelocity;

		if (ballX < 150) {
			xVelocity = 9;

		} else if (ballX > 1200) {

			xVelocity = -9;
		}
		if (ballY < 0) {
			yVelocity = 9;

		} else if (ballY > 720) {

			yVelocity = -9;

		}

	}

	/*
	 * The collision method handles all the collision shapes in the game. An
	 * object is detected as colliding when it either intersects another shape
	 * or is contained in another shape.
	 * 
	 * 
	 */

	public void collision() {
		ballBorders = new Rectangle(ballX, ballY, ball.getWidth(), ball.getHeight());
		player1 = new Rectangle(BLUEBARWIDTH, blueHeight, blueBar.getWidth(), blueBar.getHeight());
		player1Back = new Rectangle(BLUEBARWIDTH - 20, blueHeight, blueBar.getWidth(), blueBar.getHeight());
		player2 = new Rectangle(ORANGEBARWIDTH, orangeHeight, orangeBar.getWidth(), orangeBar.getHeight());
		player2Back = new Rectangle(ORANGEBARWIDTH + 20, orangeHeight, orangeBar.getWidth(), orangeBar.getHeight());
		goalZoneC = new Rectangle(1190, 285, goalZone.getWidth(), goalZone.getHeight());
		goalZoneC2 = new Rectangle(130, 285, goalZone.getWidth(), goalZone.getHeight());
		if (player1.intersects(ballBorders)) {
			ballc.play();
		}
		if (player1.intersects(ballBorders) || player1.contains(ballBorders)) {
			xVelocity = 9;

		}
		if (player1Back.intersects(ballBorders)) {
			xVelocity = -9;
		}
		if (player2.intersects(ballBorders)) {
			ballc.play();

		}
		if (player2.intersects(ballBorders) || player2.contains(ballBorders)) {
			xVelocity = -9;

		}
		if (player2Back.intersects(ballBorders)) {
			xVelocity = 9;

		}
		if (goalZoneC.contains(ballBorders)) {
			ballg.play();
			ballX = rand.nextInt(500) + 450;
			ballY = rand.nextInt(500) + 200;
			p1Score=7;
		}
		if (goalZoneC2.contains(ballBorders)) {
			ballg.play();
			ballX = rand.nextInt(500) + 450;
			ballY = rand.nextInt(500) + 200;
			p2Score++;
		}

	}

	/*
	 * The AI method moves the paddle based on the height of the ball image. The
	 * movement speed is handicapped so that the AI is not unbeatable
	 * 
	 * 
	 */

	public void Ai() {
		if (blueHeight < ballY) {
			blueHeight = blueHeight + 4;
		}
		if (blueHeight > ballY) {
			blueHeight = blueHeight - 4;
		}
	}

	/*
	 * The method getP1Score is a getter method for Player one's score.
	 * 
	 * 
	 * @return this.p1Score.
	 */

	public int getP1Score() {
		return this.p1Score;
	}

	/*
	 * The method getP2Score is a getter method for Player two's score.
	 * 
	 * 
	 * @return this.p2Score.
	 */
	public int getP2Score() {
		return this.p2Score;
	}

	/*
	 * This method returns the orange bar's height on the screen for the Texture
	 * rendering
	 * 
	 * @return this.orangeHeight
	 */
	public int getOrangeHeight() {
		return this.orangeHeight;
	}

	/*
	 * This method sets the orange bar's height on the screen for the Texture
	 * rendering.
	 */
	public void setOrangeHeight(int newHeightO) {
		this.orangeHeight = newHeightO;

	}

	/*
	 * This method returns the blue bar's height on the screen for the Texture
	 * rendering
	 * 
	 * @return this.blueHeight
	 */
	public int getBlueHeight() {
		return this.blueHeight;
	}

	/*
	 * This method sets the blue bar's height on the screen for the Texture
	 * rendering.
	 */
	public void setBlueHeight(int newHeightB) {
		this.blueHeight = newHeightB;

	}

	/*
	 * This method returns the only width that the orange bar can be rendered at
	 * on the screen.
	 * 
	 * @return this.ORANGEBARWIDTH
	 */
	public int getOrangeWidth() {
		return this.ORANGEBARWIDTH;
	}

	/*
	 * This method returns the only width that the orange bar can be rendered at
	 * on the screen.
	 * 
	 * @return this.ORANGEBARWIDTH
	 */
	public int getBlueWidth() {
		return this.BLUEBARWIDTH;
	}

	/*
	 * This method returns the max height that any bar can be rendered to the
	 * screen at.
	 */
	public int getTopBarStop() {
		return this.TOP_BAR_STOP;
	}

	/*
	 * The method getBallX returns the x position of the ball.
	 * 
	 * 
	 * @return this.ballX.
	 */

	public int getBallX() {
		return this.ballX;
	}

	/*
	 * The method getBallY returns the y position of the ball.
	 * 
	 * 
	 * @return this.ballY.
	 */
	public int getBallY() {
		return this.ballY;
	}

}
