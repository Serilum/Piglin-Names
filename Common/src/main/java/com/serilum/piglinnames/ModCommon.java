package com.serilum.piglinnames;

import com.natamus.collective.config.GenerateJSONFiles;
import com.serilum.piglinnames.config.ConfigHandler;
import com.serilum.piglinnames.data.Variables;
import com.serilum.piglinnames.util.Names;
import com.serilum.piglinnames.util.Reference;

import java.io.IOException;

public class ModCommon {

	public static void init() {
		ConfigHandler.initConfig();

		load();
	}

	private static void load() {
		GenerateJSONFiles.requestJSONFile(Reference.MOD_ID, "entity_names.json");

		try {
			Names.setCustomNames();
		} catch (IOException e) {
			Variables.logger.warn("[" + Reference.NAME + "] Unable to load custom name list config. Custom names disabled.");
		}
	}
}