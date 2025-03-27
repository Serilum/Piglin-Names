package com.natamus.piglinnames.cmds;

import com.mojang.brigadier.CommandDispatcher;
import com.natamus.collective.functions.MessageFunctions;
import com.natamus.piglinnames.util.Util;
import net.minecraft.ChatFormatting;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;

public class CommandPiglinnames {
	public static void register(CommandDispatcher<CommandSourceStack> dispatcher) {
		dispatcher.register(Commands.literal("piglinnames")
			.requires((iCommandSender) -> iCommandSender.hasPermission(2))
			.executes((command) -> {
				sendUsage(command.getSource());
				return 1;
			})
			.then(Commands.literal("unname")
			.executes((command) -> {
				CommandSourceStack source = command.getSource();

				int count = Util.unnameLoadedPiglins(source.getLevel());

				MessageFunctions.sendMessage(source, "The names of " + count + " loaded piglins have been removed.", ChatFormatting.DARK_GREEN);
				return 1;
			}))
			.then(Commands.literal("name")
			.executes((command) -> {
				CommandSourceStack source = command.getSource();

				int count = Util.nameLoadedPiglins(source.getLevel());

				MessageFunctions.sendMessage(source, count + " loaded piglins without a name have been named.", ChatFormatting.DARK_GREEN);
				return 1;
			}))
			.then(Commands.literal("rename")
			.executes((command) -> {
				CommandSourceStack source = command.getSource();

				int count = Util.renameLoadedPiglins(source.getLevel());

				MessageFunctions.sendMessage(source, count + " loaded piglins have been renamed.", ChatFormatting.DARK_GREEN);
				return 1;
			}))
		);
	}

	public static void sendUsage(CommandSourceStack source) {
		MessageFunctions.sendMessage(source, "--- Piglin Names Commands Usage ---", ChatFormatting.DARK_GREEN, true);
		MessageFunctions.sendMessage(source, " /piglinnames unname", ChatFormatting.DARK_GREEN);
		MessageFunctions.sendMessage(source, "  Removes the names of all loaded piglins.", ChatFormatting.DARK_GRAY);
		MessageFunctions.sendMessage(source, " /piglinnames name", ChatFormatting.DARK_GREEN);
		MessageFunctions.sendMessage(source, "  Gives all unnamed loaded piglins a name.", ChatFormatting.DARK_GRAY);
		MessageFunctions.sendMessage(source, " /piglinnames rename", ChatFormatting.DARK_GREEN);
		MessageFunctions.sendMessage(source, "  Gives all loaded piglins a new random name.", ChatFormatting.DARK_GRAY);
	}
}