package com.github.tartaricacid.beaconflight.mixin;

import com.github.tartaricacid.beaconflight.BeaconFlight;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BeaconBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

@Mixin(BeaconBlockEntity.class)
public abstract class BeaconBlockEntityMixin extends BlockEntity {
    public BeaconBlockEntityMixin(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }

    @Inject(method = "applyEffects", at = @At("HEAD"))
    private static void addFlyingEffect(Level level, BlockPos pos, int beaconLevel, Holder<MobEffect> primaryEffect, Holder<MobEffect> secondaryEffect, CallbackInfo ci) {
        if (!level.isClientSide) {
            double range = beaconLevel * 10 + 10;
            int time = (9 + beaconLevel * 2) * 20;
            AABB aabb = (new AABB(pos)).inflate(range).expandTowards(0, level.getHeight(), 0);
            List<Player> list = level.getEntitiesOfClass(Player.class, aabb);
            for (Player player : list) {
                player.addEffect(new MobEffectInstance(BeaconFlight.FLY_EFFECT, time, 0, true, true));
            }
        }
    }
}
