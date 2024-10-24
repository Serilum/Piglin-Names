package com.natamus.piglinnames.util;

import com.natamus.collective.functions.EntityFunctions;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.monster.piglin.AbstractPiglin;

public class Util {
	public static int unnameLoadedPiglins(ServerLevel serverLevel) {
		int unnameCount = 0;

		for (Entity entity : serverLevel.getAllEntities()) {
			if (entity instanceof AbstractPiglin) {
				if (entity.hasCustomName()) {
					entity.setCustomName(null);
					entity.removeTag(Reference.MOD_ID + ".named");

					unnameCount += 1;
				}
			}
		}

		return unnameCount;
	}

	public static int nameLoadedPiglins(ServerLevel serverLevel) {
		int nameCount = 0;

		for (Entity entity : serverLevel.getAllEntities()) {
			if (entity instanceof AbstractPiglin) {
				if (!entity.hasCustomName()) {
					EntityFunctions.nameEntity(entity, Names.getRandomName());
					entity.addTag(Reference.MOD_ID + ".named");

					nameCount += 1;
				}
			}
		}

		return nameCount;
	}

	public static int renameLoadedPiglins(ServerLevel serverLevel) {
		unnameLoadedPiglins(serverLevel);
		return nameLoadedPiglins(serverLevel);
	}
}
