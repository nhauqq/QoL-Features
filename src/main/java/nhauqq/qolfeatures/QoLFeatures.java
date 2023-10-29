package nhauqq.qolfeatures;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class QoLFeatures implements ModInitializer {
    public static final String MOD_ID = "qolfeatures";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        LOGGER.info("QoL Features initialized.");
    }
}
