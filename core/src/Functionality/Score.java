package Functionality;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Score {
	
	private int player1Score;
	private int player2Score;
	private boolean player1Win;
	private boolean player2Win;

	private Texture[] numbers = new Texture[8];
	private Texture[] time = new Texture[10];
	
	public Score(){
		player1Score = 0;
		player2Score = 0;
		player1Win = false;
		player2Win = false;
		numbers[0] = new Texture("Numbers/0.png");
		numbers[1] = new Texture("Numbers/1.png");
		numbers[2] = new Texture("Numbers/2.png");
		numbers[3] = new Texture("Numbers/3.png");
		numbers[4] = new Texture("Numbers/4.png");
		numbers[5] = new Texture("Numbers/5.png");
		numbers[6] = new Texture("Numbers/6.png");
		numbers[7] = new Texture("Numbers/7.png");
		time[0] = new Texture("timenums/0.png");
		time[1] = new Texture("timenums/1.png");
		time[2] = new Texture("timenums/2.png");
		time[3] = new Texture("timenums/3.png");
		time[4] = new Texture("timenums/4.png");
		time[5] = new Texture("timenums/5.png");
		time[6] = new Texture("timenums/6.png");
		time[7] = new Texture("timenums/7.png");
		time[8] = new Texture("timenums/8.png");
		time[9] = new Texture("timenums/9.png");
		
		
	}
	
	public Texture getScoreP1 (int p1){

		return this.numbers[p1];
		
	}
	public Texture getScoreP2 (int p2){

		return this.numbers[p2];
		
	}
	public Texture getTime(int t1){
		return this.time[t1];
	}

}
