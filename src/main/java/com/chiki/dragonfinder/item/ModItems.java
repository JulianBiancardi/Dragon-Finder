package com.chiki.dragonfinder.item;

import com.chiki.dragonfinder.DragonFinder;
import com.github.alexthe666.iceandfire.item.IafItemRegistry;
import com.github.alexthe666.iceandfire.item.IafTabRegistry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(
        modid = DragonFinder.MODID,
        bus = Mod.EventBusSubscriber.Bus.MOD
)
public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, DragonFinder.MODID);
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, DragonFinder.MODID);


    public static final RegistryObject<Item> COOCKED_F_DRAGON_FLESH = ITEMS.register("coocked_fire_dragon_flesh",
            () -> new Item(
                    new Item.Properties()
                            .stacksTo(64)
                            .food(new FoodProperties.Builder().nutrition(20).alwaysEat().build())));

    public static final RegistryObject<Item> COOCKED_I_DRAGON_FLESH = ITEMS.register("coocked_ice_dragon_flesh",
            () -> new Item(
                    new Item.Properties()
                            .stacksTo(64)
                            .food(new FoodProperties.Builder().nutrition(20).alwaysEat().build())));
    public static final RegistryObject<Item> COOCKED_L_DRAGON_FLESH = ITEMS.register("coocked_lightning_dragon_flesh",
            () -> new Item(
                    new Item.Properties()
                            .stacksTo(64)
                            .food(new FoodProperties.Builder().nutrition(20).alwaysEat().build())));

    public static final RegistryObject<Item> FIRE_DRAGON_EYE = ITEMS.register("fire_dragon_eye",
            () -> new ItemDragonEye(
                    new Item.Properties()
                            .stacksTo(64)));

    public static final RegistryObject<Item> ICE_DRAGON_EYE = ITEMS.register("ice_dragon_eye",
            () -> new ItemDragonEye(
                    new Item.Properties()
                            .stacksTo(64)));

    public static final RegistryObject<Item> LIGHTNING_DRAGON_EYE = ITEMS.register("lightning_dragon_eye",
            () -> new ItemDragonEye(
                    new Item.Properties()
                            .stacksTo(64)));

    @SubscribeEvent
    public static void buildCreativeModeTabs(BuildCreativeModeTabContentsEvent event) {
        ResourceKey<CreativeModeTab> tab = event.getTabKey();
        if (tab == IafTabRegistry.TAB_ITEMS.getKey()) {
            event.getEntries().putAfter(new ItemStack(IafItemRegistry.LIGHTNING_DRAGON_FLESH.get()), new ItemStack(COOCKED_F_DRAGON_FLESH.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(COOCKED_F_DRAGON_FLESH.get()), new ItemStack(COOCKED_I_DRAGON_FLESH.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(COOCKED_I_DRAGON_FLESH.get()), new ItemStack(COOCKED_L_DRAGON_FLESH.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(IafItemRegistry.LIGHTNING_DRAGON_BLOOD.get()), new ItemStack(FIRE_DRAGON_EYE.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(FIRE_DRAGON_EYE.get()), new ItemStack(ICE_DRAGON_EYE.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(ICE_DRAGON_EYE.get()), new ItemStack(LIGHTNING_DRAGON_EYE.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
        }
    }

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
