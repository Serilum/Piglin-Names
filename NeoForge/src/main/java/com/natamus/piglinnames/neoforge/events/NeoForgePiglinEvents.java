package com.natamus.piglinnames.neoforge.events;

import com.natamus.piglinnames.cmds.CommandPiglinnames;
import com.natamus.piglinnames.events.PiglinEvents;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.RegisterCommandsEvent;
import net.neoforged.neoforge.event.entity.EntityJoinLevelEvent;

@EventBusSubscriber
public class NeoForgePiglinEvents {
	@SubscribeEvent
	public static void onSpawn(EntityJoinLevelEvent e) {
		PiglinEvents.onSpawn(e.getLevel(), e.getEntity());
	}

	@SubscribeEvent
	public static void registerCommands(RegisterCommandsEvent e) {
		CommandPiglinnames.register(e.getDispatcher());
	}
}
