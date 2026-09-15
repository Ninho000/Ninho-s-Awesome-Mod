package net.ninho.ninhosawm.entity.nebula;

import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.ninho.ninhosawm.entity.ai.Sittable;
import net.ninho.ninhosawm.entity.ai.goal.SitGoal;
import org.jspecify.annotations.Nullable;

public class NebulaEntity extends Animal implements Sittable {
    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;
    private int idleAnimationDuration = 3;

    public NebulaEntity(EntityType<? extends PathfinderMob> type, Level level) {
        super((EntityType<? extends Animal>) type, level);
    }
    //GOALS
    @Override
    protected void registerGoals() {
        goalSelector.addGoal(0, new FloatGoal(this));
        goalSelector.addGoal(1, new PanicGoal(this, 2d));
        goalSelector.addGoal(1, new WaterAvoidingRandomStrollGoal(this, 1d));
        goalSelector.addGoal(1, new AvoidEntityGoal<>(this, Monster.class,
                8.0F, 1.0D, 1.5D));
        goalSelector.addGoal(2, new LookAtPlayerGoal(this, Player.class, 7f));
        goalSelector.addGoal(3, new RandomLookAroundGoal(this));
        goalSelector.addGoal(4, new SitGoal<>(this, 100));
    }

    // ANIMATIONS
    private void setupAnimationStates() {
        if(this.idleAnimationTimeout <= 0) {
            this.idleAnimationTimeout = idleAnimationDuration*20;
            this.idleAnimationState.start(this.tickCount);
        } else {
            --this.idleAnimationTimeout;
        }
    }
    @Override
    public boolean isSitting() {
        return this.entityData.get(SITTING);
    }
    @Override
    public void setSitting(boolean sitting) {
        this.entityData.set(SITTING, sitting);
    }
    private static final EntityDataAccessor<Boolean> SITTING =
            SynchedEntityData.defineId(NebulaEntity.class, EntityDataSerializers.BOOLEAN);
    @Override
    public void tick() {
        super.tick();

        if(this.level().isClientSide()) {
            this.setupAnimationStates();
        }
    }

    //Animal Components
    @Override
    public boolean isFood(ItemStack itemStack) {
        return false;
    }
    @Override
    public @Nullable AgeableMob getBreedOffspring(ServerLevel serverLevel, AgeableMob ageableMob) {
        return null;
    }

    //ATTRIBUTES
    public static AttributeSupplier.Builder createAttributes() {
        return PathfinderMob.createLivingAttributes()
                .add(Attributes.MAX_HEALTH, 10d)
                .add(Attributes.MOVEMENT_SPEED, 0.25D)
                .add(Attributes.TEMPT_RANGE, 16d)
                .add(Attributes.FOLLOW_RANGE, 24D);
    }
}