package com.fullskele.flavorful;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import java.io.File;

@Mod(modid = Main.MODID, name = Main.NAME, version = Main.VERSION)
public class Main {
    public static final String MODID = "flavorful";
    public static final String NAME = "Flavorful";
    public static final String VERSION = "1.0.1";

    public static File config;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {

        ConfigHandler.RegisterConfig(event);

        MinecraftForge.EVENT_BUS.register(new FoodModifier());

        MinecraftForge.EVENT_BUS.register(new FoodTooltipClient());

    }
}
