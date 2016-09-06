package States;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Matrix4;
import com.mygdx.game.AirPong;

import Functionality.Controls;
import Functionality.ListObject;

public class HiScores extends State {
	private Texture background;

	private Controls cont;
	private ArrayList<ListObject> hiList;
	private BitmapFont font;
	private long newHiScore;
	private ShapeRenderer sr;
	private Matrix4 normalProjection;
	
	

	public HiScores(GameStateManager gsm) {
		super(gsm);
		cont = new Controls();
		background = new Texture("hiScoreback.jpg");
		sr = new ShapeRenderer();
		font = new BitmapFont();
		normalProjection = new Matrix4().setToOrtho2D(0, 0, Gdx.graphics.getWidth(),  Gdx.graphics.getHeight());
	}

	@Override
	protected void handleInput() {
		

	}

	@Override
	public void update(float dt) {
		

	}

	@Override
	public void render(SpriteBatch sb) {
		sb.begin();
		sb.draw(background, 0, 0, AirPong.WIDTH, AirPong.HEIGHT);
		sb.end();
		sb.setProjectionMatrix(normalProjection);
		sb.begin();
		font.getData().setScale(5.5f);
		font.draw(sb,"Test", 600,700 );
		
		sb.end();
		
		

	}

	@Override
	public void dispose() {
		background.dispose();

	}
	
	public void checkHi(){
		if(hiList.isEmpty()){
			
		}
	}


}
