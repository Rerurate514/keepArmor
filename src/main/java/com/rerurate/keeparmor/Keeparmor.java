package com.rerurate.keeparmor;

import com.mojang.logging.LogUtils;
import com.rerurate.keeparmor.handler.PlayerDeathHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(Keeparmor.MODID)
public class Keeparmor {
    public static final String MODID = "keeparmor";
    public static final Logger LOGGER = LogUtils.getLogger();

    public Keeparmor() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
    }

    private void setup(final FMLCommonSetupEvent event) {
        MinecraftForge.EVENT_BUS.register(new PlayerDeathHandler());
        LOGGER.info("[keeparmor] Mod initialized - Hotbar and Armor will be preserved on death!");
    }
}