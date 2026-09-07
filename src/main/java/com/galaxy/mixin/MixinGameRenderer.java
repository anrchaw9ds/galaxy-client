package com.galaxy.mixin;

import net.minecraft.client.render.GameRenderer;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(GameRenderer.class)
public class MixinGameRenderer {
    // ESP rendering will be added here
}
