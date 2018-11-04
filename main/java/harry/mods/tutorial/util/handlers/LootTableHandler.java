package harry.mods.tutorial.util.handlers;

import harry.mods.tutorial.Reference;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.LootTableList;

public class LootTableHandler 
{
	public static final ResourceLocation CENTAUR = LootTableList.register(new ResourceLocation(Reference.MODID, "centaur"));
}
