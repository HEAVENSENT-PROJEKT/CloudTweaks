package net.cloud.cloudtweaks.block.entity;

import net.cloud.cloudtweaks.CloudTweaks;
import net.cloud.cloudtweaks.block.modblocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class modblockents {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, CloudTweaks.MODID);

    public static final RegistryObject<BlockEntityType<PendtlerConfigurator>> ENT_PENDTLERMACHINE_1 =
            BLOCK_ENTITIES.register("ent_pendtlermachine_1", () ->
                    BlockEntityType.Builder.of(PendtlerConfigurator::new,
                            modblocks.PENDTLERMACHINE_1.get()).build(null));

    public static void register(IEventBus eventBus){ BLOCK_ENTITIES.register(eventBus); }
}