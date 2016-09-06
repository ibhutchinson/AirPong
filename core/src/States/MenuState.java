package States;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.AirPong;




public class MenuState extends State {
	private Texture background;
	private Texture newGame;
	private Texture logo;
	private Music sound;

	/*
	 * The method MenuState is the constructor for the MenuState class.
	 * 
	 * 
	 * @param GameStateManger gsm.
	 */
	public MenuState(GameStateManager gsm) {
		super(gsm);
		background = new Texture("menubackground.png");
		newGame = new Texture("newgame.png");
		logo = new Texture("airpong.png");
		gsm.menuMusic();
	}

	/*
	 * (non-Javadoc)
	 * @see States.State#handleInput()
	 */
	protected void handleInput() {
		if(Gdx.input.justTouched()){
			gsm.set(new NewGameState(gsm));
			GameStateManager.sound.stop();
			dispose();
		}

	}

	/*
	 * (non-Javadoc)
	 * @see States.State#update(float)
	 */
	public void update(float dt) {
		handleInput();
		

	}

    /*
     * (non-Javadoc)
     * @see States.State#render(com.badlogic.gdx.graphics.g2d.SpriteBatch)
     */
	public void render(SpriteBatch sb) {
		
		sb.begin();
		sb.draw(background, 0, 0,AirPong.WIDTH,AirPong.HEIGHT);
		sb.draw(newGame,170,200);
		sb.draw(logo,350,400);
		sb.end();

	}

	/*
	 * (non-Javadoc)
	 * @see States.State#dispose()
	 */
	public void dispose() {
		background.dispose();

	}

}
