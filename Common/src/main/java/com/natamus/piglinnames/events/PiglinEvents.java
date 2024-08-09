package com.natamus.piglinnames.events;

import com.natamus.collective.functions.EntityFunctions;
import com.natamus.piglinnames.util.Names;
import com.natamus.piglinnames.util.Reference;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.monster.piglin.AbstractPiglin;
import net.minecraft.world.level.Level;

public class PiglinEvents {
	public static void onSpawn(Level level, Entity entity) {
		if (level.isClientSide) {
			return;
		}

		if (entity.getTags().contains(Reference.MOD_ID + ".named")) {
			return;
		}

		if (!(entity instanceof AbstractPiglin)) {
			return;
		}

		if (entity.hasCustomName()) {
			return;
		}
		
		String name = Names.getRandomName();
		if (!name.equals("")) {
			EntityFunctions.nameEntity(entity, name);
			entity.getTags().add(Reference.MOD_ID + ".named");
		}
	}
}
