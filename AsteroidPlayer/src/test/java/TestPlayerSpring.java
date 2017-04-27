
import junit.framework.Assert;
import kevan14.asteroidscommon.data.Entity;
import kevan14.asteroidscommon.data.EntityType;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kennet_Skole
 */
public class TestPlayerSpring {
    ApplicationContext ctx = new FileSystemXmlApplicationContext
        ("beans.xml");
    
    
    @Test
    public void objectCreation() {
        
        Entity playerShip = (Entity) ctx.getBean("playerShip");
        
        Assert.assertNotNull("Testing bean creation", playerShip);
        
    }
        
    @Test
    public void floatInjection() {
        
        Entity playerShip = (Entity) ctx.getBean("playerShip");
        
        Assert.assertEquals("Testing float injection", 1.5f, playerShip.getRadius());
    }
    
    @Test
    public void customEnumInjection() {
        Entity playerShip = (Entity) ctx.getBean("playerShip");
        
        Assert.assertEquals("Testing custom enum injection", EntityType.PLAYER,  playerShip.getType());
    }
}
