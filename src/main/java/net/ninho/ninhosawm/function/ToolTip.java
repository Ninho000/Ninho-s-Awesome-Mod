package net.ninho.ninhosawm.function;

import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;

import java.util.function.Consumer;
/*
"  ToolTipBuildHelper  "
It's an implement to simplificate the use of tooltip for items on the 'ModItems' Register
*/
public class ToolTip {
    //For Normal Items
    public static class item extends Item {

        private final String tooltipName;

        public item(Properties properties, String tooltipName) {
            super(properties);
            this.tooltipName = tooltipName;
        }

        @Override
        public void appendHoverText(
                ItemStack itemStack,
                TooltipContext context,
                TooltipDisplay display,
                Consumer<Component> builder,
                TooltipFlag tooltipFlag
        ) {
            builder.accept(
                    Component.translatable("tooltip.ninhosawm." + tooltipName)
            );

            super.appendHoverText(itemStack, context, display, builder, tooltipFlag);
        }
    }

    public static class itemShift extends Item {

        private final String tooltipName;

        public itemShift(Properties properties, String tooltipName) {
            super(properties);
            this.tooltipName = tooltipName;
        }

        @Override
        public void appendHoverText(
                ItemStack itemStack,
                TooltipContext context,
                TooltipDisplay display,
                Consumer<Component> builder,
                TooltipFlag tooltipFlag
        ) {
            if (Minecraft.getInstance().hasShiftDown()) {
                builder.accept(
                        Component.translatable(
                                "tooltip.ninhosawm." + tooltipName + "_shift")
                );
            } else {
                builder.accept(
                        Component.translatable(
                                "tooltip.ninhosawm." + tooltipName)
                                .append(Component.translatable("tooltip.ninhosawm.press_shift"))
                );
            }

            super.appendHoverText(itemStack, context, display, builder, tooltipFlag);
        }
    }

    // For Mob Spawners
    public static class spawner extends SpawnEggItem {

        private final String tooltipName;

        public spawner(Properties properties, String tooltipName) {
            super(properties);
            this.tooltipName = tooltipName;
        }

        @Override
        public void appendHoverText(
                ItemStack itemStack,
                TooltipContext context,
                TooltipDisplay display,
                Consumer<Component> builder,
                TooltipFlag tooltipFlag
        ) {
            builder.accept(
                    Component.translatable("tooltip.ninhosawm." + tooltipName)
            );

            super.appendHoverText(itemStack, context, display, builder, tooltipFlag);
        }
    }

    public static class spawnerShift extends SpawnEggItem {

        private final String tooltipName;

        public spawnerShift(Properties properties, String tooltipName) {
            super(properties);
            this.tooltipName = tooltipName;
        }

        @Override
        public void appendHoverText(
                ItemStack itemStack,
                TooltipContext context,
                TooltipDisplay display,
                Consumer<Component> builder,
                TooltipFlag tooltipFlag
        ) {
            if (Minecraft.getInstance().hasShiftDown()) {
                builder.accept(
                        Component.translatable(
                                "tooltip.ninhosawm." + tooltipName + "_shift")
                );
            } else {
                builder.accept(
                        Component.translatable(
                                "tooltip.ninhosawm." + tooltipName)
                                .append(Component.translatable("tooltip.ninhosawm.press_shift"))
                );
            }

            super.appendHoverText(itemStack, context, display, builder, tooltipFlag);
        }
    }

}
