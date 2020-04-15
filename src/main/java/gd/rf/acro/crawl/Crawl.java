package gd.rf.acro.crawl;

import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(Crawl.MODID)
public class Crawl {
    public static final String MODID = "crawl";
    public static final Logger LOGGER = LogManager.getLogger(MODID);

    public Crawl()
    {
        LOGGER.debug("Time to do some crawling!");
        ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, gd.rf.acro.crawl.ModConfig.SPEC);
        Keybinds.register();
    }
}
