package com.fullskele.flavorful;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemSoup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class EventHandlerFood {

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public void onItemUseTick(LivingEntityUseItemEvent.Tick event) {
        ItemStack stack = event.getItem();
        if (!stack.isEmpty() && stack.getItem() instanceof ItemSoup && stack.hasTagCompound()
                && stack.getTagCompound().hasKey("seasoned")) {
            EntityLivingBase entityLiving = event.getEntityLiving();
            if (entityLiving instanceof EntityPlayer && event.getDuration() == 1) {
                EntityPlayer entityplayer = (EntityPlayer) entityLiving;

                int seasoningLevel = stack.getTagCompound().getInteger("seasoned");

                entityplayer.getFoodStats().addStats((1 + seasoningLevel), 0.15F*(1+seasoningLevel));
            }
        }
    }

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public void onItemUseFinish(LivingEntityUseItemEvent.Finish event) {
        ItemStack stack = event.getItem();
        if (!stack.isEmpty() && stack.getItem() instanceof ItemFood && stack.hasTagCompound()
                && stack.getTagCompound().hasKey("seasoned")) {
            EntityLivingBase entityLiving = event.getEntityLiving();
            if (entityLiving instanceof EntityPlayer) {
                EntityPlayer entityplayer = (EntityPlayer) entityLiving;

                int seasoningLevel = stack.getTagCompound().getInteger("seasoned");


                entityplayer.getFoodStats().addStats((1 + seasoningLevel), 0.15F*(1+seasoningLevel));
            }
        }
    }
}
