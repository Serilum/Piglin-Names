package com.serilum.piglinnames.forge.events;

import com.serilum.piglinnames.cmds.CommandPiglinnames;
import com.serilum.piglinnames.events.PiglinEvents;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.eventbus.api.bus.BusGroup;
import net.minecraftforge.eventbus.api.listener.SubscribeEvent;

import java.lang.invoke.MethodHandles;

public class ForgePiglinEvents {
	public static void registerEventsInBus() {
		BusGroup.DEFAULT.register(MethodHandles.lookup(), ForgePiglinEvents.class);
	}

	@SubscribeEvent
	public static void onSpawn(EntityJoinLevelEvent e) {
		PiglinEvents.onSpawn(e.getLevel(), e.getEntity());
	}

	@SubscribeEvent
	public static void registerCommands(RegisterCommandsEvent e) {
		CommandPiglinnames.register(e.getDispatcher());
	}
}
