/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kevan14.asteroidscommon.spi;

import kevan14.asteroidscommon.data.GameData;
import kevan14.asteroidscommon.data.World;

/**
 *
 * @author Kennet_Skole
 */
public interface IEntityProcessingService {
    public void process(GameData gameData, World world);
}
