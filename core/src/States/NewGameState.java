package States;

import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.AirPong;

import Functionality.Controls;
import Functionality.Score;

public class NewGameState extends State {
	private Texture background;
	private Texture orangeBar;
	private Texture blueBar;
	private Texture ball;
	private Texture goalzone;
	private Texture colon;
	private Texture c;
	private Texture v;
	private int p1;
	private int p2;
	private int min;
	private int min2;
	private int sec;
	private int sec2;
	private Score score;
	private Controls controls;
	private char balls;

	/*
	 * The NewGameState method is the constructor for the NewGameState class.
	 * 
	 * @param GameStateManager gsm.
	 */
	public NewGameState(GameStateManager gsm) {
		super(gsm);
		background = new Texture("background.png");
		orangeBar = new Texture("orangepongbar.png");
		blueBar = new Texture("bluepongbar.png");
		ball = new Texture("ball.png");
		goalzone = new Texture("goalzone.png");
		colon = new Texture("timenums/colon.png");
		p1 = 0;
		p2 = 0;
		score = new Score();
		controls = new Controls();
		c = new Texture("aiPrompt.png");
		v = new Texture("vPrompt.png");
		gsm.gameMusic();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see States.State#handleInput()
	 */
	@Override
	protected void handleInput() {
		
		if (controls.getP1Score() == 7) {
			gsm.set(new ScoreScreen(gsm,0));
			gsm.sound2.stop();

		}
		if (controls.getP2Score() == 7) {
			gsm.set(new ScoreScreen(gsm,1));
			gsm.sound2.stop();

		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see States.State#update(float)
	 */
	@Override
	public void update(float dt) {
		controls.ballMovement();
		controls.orangeControl();
		controls.blueControl();
		controls.collision();
		handleInput();
		time();
	}
	/*
	 * (non-Javadoc)
	 * 
	 * @see States.State#render(com.badlogic.gdx.graphics.g2d.SpriteBatch)
	 */

	@Override
	public void render(SpriteBatch sb) {
		sb.begin();
		sb.draw(background, 0, 0, AirPong.WIDTH, AirPong.HEIGHT);
		sb.draw(ball, controls.getBallX(), controls.getBallY());
		sb.draw(orangeBar, controls.getOrangeWidth(), controls.getOrangeHeight());
		sb.draw(score.getTime(min), 610, 720);
		sb.draw(score.getTime(min2), 655, 720);
		sb.draw(score.getTime(sec), 730, 720);
		sb.draw(score.getTime(sec2), 775, 720);
		sb.draw(c, 5, 70);
		sb.draw(v, 5, 50);
		sb.draw(colon, 705, 725);
		// sb.draw(goalzone,120,285);
		sb.draw(blueBar, controls.getBlueWidth(), controls.getBlueHeight());
		sb.draw(score.getScoreP1(controls.getP1Score()), 0, 600);
		sb.draw(score.getScoreP2(controls.getP2Score()), 1335, 600);
		sb.end();
	}
	/*
	 * (non-Javadoc)
	 * 
	 * @see States.State#dispose()
	 */

	@Override
	public void dispose() {
		background.dispose();
		orangeBar.dispose();
		blueBar.dispose();

	}

	/*
	 * The time method converts system time to minutes and seconds and casts
	 * them into a string which is read by chatAt and then converted into a
	 * single int which is used as an Texture array index.
	 * 
	 * 
	 */
	private void time() {
		final long start = startTime;

		final long end = System.nanoTime();
		long elapsedTime = end - start;
		int totalSeconds = (int) (elapsedTime / 1000000000);
		int minutes = totalSeconds / 60;
		int seconds = totalSeconds % 60;
		String minutesS = String.valueOf(minutes);
		String secondsS = String.valueOf(seconds);
		char mp1 = ' ';
		char mp2 = ' ';
		if (minutesS.length() == 1) {
			mp1 = minutesS.charAt(0);
			min2 = Character.getNumericValue(mp1);
		}
		if (minutesS.length() == 2) {
			mp1 = minutesS.charAt(0);
			mp2 = minutesS.charAt(1);
			min = Character.getNumericValue(mp1);
			min2 = Character.getNumericValue(mp2);
		}
		char sp1 = ' ';
		char sp2 = ' ';
		if (secondsS.length() == 1) {
			sp1 = secondsS.charAt(0);
			sec = 0;
			sec2 = Character.getNumericValue(sp1);
		}
		if (secondsS.length() == 2) {
			sp1 = secondsS.charAt(0);
			sp2 = secondsS.charAt(1);
			sec = Character.getNumericValue(sp1);
			sec2 = Character.getNumericValue(sp2);
		}

	}

}
