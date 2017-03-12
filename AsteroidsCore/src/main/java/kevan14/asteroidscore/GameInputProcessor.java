/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kevan14.asteroidscore;

import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputAdapter;
import kevan14.asteroidscommon.data.GameData;
import kevan14.asteroidscommon.data.GameKeys;

/**
 *
 * @author Kennet_Skole
 */
public class GameInputProcessor extends InputAdapter {

    private final GameData gameData;

    public GameInputProcessor(GameData gameData) {
        this.gameData = gameData;
    }

	public boolean keyDown(int k) {
		if(k == Keys.UP) {
                    gameData.getKeys().setKey(GameKeys.UP, true);
		}
		if(k == Keys.LEFT) {
                    gameData.getKeys().setKey(GameKeys.LEFT, true);
		}
		if(k == Keys.DOWN) {
                    gameData.getKeys().setKey(GameKeys.DOWN, true);
		}
		if(k == Keys.RIGHT) {
                    gameData.getKeys().setKey(GameKeys.RIGHT, true);
		}
		if(k == Keys.ENTER) {
                    gameData.getKeys().setKey(GameKeys.ENTER, true);
		}
		if(k == Keys.ESCAPE) {
                    gameData.getKeys().setKey(GameKeys.ESCAPE, true);
		}
		if(k == Keys.SPACE) {
                    gameData.getKeys().setKey(GameKeys.SPACE, true);
		}
		if(k == Keys.SHIFT_LEFT || k == Keys.SHIFT_RIGHT) {
                    gameData.getKeys().setKey(GameKeys.SHIFT, true);
		}
		return true;
	}
	
	public boolean keyUp(int k) {
		if(k == Keys.UP) {
                    gameData.getKeys().setKey(GameKeys.UP, false);
		}
		if(k == Keys.LEFT) {
                    gameData.getKeys().setKey(GameKeys.LEFT, false);
		}
		if(k == Keys.DOWN) {
                    gameData.getKeys().setKey(GameKeys.DOWN, false);
		}
		if(k == Keys.RIGHT) {
                    gameData.getKeys().setKey(GameKeys.RIGHT, false);
		}
		if(k == Keys.ENTER) {
                    gameData.getKeys().setKey(GameKeys.ENTER, false);
		}
		if(k == Keys.ESCAPE) {
                    gameData.getKeys().setKey(GameKeys.ESCAPE, false);
		}
		if(k == Keys.SPACE) {
                    gameData.getKeys().setKey(GameKeys.SPACE, false);
		}
		if(k == Keys.SHIFT_LEFT || k == Keys.SHIFT_RIGHT) {
                    gameData.getKeys().setKey(GameKeys.SHIFT, false);
		}
		return true;
	}
	
}
