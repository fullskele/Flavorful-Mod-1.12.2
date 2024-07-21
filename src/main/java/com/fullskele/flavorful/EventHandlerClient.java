package com.fullskele.flavorful;

import net.minecraft.client.resources.I18n;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;



public class EventHandlerClient {

    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    public void onFoodTooltip(ItemTooltipEvent event) {
        ItemStack stack = event.getItemStack();
        if (!stack.isEmpty() && stack.getItem() instanceof ItemFood && stack.hasTagCompound()
                && stack.getTagCompound().hasKey("seasoned")) {
            int seasoningLevel = stack.getTagCompound().getInteger("seasoned");

            if (seasoningLevel < 2) {
                event.getToolTip().add(
                        TextFormatting.GOLD + "" + TextFormatting.ITALIC + I18n.format("tooltip.flavorful.lightly_seasoned" + " (+" + seasoningLevel + ")"));
            } else if (seasoningLevel < 4) {
                event.getToolTip().add(
                        TextFormatting.GOLD + "" + TextFormatting.ITALIC + I18n.format("tooltip.flavorful.seasoned") + " (+" + seasoningLevel + ")");
            } else {
                event.getToolTip().add(
                        TextFormatting.GOLD + "" + TextFormatting.ITALIC + I18n.format("tooltip.flavorful.well_seasoned") + " (+" + seasoningLevel + ")");
            }
        }
    }
}
