/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kevan14.asteroidweapons;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import kevan14.asteroidscommon.data.Entity;

/**
 *
 * @author Kennet_Skole
 */
public class Bullet extends Entity {

    public Bullet() {

    }

    @Override
    public void render(ShapeRenderer sr) {

        sr.setColor(Color.WHITE);
        sr.begin(ShapeRenderer.ShapeType.Line);
        for (int i = 0, j = super.getShapeX().length - 1; i < super.getShapeX().length; j = i++) {
            sr.line(super.getShapeX()[i], super.getShapeY()[i], super.getShapeX()[j], super.getShapeY()[j]);
        }
        sr.end();
    }

}

