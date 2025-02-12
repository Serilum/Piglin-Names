package com.natamus.piglinnames.forge.events;

import com.natamus.piglinnames.cmds.CommandPiglinnames;
import com.natamus.piglinnames.events.PiglinEvents;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class ForgePiglinEvents {
	@SubscribeEvent
	public static void onSpawn(EntityJoinLevelEvent e) {
		PiglinEvents.onSpawn(e.getLevel(), e.getEntity());
	}

    @SubscribeEvent
    public static void registerCommands(RegisterCommandsEvent e) {
    	CommandPiglinnames.register(e.getDispatcher());
    }
}
