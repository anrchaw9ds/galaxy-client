package com.galaxy.gui;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.Text;

public class ClickGUI extends Screen {
    
    private boolean showGUI = false;
    
    public ClickGUI() {
        super(Text.literal("Galaxy ClickGUI"));
    }
    
    @Override
    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        this.renderBackground(matrices);
        
        // Render GUI background
        fill(matrices, 20, 20, this.width - 20, this.height - 20, 0x88000000);
        
        // Render title
        drawCenteredText(matrices, this.textRenderer, Text.literal("GALAXY CLIENT"), this.width / 2, 40, 0xA45CFF);
        
        // Render modules
        drawTextWithShadow(matrices, this.textRenderer, Text.literal("✦ Combat"), 40, 100, 0x55BAFF);
        drawTextWithShadow(matrices, this.textRenderer, Text.literal("◈ Automation"), 40, 130, 0x55BAFF);
        drawTextWithShadow(matrices, this.textRenderer, Text.literal("⬡ ESP"), 40, 160, 0x55BAFF);
        
        super.render(matrices, mouseX, mouseY, delta);
    }
    
    @Override
    public boolean shouldCloseOnEsc() {
        return true;
    }
    
    @Override
    public boolean isPauseScreen() {
        return false;
    }
    
    public void toggle() {
        showGUI = !showGUI;
    }
    
    public boolean isVisible() {
        return showGUI;
    }
}
