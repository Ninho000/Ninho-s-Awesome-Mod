package net.ninho.ninhosawm.entity.ai.goal;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.Goal;
import net.ninho.ninhosawm.entity.ai.Sittable;

public class SitGoal<T extends Mob & Sittable> extends Goal {

    private final T mob;
    private final int sitDuration;

    private int sitTime;

    public SitGoal(T mob, int sitDuration) {
        this.mob = mob;
        this.sitDuration = sitDuration;
    }

    @Override
    public boolean canUse() {
        return !this.mob.isSitting()
                && this.mob.getRandom().nextInt(100) == 0;
    }

    @Override
    public boolean canContinueToUse() {
        return this.sitTime > 0;
    }

    @Override
    public void start() {
        this.sitTime = this.sitDuration;
        this.mob.setSitting(true);
    }

    @Override
    public void tick() {
        this.sitTime--;
    }

    @Override
    public void stop() {
        this.mob.setSitting(false);
    }
}