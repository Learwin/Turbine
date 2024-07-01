package io.github.learwin.turbine.mixin.server;

import io.github.learwin.turbine.api.slot.ISlotRender;
import net.minecraft.world.inventory.Slot;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(Slot.class)
public class MixinSlot implements ISlotRender {
}
