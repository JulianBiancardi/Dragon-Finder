package com.chiki.dragonfinder.item;

import com.chiki.dragonfinder.DragonFinder;
import com.github.alexthe666.iceandfire.entity.EntityFireDragon;
import com.github.alexthe666.iceandfire.entity.EntityIceDragon;
import com.github.alexthe666.iceandfire.entity.EntityLightningDragon;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.EyeOfEnder;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;

import java.util.List;

public class ItemDragonEye extends Item {

    public ItemDragonEye(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand interactionHand) {

        if(!level.isClientSide() && interactionHand == InteractionHand.MAIN_HAND ){
            ItemStack itemStack = player.getItemInHand(interactionHand);

            Entity dragon = findNearestDragons(level, player);

            if (dragon == null) {
                player.sendMessage(new TranslatableComponent("item." + DragonFinder.MODID + ".dragonpearl.nonfound"), player.getUUID());
                if(!player.isCreative()){
                    itemStack.shrink(1);
                }
                return super.use(level, player, interactionHand);
            }

            EyeOfEnder finderEntity = new EyeOfEnder(level, player.position().x, player.getY(0.5D), player.position().z);
            finderEntity.setItem(itemStack);
            finderEntity.signalTo(dragon.blockPosition());
            level.addFreshEntity(finderEntity);

            if(!player.isCreative()){
                itemStack.shrink(1);
            }
        }

        return super.use(level, player, interactionHand);
    }

    private Entity findNearestDragons(Level level, Player player){
        double boxSize = 500; //50 of each side
        AABB aabb = AABB.ofSize(player.position(),boxSize,boxSize,boxSize);
        int stageMin = 4;
        List<EntityIceDragon> iceDragons = level.getEntitiesOfClass(EntityIceDragon.class, aabb, (dragon -> dragon.getDragonStage() >= stageMin));
        List<EntityFireDragon> fireDragons = level.getEntitiesOfClass(EntityFireDragon.class, aabb, (dragon -> dragon.getDragonStage() >= stageMin));
        List<EntityLightningDragon> lightningDragons = level.getEntitiesOfClass(EntityLightningDragon.class, aabb, (dragon -> dragon.getDragonStage() >= stageMin));

        if (iceDragons.size() == 0 && fireDragons.size() == 0) {
            return null;
        }

        double nearestDistance = Integer.MAX_VALUE;
        Entity nearestEntity = null;
        for (EntityIceDragon entity : iceDragons) {
            double distance = entity.distanceTo(player);
            if (distance < nearestDistance) {
                nearestDistance = distance;
                nearestEntity = entity;
            }
        }
        for (EntityFireDragon entity : fireDragons) {
            double distance = entity.distanceTo(player);
            if (distance < nearestDistance) {
                nearestDistance = distance;
                nearestEntity = entity;
            }
        }
        for (EntityLightningDragon entity : lightningDragons) {
            double distance = entity.distanceTo(player);
            if (distance < nearestDistance) {
                nearestDistance = distance;
                nearestEntity = entity;
            }
        }

        return  nearestEntity;
    }
}
