/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kevan14.asteroidsmodules;

import java.io.IOException;
import java.net.URL;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.logging.Level;
import junit.framework.Test;
import kevan14.asteroidscommon.spi.IEntityProcessingService;
import kevan14.asteroidscommon.spi.IGamePluginService;
import org.junit.Assert;
import static java.nio.file.Paths.get;
import static java.nio.file.Files.copy;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.netbeans.junit.NbModuleSuite;
import org.netbeans.junit.NbTestCase;
import org.openide.filesystems.FileObject;
import org.openide.filesystems.FileUtil;
import org.openide.util.Lookup;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author Kennet_Gamer
 */
public class ApplicationTest extends NbTestCase {
    
    
    private static final String ADD_ENEMY_UPDATES_FILE = "C:\\Users\\Kennet_Skole\\Desktop\\skole\\komponenter\\AsteroidsKomponenter\\application\\target\\test-classes\\enemy\\enemy_updates.xml";
    private static final String REM_ENEMY_UPDATES_FILE = "C:\\Users\\Kennet_Skole\\Desktop\\skole\\komponenter\\AsteroidsKomponenter\\application\\target\\test-classes\\remenemy\\noenemy_updates.xml";
    private static final String UPDATES_FILE = "C:\\Users\\Kennet_Skole\\Desktop\\skole\\komponenter\\AsteroidsKomponenter\\Update_Center\\netbeans_site\\updates.xml";

    public ApplicationTest(String name) {
        super(name);
    }

    public static Test suite() {
        return NbModuleSuite.createConfiguration(ApplicationTest.class).
                gui(false).
                failOnMessage(Level.WARNING).
                failOnException(Level.INFO).
                enableClasspathModules(false).
                clusters(".*").suite();
    }

    public void testApplication() throws InterruptedException, IOException, ParserConfigurationException, SAXException {
        List<IEntityProcessingService> processors = new CopyOnWriteArrayList<>();
        List<IGamePluginService> plugins = new CopyOnWriteArrayList<>();
        
        copy(get(REM_ENEMY_UPDATES_FILE), get(UPDATES_FILE), REPLACE_EXISTING);
        waitForUpdate(processors, plugins);

        Assert.assertEquals("Plugins found", 2, plugins.size());
        Assert.assertEquals("Processors found", 5, processors.size());

        copy(get(ADD_ENEMY_UPDATES_FILE), get(UPDATES_FILE), REPLACE_EXISTING);
        waitForUpdate(processors, plugins);
        
        Assert.assertEquals("Plugins found", 3, plugins.size());
        Assert.assertEquals("Processors found", 6, processors.size());

       Assert.assertTrue(true);
    }

    private void waitForUpdate(List<IEntityProcessingService> processors, List<IGamePluginService> plugins) throws InterruptedException {
        Thread.sleep(20000);

        processors.clear();
        processors.addAll(Lookup.getDefault().lookupAll(IEntityProcessingService.class));

        plugins.clear();
        plugins.addAll(Lookup.getDefault().lookupAll(IGamePluginService.class));
    }

}
