package io.github.learwin.turbine.mixin.client;

import io.github.learwin.turbine.api.slot.ISlotRender;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.world.inventory.Slot;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(AbstractContainerScreen.class)
public abstract class MixinAbstractContainerScreen {

    @Inject(
            at = @At("HEAD"),
            method = "Lnet/minecraft/client/gui/screens/inventory/AbstractContainerScreen;renderSlotHighlight(Lnet/minecraft/client/gui/GuiGraphics;Lnet/minecraft/world/inventory/Slot;IIF)V",
            cancellable = true
    )
    protected void renderSlotHighlight(GuiGraphics guiGraphics, Slot slot, int mouseX, int mouseY, float partialTick, CallbackInfo info) {
        if (slot instanceof ISlotRender slotRender) {
            slotRender.renderSlot(guiGraphics, slot, mouseX, mouseY, partialTick);
            info.cancel();
        }
    }
}
