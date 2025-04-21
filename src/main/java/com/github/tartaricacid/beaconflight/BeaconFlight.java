package com.github.tartaricacid.beaconflight;

import com.github.tartaricacid.beaconflight.effect.FlyEffect;
import net.minecraft.world.effect.MobEffect;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@Mod(BeaconFlight.MOD_ID)
public class BeaconFlight {
    public static final String MOD_ID = "beaconflight";

    private static final DeferredRegister<MobEffect> MOB_EFFECTS = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, MOD_ID);
    public static final RegistryObject<MobEffect> FLY_EFFECT = MOB_EFFECTS.register("fly", FlyEffect::new);

    public BeaconFlight() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        MOB_EFFECTS.register(modEventBus);
    }
}
