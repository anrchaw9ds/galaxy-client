package com.galaxy;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.galaxy.gui.ClickGUI;
import com.galaxy.modules.CombatModule;
import com.galaxy.modules.AutomationModule;

public class GalaxyClientMod implements ClientModInitializer {
    public static final String MOD_ID = "galaxy-client";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
    
    private static ClickGUI clickGUI;
    private static CombatModule combatModule;
    private static AutomationModule automationModule;
    
    @Override
    public void onInitializeClient() {
        LOGGER.info("Initializing Galaxy Client...");
        
        // Initialize modules
        clickGUI = new ClickGUI();
        combatModule = new CombatModule();
        automationModule = new AutomationModule();
        
        // Register client tick event
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (client.player != null) {
                // Update modules on each tick
                if (combatModule.isEnabled()) {
                    combatModule.onTick(client);
                }
                if (automationModule.isEnabled()) {
                    automationModule.onTick(client);
                }
            }
        });
        
        LOGGER.info("Galaxy Client initialized successfully!");
    }
    
    public static ClickGUI getClickGUI() {
        return clickGUI;
    }
    
    public static CombatModule getCombatModule() {
        return combatModule;
    }
    
    public static AutomationModule getAutomationModule() {
        return automationModule;
    }
}
