/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kevan14.asteroidasteroids;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.MathUtils;
import kevan14.asteroidscommon.data.Entity;
import kevan14.asteroidscommon.data.EntityColor;
import kevan14.asteroidscommon.data.EntityType;

/**
 *
 * @author Kennet_Skole
 */
public class Asteroid extends Entity {

    private int numPoints;
    private float[] dists;
    private int width;


    public Asteroid(float x, float y, EntityType type) {
        super.setX(x);
        super.setY(y);
        super.setType(type);
        super.setColor(EntityColor.GREEN);

        numPoints = 8;
        width = 25;
        super.setMaxSpeed(30);

        super.setRotationSpeed(1);

        super.setRadians(MathUtils.random(2 * 3.1415f));
        super.setDx(MathUtils.cos(super.getRadians()) * super.getMaxSpeed());
        super.setDy(MathUtils.sin(super.getRadians()) * super.getMaxSpeed());
        super.setRadius(width / 2);
        dists = new float[numPoints];

        for (int i = 0; i < numPoints; i++) {
            dists[i] = MathUtils.random(super.getRadius() / 2, super.getRadius());
        }


    }
    
   

    public int getNumPoints() {
        return numPoints;
    }

    public void setNumPoints(int numPoints) {
        this.numPoints = numPoints;
    }

    public float[] getDists() {
        return dists;
    }

    public void setDists(float[] dists) {
        this.dists = dists;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    
}

