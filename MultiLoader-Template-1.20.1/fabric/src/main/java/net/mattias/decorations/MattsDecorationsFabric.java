package net.mattias.decorations;

import net.fabricmc.api.ModInitializer;

public class MattsDecorationsFabric implements ModInitializer {


    @Override
    public void onInitialize() {
        Constants.register();
        Constants.LOG.info("Hello Fabric world!");
    }
}
