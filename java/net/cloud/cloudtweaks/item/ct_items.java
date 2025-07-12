package net.cloud.cloudtweaks.item;

import net.cloud.cloudtweaks.CloudTweaks;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ct_items {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, CloudTweaks.MODID);

    public static final RegistryObject<Item> PHENRYL = ITEMS.register("phenryl", () -> new Item( new Item.Properties().tab(CT_CModeTab.TAB_CTWKS).rarity(Rarity.RARE) ) );
    public static final RegistryObject<Item> PHELYMAR = ITEMS.register("phelymar", () -> new Item( new Item.Properties().tab(CT_CModeTab.TAB_CTWKS).rarity(Rarity.RARE) ) );
    public static final RegistryObject<Item> PENDTLERIUM = ITEMS.register("pendtlerium", () -> new Item( new Item.Properties().tab(CT_CModeTab.TAB_CTWKS).rarity(Rarity.UNCOMMON) ) );
    public static final RegistryObject<Item> PENDTLEROBJECT = ITEMS.register("pendtlerobject", () -> new Item( new Item.Properties().tab(CT_CModeTab.TAB_CTWKS).rarity(Rarity.RARE) ) );
    public static final RegistryObject<Item> PURE_PENDTLERIUM = ITEMS.register("pure_pendtlerium", () -> new Item( new Item.Properties().tab(CT_CModeTab.TAB_CTWKS).rarity(Rarity.EPIC) ) );
    public static final RegistryObject<Item> PENDTLERCPU = ITEMS.register("pendtlercpu", () -> new Item( new Item.Properties().tab(CT_CModeTab.TAB_CTWKS).rarity(Rarity.RARE) ) );
    public static final RegistryObject<Item> PENDTLERWIRE = ITEMS.register("pendtlerwire", () -> new Item( new Item.Properties().tab(CT_CModeTab.TAB_CTWKS).rarity(Rarity.RARE) ) );
    public static final RegistryObject<Item> CT_BLANKDISK = ITEMS.register("ct_blankdisk", () -> new Item( new Item.Properties().tab(CT_CModeTab.TAB_CTWKS) ) );

    public static void register(IEventBus eventBus) { ITEMS.register(eventBus); }
}
