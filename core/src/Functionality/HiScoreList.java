package Functionality;

import java.util.ArrayList;
import java.util.Collections;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.TextInputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextArea;

public class HiScoreList implements TextInputListener {
	private Stage stage;
	private Skin skin;
	private TextArea textArea;
	private ArrayList<ListObject> hiScoreList;
	private String name;

	public HiScoreList() {
		hiScoreList = new ArrayList<ListObject>();
		stage = new Stage();
		Gdx.input.setInputProcessor(stage);
		skin = new Skin(Gdx.files.internal("uiskin.json"));
		textArea = new TextArea(this.toString(), skin);
		textArea.setX(500);
		textArea.setY(100);
		textArea.setWidth(500);
		textArea.setHeight(300);

		textArea.setDisabled(true);

		stage.addActor(textArea);

	}

	public Stage getStage() {
		return this.stage;
	}
	
	public void newHiscoreCheck(int score) {
		int hold = 0;
		if (hiScoreList.isEmpty()) {
			Gdx.input.getTextInput(this, "Name:", "Type your name", name);
			hiScoreList.add(new ListObject(name, score));
		}

	}
	public String toString() {
		String hold = "High Score's \n";
         
		for (int i = 0; i < hiScoreList.size(); i++) {
			hold += String.valueOf(i) + ". " + hiScoreList.get(i).getName() + " "
					+ String.valueOf(hiScoreList.get(i).getScore());
		}

		return hold;
	}



	@Override
	public void input(String text) {
		this.name = text;

	}

	@Override
	public void canceled() {
		// TODO Auto-generated method stub

	}
}
