package gd.rf.acro.crawl;

import gd.rf.acro.crawl.blocks.CrawlBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistryEntry;

@Mod.EventBusSubscriber(modid = Crawl.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public final class ModEventSubscriber {

    @SubscribeEvent
    public static void onRegisterItems(RegistryEvent.Register<Item> event) {

    }
    @SubscribeEvent
    public static void onRegisterBlock(RegistryEvent.Register<Block> event)
    {
        event.getRegistry().registerAll(
                setup(new CrawlBlock(Block.Properties.create(Material.ANVIL).tickRandomly().hardnessAndResistance(0,0)),"crawl")
        );
    }


    public static <T extends IForgeRegistryEntry<T>> T setup(final T entry, final String name) {
        return setup(entry, new ResourceLocation(Crawl.MODID, name));
    }

    public static <T extends IForgeRegistryEntry<T>> T setup(final T entry, final ResourceLocation registryName) {
        entry.setRegistryName(registryName);
        return entry;
    }

}
