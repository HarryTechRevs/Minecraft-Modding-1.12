package harry.mods.tutorial.rendering.models.entities;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class ModelCentaur extends ModelBase 
{
    public ModelRenderer CowBody;
    public ModelRenderer Udders;
    public ModelRenderer RearLeftLeg;
    public ModelRenderer FrontLeftLeg;
    public ModelRenderer RearRightLeg;
    public ModelRenderer FrontRightLeg;
    public ModelRenderer VillagerHead;
    public ModelRenderer VillagerCoat;
    public ModelRenderer VillagerMiddleArm;
    public ModelRenderer VillagerRightArm;
    public ModelRenderer VillagerLeftArm;
    public ModelRenderer VillagerChest;
    public ModelRenderer VillagerNose;

    public ModelCentaur() 
    {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.FrontLeftLeg = new ModelRenderer(this, 0, 16);
        this.FrontLeftLeg.setRotationPoint(4.0F, 12.0F, -6.0F);
        this.FrontLeftLeg.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
        this.VillagerHead = new ModelRenderer(this, 0, 0);
        this.VillagerHead.setRotationPoint(0.0F, -15.0F, -3.0F);
        this.VillagerHead.addBox(-4.0F, -10.0F, -4.0F, 8, 10, 8, 0.0F);
        this.CowBody = new ModelRenderer(this, 18, 4);
        this.CowBody.setRotationPoint(0.0F, 5.0F, 2.0F);
        this.CowBody.addBox(-6.0F, -10.0F, -7.0F, 12, 18, 10, 0.0F);
        this.setRotateAngle(CowBody, 1.5707963267948966F, 0.0F, 0.0F);
        this.FrontRightLeg = new ModelRenderer(this, 0, 16);
        this.FrontRightLeg.setRotationPoint(-4.0F, 12.0F, -6.0F);
        this.FrontRightLeg.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
        this.VillagerMiddleArm = new ModelRenderer(this, 40, 38);
        this.VillagerMiddleArm.setRotationPoint(0.0F, -12.0F, -4.0F);
        this.VillagerMiddleArm.addBox(-4.0F, 2.0F, -2.0F, 8, 4, 4, 0.0F);
        this.setRotateAngle(VillagerMiddleArm, -0.7499679795819634F, 0.0F, 0.0F);
        this.RearLeftLeg = new ModelRenderer(this, 0, 16);
        this.RearLeftLeg.setRotationPoint(4.0F, 12.0F, 7.0F);
        this.RearLeftLeg.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
        this.VillagerCoat = new ModelRenderer(this, 0, 38);
        this.VillagerCoat.setRotationPoint(0.0F, -15.0F, -3.0F);
        this.VillagerCoat.addBox(-4.0F, 0.0F, -3.0F, 8, 18, 6, 0.5F);
        this.Udders = new ModelRenderer(this, 52, 0);
        this.Udders.setRotationPoint(0.0F, 5.0F, 2.0F);
        this.Udders.addBox(-2.0F, 2.0F, -8.0F, 4, 6, 1, 0.0F);
        this.setRotateAngle(Udders, 1.5707963267948966F, 0.0F, 0.0F);
        this.VillagerNose = new ModelRenderer(this, 24, 0);
        this.VillagerNose.setRotationPoint(0.0F, -2.0F, 0.0F);
        this.VillagerNose.addBox(-1.0F, -1.0F, -6.0F, 2, 4, 2, 0.0F);
        this.VillagerRightArm = new ModelRenderer(this, 44, 22);
        this.VillagerRightArm.setRotationPoint(0.0F, -12.0F, -4.0F);
        this.VillagerRightArm.addBox(-8.0F, -2.0F, -2.0F, 4, 8, 4, 0.0F);
        this.setRotateAngle(VillagerRightArm, -0.7499679795819634F, 0.0F, 0.0F);
        this.VillagerLeftArm = new ModelRenderer(this, 44, 22);
        this.VillagerLeftArm.setRotationPoint(0.0F, -12.0F, -4.0F);
        this.VillagerLeftArm.addBox(4.0F, -2.0F, -2.0F, 4, 8, 4, 0.0F);
        this.setRotateAngle(VillagerLeftArm, -0.7499679795819634F, 0.0F, 0.0F);
        this.VillagerChest = new ModelRenderer(this, 16, 20);
        this.VillagerChest.setRotationPoint(0.0F, -12.0F, -3.0F);
        this.VillagerChest.addBox(-4.0F, 0.0F, -3.0F, 8, 12, 6, 0.0F);
        this.RearRightLeg = new ModelRenderer(this, 0, 16);
        this.RearRightLeg.setRotationPoint(-4.0F, 12.0F, 7.0F);
        this.RearRightLeg.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
        this.VillagerHead.addChild(this.VillagerNose);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) 
    { 
        this.FrontLeftLeg.render(f5);
        this.VillagerHead.render(f5);
        this.CowBody.render(f5);
        this.FrontRightLeg.render(f5);
        this.VillagerMiddleArm.render(f5);
        this.RearLeftLeg.render(f5);
        this.VillagerCoat.render(f5);
        this.Udders.render(f5);
        this.VillagerRightArm.render(f5);
        this.VillagerLeftArm.render(f5);
        this.VillagerChest.render(f5);
        this.RearRightLeg.render(f5);
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) 
    {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
    
    @Override
    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) 
    {
    	this.FrontLeftLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
    	this.RearLeftLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
    	this.FrontRightLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
    	this.RearRightLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
    	
    	this.VillagerHead.rotateAngleY = netHeadYaw * 0.017453292F;
    	this.VillagerHead.rotateAngleX = headPitch * 0.017453292F;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
