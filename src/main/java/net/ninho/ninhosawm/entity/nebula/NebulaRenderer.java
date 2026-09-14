package net.ninho.ninhosawm.entity.nebula;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.Identifier;
import net.ninho.ninhosawm.NinhosAwesomeMod;
import net.ninho.ninhosawm.entity.ModModelLayerLocations;

public class NebulaRenderer extends MobRenderer<NebulaEntity, NebulaRenderState, NebulaModel> {
    public NebulaRenderer(EntityRendererProvider.Context context) {
        super(context, new NebulaModel(context.bakeLayer(ModModelLayerLocations.NEBULA)), 0.65f);
    }

    @Override
    public Identifier getTextureLocation(NebulaRenderState state) {
        return Identifier.fromNamespaceAndPath(NinhosAwesomeMod.MOD_ID, "textures/entity/nebula/nebula.png");
    }

    @Override
    public NebulaRenderState createRenderState() {
        return new NebulaRenderState();
    }

    @Override
    public void extractRenderState(NebulaEntity entity, NebulaRenderState state, float partialTicks) {
        super.extractRenderState(entity, state, partialTicks);

        state.idleAnimationState.copyFrom(entity.idleAnimationState);
    }
}