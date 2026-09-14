package net.ninho.ninhosawm.entity.nebula;

import net.minecraft.client.animation.KeyframeAnimation;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;

public class NebulaModel extends EntityModel<NebulaRenderState> {
    private final ModelPart body;
    private final ModelPart tail_base;
    private final ModelPart tail_mid;
    private final ModelPart tail_end;
    private final ModelPart torso;
    private final ModelPart neck;
    private final ModelPart head;
    private final ModelPart eyes;
    private final ModelPart left_ear;
    private final ModelPart right_ear;
    private final ModelPart left_arm;
    private final ModelPart right_arm;
    private final ModelPart left_leg;
    private final ModelPart right_leg;

    private final KeyframeAnimation walkingAnimation;
    private final KeyframeAnimation idlingAnimation;

    public NebulaModel(ModelPart root) {
        super(root);

        this.body = root.getChild("body");
        this.tail_base = this.body.getChild("tail_base");
        this.tail_mid = this.tail_base.getChild("tail_mid");
        this.tail_end = this.tail_mid.getChild("tail_end");
        this.torso = this.body.getChild("torso");
        this.neck = this.torso.getChild("neck");
        this.head = this.neck.getChild("head");
        this.eyes = this.head.getChild("eyes");
        this.left_ear = this.head.getChild("left_ear");
        this.right_ear = this.head.getChild("right_ear");
        this.left_arm = this.torso.getChild("left_arm");
        this.right_arm = this.torso.getChild("right_arm");
        this.left_leg = this.body.getChild("left_leg");
        this.right_leg = this.body.getChild("right_leg");

        this.walkingAnimation = NebulaAnimations.WALK.bake(root);
        this.idlingAnimation = NebulaAnimations.IDLE.bake(root);
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition body = partdefinition.addOrReplaceChild(
                "body",
                CubeListBuilder.create()
                        .texOffs(0, 0)
                        .addBox(
                                -3.0F, -3.0F, -3.0F,
                                6.0F, 6.0F, 6.0F,
                                new CubeDeformation(0.0F)
                        ),
                PartPose.offset(0.0F, 17.0F, 2.0F)
        );

        PartDefinition tail_base = body.addOrReplaceChild(
                "tail_base",
                CubeListBuilder.create()
                        .texOffs(0, 23)
                        .addBox(
                                -1.0F, -0.5F, -1.0F,
                                2.0F, 2.0F, 4.0F,
                                new CubeDeformation(-0.1F)
                        ),
                PartPose.offset(0.0F, -1.75F, 3.0F)
        );

        PartDefinition tail_mid = tail_base.addOrReplaceChild(
                "tail_mid",
                CubeListBuilder.create()
                        .texOffs(24, 0)
                        .addBox(
                                -1.0F, -0.5F, 0.0F,
                                2.0F, 2.0F, 3.0F,
                                new CubeDeformation(0.0F)
                        ),
                PartPose.offset(0.0F, 0.0F, 2.5F)
        );

        PartDefinition tail_end = tail_mid.addOrReplaceChild(
                "tail_end",
                CubeListBuilder.create()
                        .texOffs(28, 27)
                        .addBox(
                                -1.0F, -0.5F, 2.0F,
                                2.0F, 2.0F, 2.0F,
                                new CubeDeformation(0.0F)
                        )
                        .texOffs(24, 5)
                        .addBox(
                                -1.0F, -0.5F, -0.75F,
                                2.0F, 2.0F, 3.0F,
                                new CubeDeformation(0.05F)
                        ),
                PartPose.offset(0.0F, 0.0F, 3.25F)
        );

        PartDefinition torso = body.addOrReplaceChild(
                "torso",
                CubeListBuilder.create()
                        .texOffs(0, 12)
                        .addBox(
                                -3.0F, 0.0F, -4.75F,
                                6.0F, 6.0F, 5.0F,
                                new CubeDeformation(-0.1F)
                        ),
                PartPose.offset(0.0F, -3.0F, -2.75F)
        );

        PartDefinition neck = torso.addOrReplaceChild(
                "neck",
                CubeListBuilder.create(),
                PartPose.offset(0.0F, 3.0F, -4.0F)
        );

        PartDefinition cube_r1 = neck.addOrReplaceChild(
                "cube_r1",
                CubeListBuilder.create()
                        .texOffs(22, 12)
                        .addBox(
                                -2.0F, -2.0F, -1.25F,
                                4.0F, 4.0F, 4.0F,
                                new CubeDeformation(-0.2F)
                        ),
                PartPose.offsetAndRotation(
                        0.0F, -1.0F, -2.0F,
                        -0.1872F, 0.1841F, 0.7681F
                )
        );

        PartDefinition head = neck.addOrReplaceChild(
                "head",
                CubeListBuilder.create(),
                PartPose.offset(0.0F, -1.0F, -3.0F)
        );

        PartDefinition cube_r2 = head.addOrReplaceChild(
                "cube_r2",
                CubeListBuilder.create()
                        .texOffs(25, 10)
                        .mirror()
                        .addBox(
                                -1.5F, -0.5F, -2.75F,
                                1.0F, 1.0F, 1.0F,
                                new CubeDeformation(0.0F)
                        )
                        .mirror(false),
                PartPose.offsetAndRotation(
                        0.2071F, 0.0F, 0.0F,
                        0.0F, 0.0F, -0.7854F
                )
        );

        PartDefinition cube_r3 = head.addOrReplaceChild(
                "cube_r3",
                CubeListBuilder.create()
                        .texOffs(24, 10)
                        .addBox(
                                0.5F, -0.5F, -2.75F,
                                1.0F, 1.0F, 1.0F,
                                new CubeDeformation(-0.001F)
                        ),
                PartPose.offsetAndRotation(
                        -0.2071F, 0.0F, 0.0F,
                        0.0F, 0.0F, 0.7854F
                )
        );

        PartDefinition cube_r4 = head.addOrReplaceChild(
                "cube_r4",
                CubeListBuilder.create()
                        .texOffs(8, 29)
                        .addBox(
                                0.0F, -0.5F, -2.65F,
                                1.0F, 1.0F, 1.0F,
                                new CubeDeformation(0.0F)
                        ),
                PartPose.offsetAndRotation(
                        0.0F, 0.0F, 0.0F,
                        0.0F, 0.0F, 1.5708F
                )
        );

        PartDefinition cube_r5 = head.addOrReplaceChild(
                "cube_r5",
                CubeListBuilder.create()
                        .texOffs(0, 29)
                        .addBox(
                                0.5F, 0.5F, -2.75F,
                                2.0F, 2.0F, 2.0F,
                                new CubeDeformation(-0.4F)
                        ),
                PartPose.offsetAndRotation(
                        0.0F, -1.0F, -0.25F,
                        0.0F, 0.0F, 0.7854F
                )
        );

        PartDefinition cube_r6 = head.addOrReplaceChild(
                "cube_r6",
                CubeListBuilder.create()
                        .texOffs(22, 20)
                        .addBox(
                                -2.0F, -2.0F, -2.0F,
                                4.0F, 4.0F, 3.0F,
                                new CubeDeformation(0.0F)
                        ),
                PartPose.offsetAndRotation(
                        0.0F, 0.0F, 0.0F,
                        0.0F, 0.0F, 0.7854F
                )
        );

        PartDefinition eyes = head.addOrReplaceChild(
                "eyes",
                CubeListBuilder.create()
                        .texOffs(1, 41)
                        .addBox(
                                0.0F, -1.0F, -0.005F,
                                2.0F, 1.0F, 0.0F,
                                new CubeDeformation(-0.2F)
                        )
                        .texOffs(1, 41)
                        .mirror()
                        .addBox(
                                -2.5F, -1.0F, -0.005F,
                                2.0F, 1.0F, 0.0F,
                                new CubeDeformation(-0.2F)
                        )
                        .mirror(false),
                PartPose.offset(0.25F, 0.0F, -1.8F)
        );

        PartDefinition left_ear = head.addOrReplaceChild(
                "left_ear",
                CubeListBuilder.create(),
                PartPose.offset(-0.4068F, 0.4435F, -0.25F)
        );

        PartDefinition cube_r7 = left_ear.addOrReplaceChild(
                "cube_r7",
                CubeListBuilder.create()
                        .texOffs(32, 31)
                        .addBox(
                                -0.292F, -3.3706F, 0.25F,
                                1.0F, 3.0F, 1.0F,
                                new CubeDeformation(-0.05F)
                        ),
                PartPose.offsetAndRotation(
                        0.3523F, -0.4508F, 0.0F,
                        0.0F, 0.0F, 0.6109F
                )
        );

        PartDefinition cube_r8 = left_ear.addOrReplaceChild(
                "cube_r8",
                CubeListBuilder.create()
                        .texOffs(28, 31)
                        .addBox(
                                -1.4264F, -3.8754F, 0.0F,
                                1.0F, 3.0F, 1.0F,
                                new CubeDeformation(-0.05F)
                        ),
                PartPose.offsetAndRotation(
                        0.3523F, -0.4508F, 0.0F,
                        0.0F, 0.0F, 0.9163F
                )
        );

        PartDefinition cube_r9 = left_ear.addOrReplaceChild(
                "cube_r9",
                CubeListBuilder.create()
                        .texOffs(14, 31)
                        .addBox(
                                1.0544F, -3.9927F, 0.0F,
                                1.0F, 3.0F, 1.0F,
                                new CubeDeformation(-0.06F)
                        ),
                PartPose.offsetAndRotation(
                        0.0F, 0.0F, 0.0F,
                        0.0F, 0.0F, 0.3054F
                )
        );

        PartDefinition right_ear = head.addOrReplaceChild(
                "right_ear",
                CubeListBuilder.create(),
                PartPose.offset(0.4068F, 0.4435F, -0.25F)
        );

        PartDefinition cube_r10 = right_ear.addOrReplaceChild(
                "cube_r10",
                CubeListBuilder.create()
                        .texOffs(32, 31)
                        .mirror()
                        .addBox(
                                -0.708F, -3.3706F, 0.25F,
                                1.0F, 3.0F, 1.0F,
                                new CubeDeformation(-0.05F)
                        )
                        .mirror(false),
                PartPose.offsetAndRotation(
                        -0.3523F, -0.4508F, 0.0F,
                        0.0F, 0.0F, -0.6109F
                )
        );

        PartDefinition cube_r11 = right_ear.addOrReplaceChild(
                "cube_r11",
                CubeListBuilder.create()
                        .texOffs(28, 31)
                        .mirror()
                        .addBox(
                                0.4264F, -3.8754F, 0.0F,
                                1.0F, 3.0F, 1.0F,
                                new CubeDeformation(-0.05F)
                        )
                        .mirror(false),
                PartPose.offsetAndRotation(
                        -0.3523F, -0.4508F, 0.0F,
                        0.0F, 0.0F, -0.9163F
                )
        );

        PartDefinition cube_r12 = right_ear.addOrReplaceChild(
                "cube_r12",
                CubeListBuilder.create()
                        .texOffs(14, 31)
                        .mirror()
                        .addBox(
                                -2.0544F, -3.9927F, 0.0F,
                                1.0F, 3.0F, 1.0F,
                                new CubeDeformation(-0.06F)
                        )
                        .mirror(false),
                PartPose.offsetAndRotation(
                        0.0F, 0.0F, 0.0F,
                        0.0F, 0.0F, -0.3054F
                )
        );

        PartDefinition left_arm = torso.addOrReplaceChild(
                "left_arm",
                CubeListBuilder.create()
                        .texOffs(20, 27)
                        .addBox(
                                -1.0F, 0.0F, -1.0F,
                                2.0F, 5.0F, 2.0F,
                                new CubeDeformation(0.0F)
                        ),
                PartPose.offset(1.75F, 5.0F, -3.25F)
        );

        PartDefinition right_arm = torso.addOrReplaceChild(
                "right_arm",
                CubeListBuilder.create()
                        .texOffs(20, 27)
                        .mirror()
                        .addBox(
                                -1.0F, 0.0F, -1.0F,
                                2.0F, 5.0F, 2.0F,
                                new CubeDeformation(0.0F)
                        )
                        .mirror(false),
                PartPose.offset(-1.75F, 5.0F, -3.25F)
        );

        PartDefinition left_leg = body.addOrReplaceChild(
                "left_leg",
                CubeListBuilder.create()
                        .texOffs(8, 31)
                        .addBox(
                                -1.0F, -1.0F, -2.0F,
                                2.0F, 3.0F, 1.0F,
                                new CubeDeformation(0.0F)
                        )
                        .texOffs(12, 23)
                        .addBox(
                                -1.0F, -1.0F, -1.0F,
                                2.0F, 6.0F, 2.0F,
                                new CubeDeformation(0.0F)
                        ),
                PartPose.offset(1.75F, 2.0F, 1.5F)
        );

        PartDefinition right_leg = body.addOrReplaceChild(
                "right_leg",
                CubeListBuilder.create()
                        .texOffs(8, 31)
                        .mirror()
                        .addBox(
                                -1.0F, -1.0F, -2.0F,
                                2.0F, 3.0F, 1.0F,
                                new CubeDeformation(0.0F)
                        )
                        .mirror(false)
                        .texOffs(12, 23)
                        .mirror()
                        .addBox(
                                -1.0F, -1.0F, -1.0F,
                                2.0F, 6.0F, 2.0F,
                                new CubeDeformation(0.0F)
                        )
                        .mirror(false),
                PartPose.offset(-1.75F, 2.0F, 1.5F)
        );

        return LayerDefinition.create(meshdefinition, 48, 48);
    }

    @Override
    public void setupAnim(NebulaRenderState state) {
        this.root().getAllParts().forEach(ModelPart::resetPose);

        this.applyHeadRotation(state.yRot, state.xRot);

        this.walkingAnimation.applyWalk(
                state.walkAnimationPos,
                state.walkAnimationSpeed,
                2f,
                2.5f
        );

        this.idlingAnimation.apply(
                state.idleAnimationState,
                state.ageInTicks,
                1f
        );
    }

    private void applyHeadRotation(float headYaw, float headPitch) {
        headYaw = Mth.clamp(headYaw, -30f, 30f);
        headPitch = Mth.clamp(headPitch, -25f, 45f);

        this.head.yRot = headYaw * ((float) Math.PI / 180f);
        this.head.xRot = headPitch * ((float) Math.PI / 180f);
    }
}