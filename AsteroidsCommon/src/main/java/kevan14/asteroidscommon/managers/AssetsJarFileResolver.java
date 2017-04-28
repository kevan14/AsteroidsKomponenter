/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kevan14.asteroidscommon.managers;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.FileHandleResolver;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import java.io.File;

/**
 *
 * @author Kennet
 */
public class AssetsJarFileResolver implements FileHandleResolver {

    
    String url = new File("")+ "C:/Users/Kennet/Documents/NetbeansProjects/Dario2D/Dario2D/Core/target/Core-1.0.0-SNAPSHOT.jar!/assets/images/";
    
    @Override
    public FileHandle resolve(String fileName) {

        return new JarFileHandleStream(url+fileName);
    }

    public Texture returnTexture(String file) {
        if(file==null) {
            return null;
        }
        AssetsJarFileResolver fr = new AssetsJarFileResolver();
        AssetManager am = new AssetManager(fr);
        
        am.load(file, File.class);
        am.finishLoading();
        Texture tex = am.get(file, Texture.class);
        
        
        return tex;
    }
    
    public TmxMapLoader returnTmx(String file) {
        if(file==null) {
            return null;
        }
        AssetsJarFileResolver fr = new AssetsJarFileResolver();
        AssetManager am = new AssetManager(fr);
        
        am.load(file, TmxMapLoader.class);
        am.finishLoading();
        TmxMapLoader tmx = am.get(file, TmxMapLoader.class);
        
        return tmx;
    }


}