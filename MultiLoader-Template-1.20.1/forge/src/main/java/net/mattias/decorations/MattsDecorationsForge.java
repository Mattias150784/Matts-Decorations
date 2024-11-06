package net.mattias.decorations;

import net.mattias.decorations.core.ModBlocks;
import net.mattias.decorations.core.ModCreativeModeTabs;
import net.mattias.decorations.core.ModItems;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Constants.MOD_ID)
public class MattsDecorationsForge {

    public MattsDecorationsForge() {


        MattsDecorations.init();
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        ModBlocks.register(bus);
        ModItems.register(bus);
        ModCreativeModeTabs.register(bus);

    }
}