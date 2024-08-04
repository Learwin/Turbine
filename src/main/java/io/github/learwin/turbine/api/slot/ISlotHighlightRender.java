package io.github.learwin.turbine.api.slot;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.inventory.Slot;

/**
 * Implement to add special slot highlight rendering behaviour
 */
public interface ISlotHighlightRender {

    /**
     * @param guiGraphics the GuiGraphics object used for rendering.
     * @param slot        the slot being modified.
     * @param mouseX      the x-coordinate of the mouse cursor.
     * @param mouseY      the y-coordinate of the mouse cursor.
     * @param partialTick the partial tick time.
     */
    default void renderSlot(GuiGraphics guiGraphics, Slot slot, int mouseX, int mouseY, float partialTick) {
        if (slot.isHighlightable()) {
            guiGraphics.fillGradient(RenderType.guiOverlay(), slot.x, slot.y, slot.x + 16, slot.y + 16, -2130706433, -2130706433, 0);

        }
    }
}
