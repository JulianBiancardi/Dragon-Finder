package com.chiki.dragonfinder.item;

import com.chiki.dragonfinder.DragonFinder;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, DragonFinder.MODID);

    public static final RegistryObject<Item> DRAGON_PEARL = ITEMS.register("dragonpearl",
            () -> new Item(
                    new Item.Properties()
                            .stacksTo(1)
                            .tab(ModCreativeModeTab.CREATIVE_MODE_TAB)));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
