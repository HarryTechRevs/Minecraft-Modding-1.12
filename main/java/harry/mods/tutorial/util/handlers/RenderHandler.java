package harry.mods.tutorial.util.handlers;

import harry.mods.tutorial.entity.EntityCentaur;
import harry.mods.tutorial.init.BlockInit;
import harry.mods.tutorial.rendering.RenderCentaur;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.StateMapperBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class RenderHandler 
{
	public static void registerEntityRenders()
	{
		RenderingRegistry.registerEntityRenderingHandler(EntityCentaur.class, new IRenderFactory<EntityCentaur>()
		{
			@Override
			public Render<? super EntityCentaur> createRenderFor(RenderManager manager) 
			{
				return new RenderCentaur(manager);
			}
		});
	}
	
	public static void registerCustomMeshesAndStates()
	{
		ModelLoader.setCustomMeshDefinition(Item.getItemFromBlock(BlockInit.MOLTEN_COPPER_BLOCK), new ItemMeshDefinition() 
		{	
			@Override
			public ModelResourceLocation getModelLocation(ItemStack stack) 
			{
				return new ModelResourceLocation("tutorial:molten_copper", "fluid");
			}
		});
		
		ModelLoader.setCustomStateMapper(BlockInit.MOLTEN_COPPER_BLOCK, new StateMapperBase() 
		{	
			@Override
			protected ModelResourceLocation getModelResourceLocation(IBlockState state)
			{
				return new ModelResourceLocation("tutorial:molten_copper", "fluid");
			}
		});
	}
}
