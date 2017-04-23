package kevan14.osgibosscontext;

import kevan14.asteroidscommon.spi.IEntityProcessingService;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator {

    public void start(BundleContext context) throws Exception {
        context.registerService(IEntityProcessingService.class, new OSGiBoss(), null);
    }

    public void stop(BundleContext context) throws Exception {
        // TODO add deactivation code here
    }
    
    

}
