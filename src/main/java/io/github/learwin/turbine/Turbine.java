package io.github.learwin.turbine;

import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;

@Mod("turbine")
public class Turbine {
    public Turbine(ModContainer container) {
        System.out.println(container.getModId() + " initialised!");
    }
}
