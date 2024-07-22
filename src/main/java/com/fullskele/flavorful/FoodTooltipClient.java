package com.fullskele.flavorful;

import net.minecraft.client.resources.I18n;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class FoodTooltipClient {


    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    public void onFoodTooltip(ItemTooltipEvent event) {

        if (ConfigHandler.TOOLTIP_ENABLED) {
            ItemStack stack = event.getItemStack();
            if (stack.hasTagCompound()) {
                assert stack.getTagCompound() != null;
                if (stack.getTagCompound().hasKey("seasoning", 3)) {
                    int seasoningLevel = stack.getTagCompound().getInteger("seasoning") + 1;
                    String tooltip = "ERROR";

                    if (seasoningLevel < ConfigHandler.TOOLTIP_SEASON_THRESHOLD) {
                        tooltip = I18n.format("tooltip.flavorful.lightly_seasoned");

                    } else if (seasoningLevel < ConfigHandler.TOOLTIP_SEASON_THRESHOLD*2) {
                        tooltip = I18n.format("tooltip.flavorful.seasoned");

                    } else {
                        tooltip = I18n.format("tooltip.flavorful.well_seasoned");
                    }

                    if (ConfigHandler.TOOLTIP_LEVEL_ENABLED) {
                        tooltip += " (+" + seasoningLevel + ")";
                    }

                    event.getToolTip().add(TextFormatting.GOLD + "" + TextFormatting.ITALIC + I18n.format(tooltip));
                }
            }
        }

    }
}