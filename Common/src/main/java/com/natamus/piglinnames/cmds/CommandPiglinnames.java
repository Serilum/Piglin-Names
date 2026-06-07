package com.natamus.piglinnames.cmds;
import com.natamus.piglinnames.util.Reference;

import com.mojang.brigadier.CommandDispatcher;
import com.natamus.collective.functions.MessageFunctions;
import com.natamus.piglinnames.util.Util;
import net.minecraft.ChatFormatting;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.server.permissions.Permissions;

public class CommandPiglinnames {
	public static void register(CommandDispatcher<CommandSourceStack> dispatcher) {
		dispatcher.register(Commands.literal("piglinnames")
			.requires((iCommandSender) -> iCommandSender.permissions().hasPermission(Permissions.COMMANDS_ADMIN))
			.executes((command) -> {
				sendUsage(command.getSource());
				return 1;
			})
			.then(Commands.literal("unname")
			.executes((command) -> {
				CommandSourceStack source = command.getSource();

				int count = Util.unnameLoadedPiglins(source.getLevel());

				MessageFunctions.sendTranslatableMessage(source, "collective.piglinnames.message.namesloadedpiglins", ChatFormatting.DARK_GREEN, count);
				return 1;
			}))
			.then(Commands.literal("name")
			.executes((command) -> {
				CommandSourceStack source = command.getSource();

				int count = Util.nameLoadedPiglins(source.getLevel());

				MessageFunctions.sendTranslatableMessage(source, "collective.piglinnames.message.loadedpiglinswithout", ChatFormatting.DARK_GREEN, count);
				return 1;
			}))
			.then(Commands.literal("rename")
			.executes((command) -> {
				CommandSourceStack source = command.getSource();

				int count = Util.renameLoadedPiglins(source.getLevel());

				MessageFunctions.sendTranslatableMessage(source, "collective.piglinnames.message.loadedpiglinsrenamed", ChatFormatting.DARK_GREEN, count);
				return 1;
			}))
		);
	}

	public static void sendUsage(CommandSourceStack source) {
		MessageFunctions.sendTranslatableMessage(source, "collective.shared.message.commandsusage", true, ChatFormatting.DARK_GREEN, Reference.NAME);
		MessageFunctions.sendMessage(source, " /piglinnames unname", ChatFormatting.DARK_GREEN);
		MessageFunctions.sendTranslatableMessage(source, "  ", "collective.piglinnames.message.removesnamesloaded", ChatFormatting.DARK_GRAY);
		MessageFunctions.sendMessage(source, " /piglinnames name", ChatFormatting.DARK_GREEN);
		MessageFunctions.sendTranslatableMessage(source, "  ", "collective.piglinnames.message.givesunnamedloaded", ChatFormatting.DARK_GRAY);
		MessageFunctions.sendMessage(source, " /piglinnames rename", ChatFormatting.DARK_GREEN);
		MessageFunctions.sendTranslatableMessage(source, "  ", "collective.piglinnames.message.givesloadedpiglins", ChatFormatting.DARK_GRAY);
	}
}