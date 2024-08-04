package io.github.learwin.turbine.api.slot;

import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;

import javax.annotation.Nullable;

/**
 * Implement to add special slot content rendering behaviour
 */
public interface ISlotContentRender {

    /**
     * @param guiGraphics       the GuiGraphics object used for rendering.
     * @param itemstack         the itemstack being rendered.
     * @param slot              the slot being modified.
     * @param font              the used font.
     * @param seedValueModifier value used as seed.
     * @param countString       string representation of the stacks count.
     */
    default void renderSlotContents(GuiGraphics guiGraphics, ItemStack itemstack, Slot slot, Font font, int seedValueModifier, @Nullable String countString) {
        int i = slot.x;
        int j = slot.y;
        int j1 = slot.x + slot.y * seedValueModifier;

        if (slot.isFake()) {
            guiGraphics.renderFakeItem(itemstack, i, j, j1);
        } else {
            guiGraphics.renderItem(itemstack, i, j, j1);
        }

        guiGraphics.renderItemDecorations(font, itemstack, i, j, countString);
    }
}
