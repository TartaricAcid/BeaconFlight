package com.github.tartaricacid.beaconflight.event;

import com.github.tartaricacid.beaconflight.BeaconFlight;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.LivingEntity;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.MobEffectEvent;

@EventBusSubscriber(modid = BeaconFlight.MOD_ID)
public class MobEffectRemoveEvent {
    @SubscribeEvent
    public static void onMobEffectEvent(MobEffectEvent.Remove event) {
        LivingEntity entity = event.getEntity();
        if (entity instanceof ServerPlayer player && event.getEffect().is(BeaconFlight.FLY_EFFECT)) {
            if (!player.isCreative() && !player.isSpectator()) {
                player.getAbilities().mayfly = false;
                player.getAbilities().flying = false;
                player.onUpdateAbilities();
            }
        }
    }

    @SubscribeEvent
    public static void onMobEffectEvent(MobEffectEvent.Expired event) {
        LivingEntity entity = event.getEntity();
        if (entity instanceof ServerPlayer player && event.getEffectInstance().is(BeaconFlight.FLY_EFFECT)) {
            if (!player.isCreative() && !player.isSpectator()) {
                player.getAbilities().mayfly = false;
                player.getAbilities().flying = false;
                player.onUpdateAbilities();
            }
        }
    }
}
