package com.natamus.piglinnames.forge.events;

import com.natamus.piglinnames.cmds.CommandPiglinnames;
import com.natamus.piglinnames.events.PiglinEvents;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber
public class ForgePiglinEvents {
	@SubscribeEvent
	public void onSpawn(EntityJoinLevelEvent e) {
		PiglinEvents.onSpawn(e.getLevel(), e.getEntity());
	}

    @SubscribeEvent
    public void registerCommands(RegisterCommandsEvent e) {
    	CommandPiglinnames.register(e.getDispatcher());
    }
}
