package io.github.learwin.turbine.mixin.client;

import io.github.learwin.turbine.api.slot.ISlotContentRender;
import io.github.learwin.turbine.api.slot.ISlotHighlightRender;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import javax.annotation.Nullable;

@Mixin(AbstractContainerScreen.class)
public abstract class MixinAbstractContainerScreen extends Screen {

    @Shadow
    protected int imageWidth;

    protected MixinAbstractContainerScreen(Component title) {
        super(title);
    }

    @Inject(
            at = @At("HEAD"),
            method = "renderSlotHighlight(Lnet/minecraft/client/gui/GuiGraphics;Lnet/minecraft/world/inventory/Slot;IIF)V",
            cancellable = true
    )
    protected void renderSlotHighlight(GuiGraphics guiGraphics, Slot slot, int mouseX, int mouseY, float partialTick, CallbackInfo callbackInfo) {
        if (slot instanceof ISlotHighlightRender slotRender) {
            slotRender.renderSlot(guiGraphics, slot, mouseX, mouseY, partialTick);
            callbackInfo.cancel();
        }
    }

    @Inject(
            at = @At("HEAD"),
            method = "renderSlotContents(Lnet/minecraft/client/gui/GuiGraphics;Lnet/minecraft/world/item/ItemStack;Lnet/minecraft/world/inventory/Slot;Ljava/lang/String;)V",
            cancellable = true
    )
    protected void renderSlotContents(GuiGraphics guiGraphics, ItemStack itemstack, Slot slot, String countString, CallbackInfo callbackInfo) {
        if (slot instanceof ISlotContentRender slotRender) {
            slotRender.renderSlotContents(guiGraphics, itemstack, slot, font, imageWidth, countString);
            callbackInfo.cancel();
        }
    }
}
