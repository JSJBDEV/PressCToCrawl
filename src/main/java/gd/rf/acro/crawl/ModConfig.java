package gd.rf.acro.crawl;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.logging.LogManager;

@Mod.EventBusSubscriber(modid=Crawl.MODID,bus=Mod.EventBusSubscriber.Bus.MOD)
public class ModConfig {
    //template config from https://github.com/VsnGamer/ElevatorMod/blob/1.15.2/src/main/java/xyz/vsngamer/elevatorid/init/ModConfig.java
    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final CommonGeneral GENERAL = new CommonGeneral(BUILDER);
    public static final ForgeConfigSpec SPEC = BUILDER.build();
    public static class CommonGeneral
    {
        public final ForgeConfigSpec.BooleanValue shouldContinue;
        CommonGeneral(ForgeConfigSpec.Builder builder)
        {
            builder.push("General");
            shouldContinue=builder.comment("should forced crawling continue if the player moves?").define("shouldContinue",false);
            builder.pop();
        }
    }

    @SubscribeEvent
    public static void onLoad(final net.minecraftforge.fml.config.ModConfig.Loading event)
    {
        Crawl.LOGGER.debug("loaded crawl config");
    }
}
