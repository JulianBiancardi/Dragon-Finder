package com.chiki.dragonfinder.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTab {
    public static final CreativeModeTab CREATIVE_MODE_TAB = new CreativeModeTab("dragonfinder") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.FIRE_DRAGON_EYE.get());
        }
    };
}
