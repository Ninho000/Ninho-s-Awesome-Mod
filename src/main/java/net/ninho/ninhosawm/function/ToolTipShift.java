package net.ninho.ninhosawm.function;

import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;

import java.util.function.Consumer;

public class ToolTipShift extends Item {

    private final String tooltipName;

    public ToolTipShift(Properties properties, String tooltipName) {
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
                            "tooltip.ninhosawm." + tooltipName + "_shift"
                    )
            );
        } else {
            builder.accept(
                    Component.translatable(
                            "tooltip.ninhowp." + tooltipName
                    )
            );
        }

        super.appendHoverText(itemStack, context, display, builder, tooltipFlag);
    }
}