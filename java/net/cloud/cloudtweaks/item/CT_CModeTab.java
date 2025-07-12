package net.cloud.cloudtweaks.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class CT_CModeTab {
    public static CreativeModeTab TAB_CTWKS = new CreativeModeTab("tab_ctwks") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ct_items.PHENRYL.get());
        }
    };


}
