package gd.rf.acro.crawl;

import net.java.games.input.Component;
import net.minecraft.client.KeyboardListener;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.client.util.InputMappings;
import net.minecraftforge.fml.client.registry.ClientRegistry;

public class Keybinds {
    public static KeyBinding crawl;
    public static void register()
    {
        crawl=new KeyBinding("key.crawl", 67,"category.crawl");
        ClientRegistry.registerKeyBinding(crawl);
    }
}
