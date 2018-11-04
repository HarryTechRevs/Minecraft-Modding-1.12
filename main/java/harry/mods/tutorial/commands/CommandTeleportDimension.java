package harry.mods.tutorial.commands;

import java.util.Collections;
import java.util.List;

import com.google.common.collect.Lists;

import harry.mods.tutorial.Reference;
import harry.mods.tutorial.commands.util.CustomTeleporter;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;

public class CommandTeleportDimension extends CommandBase
{
	private final List<String> aliases = Lists.newArrayList(Reference.MODID, "TP", "tp", "tpdim", "tpdimension", "teleport");
	
	@Override
	public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException 
	{
		if(args.length < 1) return;
		
		String s = args[0];
		int dimension;
		
		try
		{
			dimension = Integer.parseInt(s);
		} catch(NumberFormatException e)
		{
			sender.sendMessage(new TextComponentString(TextFormatting.RED + "Dimension not found"));
			return;
		}
		
		if(sender instanceof EntityPlayer)
		{
			CustomTeleporter.teleportToDimension((EntityPlayer)sender, dimension, 0, 100, 0);
		}
	}
	
	@Override
	public String getName() 
	{
		return "tpdimension";
	}
	
	@Override
	public String getUsage(ICommandSender sender)
	{
		return "tpdimension <id>";
	}
	
	@Override
	public List<String> getAliases() 
	{
		return aliases;
	}
	
	@Override
	public boolean checkPermission(MinecraftServer server, ICommandSender sender) 
	{
		return true;
	}
	
	@Override
	public List<String> getTabCompletions(MinecraftServer server, ICommandSender sender, String[] args, BlockPos targetPos) 
	{
		return Collections.emptyList();
	}
}
