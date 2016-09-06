package States;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.AirPong;

import Functionality.Controls;
import Functionality.HiScoreList;

public class ScoreScreen extends State {
	private Texture p1Background;
	private Texture p2Background;
	private Texture enter;
	private Texture[] backgroundTexture;
	private int back;
	private Controls cont;
	private long elapsedTime;

	/*
	 * The ScoreScreen method is the constructor for the ScoreScreen class.
	 * 
	 * @param GameStateManager gsm.
	 * 
	 */
	public ScoreScreen(GameStateManager gsm, int winner) {
		super(gsm);
		enter = new Texture("enter.png");
		
		backgroundTexture = new Texture[2];
		backgroundTexture[0] = new Texture("creditbackgroundp1W.jpg");
		backgroundTexture[1] = new Texture("creditbackgroundp2W.jpg");
		cont = new Controls();
		elapsedTime = System.nanoTime() - startTime;

	}
	/*
	 * (non-Javadoc)
	 * 
	 * @see States.State#handleInput()
	 */

	@Override
	public void handleInput() {
		if (Gdx.input.isKeyJustPressed(Keys.SPACE)) {
			gsm.set(new HiScores(gsm));
			dispose();
		}

	}
	/*
	 * (non-Javadoc)
	 * 
	 * @see States.State#update(float)
	 */

	@Override
	public void update(float dt) {
		whoWon();
		handleInput();

	}
	/*
	 * (non-Javadoc)
	 * 
	 * @see States.State#render(com.badlogic.gdx.graphics.g2d.SpriteBatch)
	 */

	@Override
	public void render(SpriteBatch sb) {
		sb.begin();
		sb.draw(backgroundTexture[back], 0, 0, AirPong.WIDTH, AirPong.HEIGHT);
		sb.end();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see States.State#dispose()
	 */
	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

	/*
	 * The whoWon method checks to see which player won and changes the
	 * background image to represent the correct winner.
	 * 
	 * 
	 */
	private void whoWon() {
		int p1 = cont.getP1Score();
		int p2 = cont.getP2Score();
		if (p1 == 7) {
			back = 0;

		}
		if (p2 == 7) {
			back = 1;

		}
	}

}
