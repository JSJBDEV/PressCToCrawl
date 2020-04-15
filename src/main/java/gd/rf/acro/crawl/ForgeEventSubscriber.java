package gd.rf.acro.crawl;

import gd.rf.acro.crawl.init.ModBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.MinecraftServer;
import net.minecraft.tags.Tag;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.common.Tags;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.server.ServerLifecycleHooks;

@Mod.EventBusSubscriber(bus= Mod.EventBusSubscriber.Bus.FORGE)
public class ForgeEventSubscriber {
    @SubscribeEvent
    public static void onKey(InputEvent.KeyInputEvent event)
    {
        if(Keybinds.crawl.isPressed())
        {
            MinecraftServer server = ServerLifecycleHooks.getCurrentServer();
            PlayerEntity player =server.getPlayerList().getPlayerByUUID(Minecraft.getInstance().player.getUniqueID());
            if(ModConfig.GENERAL.shouldContinue.get())
            {
                if(player.getTags().contains("crawling"))
                {
                    player.removeTag("crawling");
                    if(player.getEntityWorld().getBlockState(player.getPosition().up()).getBlock()==ModBlocks.crawl)
                    {
                        player.getEntityWorld().setBlockState(player.getPosition().up(), Blocks.AIR.getDefaultState());
                    }
                }
                else
                {
                    player.addTag("crawling");
                }
            }
            else
            {
                if(player.getEntityWorld().getBlockState(player.getPosition().up()).getBlock()== Blocks.AIR)
                {
                    player.getEntityWorld().setBlockState(player.getPosition().up(), ModBlocks.crawl.getDefaultState());
                }
            }
        }
    }
    @SubscribeEvent
    public static void continueCrawl(PlayerEvent.LivingUpdateEvent event)
    {
        if(event.getEntityLiving().getTags().contains("crawling"))
        {
            event.getEntityLiving().getEntityWorld().setBlockState(event.getEntityLiving().getPosition().up(), ModBlocks.crawl.getDefaultState());
        }
    }
}
