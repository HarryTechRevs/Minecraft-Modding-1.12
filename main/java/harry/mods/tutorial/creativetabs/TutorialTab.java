package harry.mods.tutorial.creativetabs;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class TutorialTab extends CreativeTabs
{
	public TutorialTab() 
	{
		super("tutorial");
	}

	@Override
	public ItemStack getTabIconItem() 
	{
		return new ItemStack(Items.APPLE);//ItemInit.COPPER_INGOT);
	}
}
