package com.fullskele.flavorful;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import squeek.applecore.api.food.FoodEvent;
import squeek.applecore.api.food.FoodValues;


public class FoodModifier {


    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public void getModifiedFoodValues(FoodEvent.GetFoodValues event) {
        ItemStack foodItem = event.food;

        if (foodItem != null && foodItem.hasTagCompound()) {
            assert foodItem.getTagCompound() != null;
            if (foodItem.getTagCompound().hasKey("seasoning", 3)) {
                int seasoningLevel = foodItem.getTagCompound().getInteger("seasoning") + 1;

                int newHunger = event.foodValues.hunger + (ConfigHandler.HUNGER_RESTORED * seasoningLevel);
                float newSaturation = event.foodValues.saturationModifier + (float)(ConfigHandler.SATURATION_RESTORED * seasoningLevel);

                event.foodValues = new FoodValues(newHunger, newSaturation);
            }
        }
    }
}