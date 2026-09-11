package net.ninho.ninhosawm.item.modtooltips;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;

import java.util.function.Consumer;

public class ToolTip extends Item {

    private final String tooltipName;

    public ToolTip(Properties properties, String tooltipName) {
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