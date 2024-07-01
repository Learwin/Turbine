package io.github.learwin.turbine.api.slot;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.inventory.Slot;

public interface ISlotRender {

    default void renderSlot(GuiGraphics pGuiGraphics, Slot slot, int mouseX, int mouseY, float partialTick) {
        if (slot.isHighlightable()) {
            pGuiGraphics.fillGradient(RenderType.guiOverlay(), slot.x, slot.y, slot.x + 16, slot.y + 16, -2130706433, -2130706433, 0);

        }
    }
}
