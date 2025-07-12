package net.cloud.cloudtweaks.block;

import net.cloud.cloudtweaks.CloudTweaks;
import net.cloud.cloudtweaks.block.machines.PendtlerConfiguratorBlock;
import net.cloud.cloudtweaks.item.CModeTab;
import net.cloud.cloudtweaks.item.moditems;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class modblocks {
    public static final DeferredRegister<Block> C_BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, CloudTweaks.MODID);

    public static final RegistryObject<Block> PHENRYL_BLOCK = registerBlock("phenryl_block",
      () -> new Block(BlockBehaviour.Properties.of(Material.METAL).destroyTime(8)
            .strength(6f).requiresCorrectToolForDrops()), CModeTab.TAB_CTWKS);

    public static final RegistryObject<Block> IMPURE_PENDTLERIUM_BLOCK = registerBlock("impure_pendtlerium_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL).destroyTime(8)
                    .strength(6f).requiresCorrectToolForDrops()), CModeTab.TAB_CTWKS);

    public static final RegistryObject<Block> PURE_PENDTLERIUM_BLOCK = registerBlock("pure_pendtlerium_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL).destroyTime(8)
                    .strength(6f).requiresCorrectToolForDrops()), CModeTab.TAB_CTWKS);

    public static final RegistryObject<Block> PHENRYL_ORE = registerBlock("phenryl_ore_block",
      () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE).destroyTime(8)
            .strength(6f).requiresCorrectToolForDrops(), UniformInt.of(6, 12)), CModeTab.TAB_CTWKS);

    public static final RegistryObject<Block> PHENRYL_DEEPSLATE_ORE = registerBlock("phenryl_deepslate_ore_block",
      () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE).destroyTime(8)
            .strength(6f).requiresCorrectToolForDrops(), UniformInt.of(6, 12)), CModeTab.TAB_CTWKS);

    public static final RegistryObject<Block> PENDTLERIUM_ORE = registerBlock("pendtlerium_ore_block",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE).destroyTime(8)
                    .strength(6f).requiresCorrectToolForDrops(), UniformInt.of(6, 12)), CModeTab.TAB_CTWKS);

    public static final RegistryObject<Block> PENDTLERIUM_DEEPSLATE_ORE = registerBlock("pendtlerium_deepslate_ore_block",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE).destroyTime(8)
                    .strength(6f).requiresCorrectToolForDrops(), UniformInt.of(6, 12)), CModeTab.TAB_CTWKS);

    public static final RegistryObject<Block> PENDTLERMACHINE_1 = registerBlock("pendtlermachine_1",
            () -> new PendtlerConfiguratorBlock(BlockBehaviour.Properties.of(Material.METAL).destroyTime(8)
                    .strength(6f).requiresCorrectToolForDrops()), CModeTab.TAB_CTWKS);

    private static <T extends Block>RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab)
    {
        RegistryObject<T> toReturn = C_BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }

    private static <T extends Block>RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block, CreativeModeTab tab)
    {
        return moditems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
    }

    public static void register(IEventBus eventBus){ C_BLOCKS.register(eventBus); }
}
