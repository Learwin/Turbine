package io.github.learwin.examplemod;

import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;

@Mod("examplemod")
public class ExampleMod {
    public ExampleMod(ModContainer container) {
        System.out.println(container.getModId() + " initialised!");
    }
}
