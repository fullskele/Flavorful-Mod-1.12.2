package com.fullskele.flavorful;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import java.io.File;

public class ConfigHandler {
    public static Configuration config;

    public static int HUNGER_RESTORED = 1;
    public static float SATURATION_RESTORED = 0.05f;

    public static Boolean TOOLTIP_ENABLED = true;
    public static Boolean TOOLTIP_LEVEL_ENABLED = true;

    public static int TOOLTIP_SEASON_THRESHOLD = 3;

    public static void init(File file) {

        config = new Configuration(file);

        String category;

        category = "Stat Increases";
        config.addCustomCategoryComment(category, "Tweak the stats that each level of seasoning provides.");
        HUNGER_RESTORED = config.getInt("Hunger Per Level", category, 1, 0, 100, "Hunger added per seasoning level");
        SATURATION_RESTORED = config.getFloat("Saturation Per Level", category, 0.05f, 0.0f, 100.0f, "Saturation per seasoning level");


        category = "Tooltip";
        config.addCustomCategoryComment(category, "Configs related to the tooltip. ");
        TOOLTIP_ENABLED = config.getBoolean("Toggle Tooltip", category, true, "Enable or disable the seasoning tooltip");
        TOOLTIP_LEVEL_ENABLED = config.getBoolean("Toggle Tooltip Level", category, true, "Enable or disable the level beside the tooltip: '(+X)'");
        TOOLTIP_SEASON_THRESHOLD = config.getInt("Tooltip Seasoning Threshold", category, 3, 1, 10000, "How many seasoning levels until the tooltip changes to the next tier");


        config.save();
    }

    public static void RegisterConfig(FMLPreInitializationEvent event) {
        Main.config = new File(event.getModConfigurationDirectory() + "/");
        init(new File(Main.config.getPath(), Main.MODID + ".cfg"));
    }
}
