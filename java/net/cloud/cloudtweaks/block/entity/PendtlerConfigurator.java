package net.cloud.cloudtweaks.block.entity;

import net.cloud.cloudtweaks.block.machines.PendtlerConfiguratorBlock;
import net.cloud.cloudtweaks.block.modblocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class PendtlerConfigurator extends BlockEntity implements MenuProvider {
    private final ItemStackHandler ItemHandler = new ItemStackHandler(5)
    {
        @Override
        protected void onContentsChanged(int slot) {
            setChanged();
        }
    };

    private LazyOptional<IItemHandler> lazyItemHandler = LazyOptional.empty();

    public PendtlerConfigurator(BlockPos pPos, BlockState pBlockState) {
        super(modblockents.ENT_PENDTLERMACHINE_1.get(), pPos, pBlockState);
        this.data = new ContainerData() {
            @Override
            public int get(int i) {
                return switch (i) {
                    case 0 -> PendtlerConfigurator.this.i_CurProgress;
                    case 1 -> PendtlerConfigurator.this.i_MaxProgress;
                    default -> 0;
                };
            }

            @Override
            public void set(int i, int v) {
                switch (i) {
                    case 0 -> PendtlerConfigurator.this.i_CurProgress = v;
                    case 1 -> PendtlerConfigurator.this.i_MaxProgress = v;
                };
            }

            @Override
            public int getCount() {
                return 2;
            }
        };
    }

    protected final ContainerData data;
    private int i_MaxProgress = 3650;
    private int i_CurProgress;

    @Override
    public Component getDisplayName() {
        return Component.translatable("Pendtler Configurator");
    }

    @Override
    public @Nullable AbstractContainerMenu createMenu(int i, Inventory inventory, Player player) {
        return null; // replaceme
    }

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if (cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY)
        {
            return lazyItemHandler.cast();
        }
        return super.getCapability(cap, side);
    }

    @Override
    public void onLoad() {
        super.onLoad();
        lazyItemHandler = LazyOptional.of(() -> ItemHandler);
    }

    @Override
    public void invalidateCaps() {
        super.invalidateCaps();
        lazyItemHandler.invalidate();
    }

    @Override
    protected void saveAdditional(CompoundTag pTag) {
        pTag.put("inventory", ItemHandler.serializeNBT());
        super.saveAdditional(pTag);
    }

    @Override
    public void load(CompoundTag pTag) {
        super.load(pTag);
        ItemHandler.deserializeNBT(pTag.getCompound("inventory"));
    }

    public void drops(){
        SimpleContainer inventory = new SimpleContainer(ItemHandler.getSlots());
        for (int i = 0; i < ItemHandler.getSlots(); i++) {
            inventory.setItem(i, ItemHandler.getStackInSlot(i));
        }

        Containers.dropContents(this.level, this.worldPosition, inventory);
    }

    private static void tick(Level level, BlockPos blockPos, BlockState blockState, PendtlerConfigurator pendtlerConfigurator) {
        if (level.isClientSide())
        {
            return;
        }

        if (im_b_HasRecipe(pEntity))
        {
            pEntity.progress++;
            setChanged(level, pos, state);

            if (pEntity.progress >= pEntity.max_progress)
            {
                configureItem(pEntity);
            }
        } else {
            pEntity.resetprogress();
            setChanged(level, pos, state);
        }
    }

    private static boolean im_b_HasRecipe(PendtlerConfigurator entity)
    {
        SimpleContainer inventory = new SimpleContainer(entity.ItemHandler.getSlots());

        return false;
    }

    private static void configureItem(PendtlerConfiguratorBlock pEntity)
    {

    }

    private void resetprogress()
    {

    }

}
