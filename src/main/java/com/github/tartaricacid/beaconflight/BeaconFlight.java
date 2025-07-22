package com.github.tartaricacid.beaconflight;

import com.github.tartaricacid.beaconflight.effect.FlyEffect;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.effect.MobEffect;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

@Mod(BeaconFlight.MOD_ID)
public class BeaconFlight {
    public static final String MOD_ID = "beaconflight";

    private static final DeferredRegister<MobEffect> MOB_EFFECTS = DeferredRegister.create(BuiltInRegistries.MOB_EFFECT, MOD_ID);
    public static final DeferredHolder<MobEffect, FlyEffect> FLY_EFFECT = MOB_EFFECTS.register("fly", FlyEffect::new);

    public BeaconFlight(IEventBus modEventBus) {
        MOB_EFFECTS.register(modEventBus);
    }
}
