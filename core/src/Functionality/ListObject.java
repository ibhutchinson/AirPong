package Functionality;

import com.badlogic.gdx.graphics.g2d.BitmapFont;

public class ListObject {
     private char[] name;
     private long score;
     
     
     public ListObject(char[] _name, long _score){
    	 name = _name;
    	 score = _score;
     }
     
     public long getScore(){
    	 return this.score;
     }
     
     public char[] getName(){
    	 return this.name;
     }
}
