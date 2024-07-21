package com.fullskele.flavorful;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Main.MODID, name = Main.NAME, version = Main.VERSION)
public class Main {
    public static final String MODID = "flavorful";
    public static final String NAME = "Flavorful";
    public static final String VERSION = "1.0";

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(new EventHandlerFood());
        MinecraftForge.EVENT_BUS.register(new EventHandlerClient());

        if (Loader.isModLoaded("appleskin"))
            AppleSkinCompat.initialize();
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        // some example code
    }


}
