package com.galaxy.modules;

import net.minecraft.client.MinecraftClient;

public class CombatModule extends Module {
    
    private float reachDistance = 3.0f;
    private boolean autoHit = false;
    private boolean criticals = false;
    
    public CombatModule() {
        super("Combat", "Advanced combat enhancements", "◈");
    }
    
    @Override
    public void onTick(MinecraftClient client) {
        if (!this.enabled || client.player == null) return;
        
        if (autoHit && client.targetedEntity != null) {
            client.interactionManager.attackEntity(client.player, client.targetedEntity);
        }
        
        if (criticals && client.player.isOnGround()) {
            client.player.jump();
        }
    }
    
    public void setReachDistance(float distance) {
        this.reachDistance = distance;
    }
    
    public void setAutoHit(boolean enabled) {
        this.autoHit = enabled;
    }
    
    public void setCriticals(boolean enabled) {
        this.criticals = enabled;
    }
}
