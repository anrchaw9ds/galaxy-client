package com.galaxy.modules;

import net.minecraft.client.MinecraftClient;

public abstract class Module {
    protected String name;
    protected String description;
    protected String icon;
    protected boolean enabled = false;
    
    public Module(String name, String description, String icon) {
        this.name = name;
        this.description = description;
        this.icon = icon;
    }
    
    public abstract void onTick(MinecraftClient client);
    
    public void toggle() {
        this.enabled = !this.enabled;
    }
    
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
    
    public boolean isEnabled() {
        return this.enabled;
    }
    
    public String getName() {
        return name;
    }
    
    public String getDescription() {
        return description;
    }
    
    public String getIcon() {
        return icon;
    }
}
