package com.chiki.dragonfinder.item;

import com.chiki.dragonfinder.DragonFinder;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, DragonFinder.MODID);

    public static final RegistryObject<Item> COOCKED_F_DRAGON_FLESH = ITEMS.register("coocked_fire_dragon_flesh",
            () -> new Item(
                    new Item.Properties()
                            .stacksTo(64)
                            .food(new FoodProperties.Builder().nutrition(20).build())
                            .tab(ModCreativeModeTab.CREATIVE_MODE_TAB)));

    public static final RegistryObject<Item> COOCKED_I_DRAGON_FLESH = ITEMS.register("coocked_ice_dragon_flesh",
            () -> new Item(
                    new Item.Properties()
                            .stacksTo(64)
                            .food(new FoodProperties.Builder().nutrition(20).build())
                            .tab(ModCreativeModeTab.CREATIVE_MODE_TAB)));
    public static final RegistryObject<Item> COOCKED_L_DRAGON_FLESH = ITEMS.register("coocked_lightning_dragon_flesh",
            () -> new Item(
                    new Item.Properties()
                            .stacksTo(64)
                            .food(new FoodProperties.Builder().nutrition(20).build())
                            .tab(ModCreativeModeTab.CREATIVE_MODE_TAB)));

    public static final RegistryObject<Item> FIRE_DRAGON_EYE = ITEMS.register("fire_dragon_eye",
            () -> new ItemDragonEye(
                    new Item.Properties()
                            .stacksTo(64)
                            .tab(ModCreativeModeTab.CREATIVE_MODE_TAB)));

    public static final RegistryObject<Item> ICE_DRAGON_EYE = ITEMS.register("ice_dragon_eye",
            () -> new ItemDragonEye(
                    new Item.Properties()
                            .stacksTo(64)
                            .tab(ModCreativeModeTab.CREATIVE_MODE_TAB)));

    public static final RegistryObject<Item> LIGHTNING_DRAGON_EYE = ITEMS.register("lightning_dragon_eye",
            () -> new ItemDragonEye(
                    new Item.Properties()
                            .stacksTo(64)
                            .tab(ModCreativeModeTab.CREATIVE_MODE_TAB)));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
