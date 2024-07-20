package com.natamus.piglinnames.config;

import com.natamus.collective.config.DuskConfig;
import com.natamus.piglinnames.util.Reference;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ConfigHandler extends DuskConfig {
	public static HashMap<String, List<String>> configMetaData = new HashMap<String, List<String>>();

	@Entry public static boolean useCustomNames = true;
	@Entry public static boolean useDefaultFemaleNames = true;
	@Entry public static boolean useDefaultMaleNames = true;
	@Entry public static boolean useBothCustomAndDefaultNames = false;
	@Entry public static boolean shouldCapitalizeNames = true;

	public static void initConfig() {
		configMetaData.put("useCustomNames", Arrays.asList(
			"Use the custom name list, editable in ./mods/piglinnames/customnames.txt, seperated by a comma. If custom names are found, the default name list is ignored."
		));
		configMetaData.put("useDefaultFemaleNames", Arrays.asList(
			"Use the list of pre-defined female names when naming piglins."
		));
		configMetaData.put("useDefaultMaleNames", Arrays.asList(
			"Use the list of pre-defined male names when naming piglins."
		));
		configMetaData.put("useBothCustomAndDefaultNames", Arrays.asList(
			"Disabled by default. Whether both custom and default names should be used to name piglins."
		));
		configMetaData.put("shouldCapitalizeNames", Arrays.asList(
			"If enabled, the mod capitalizes each word in the custom name list."
		));

		DuskConfig.init(Reference.NAME, Reference.MOD_ID, ConfigHandler.class);
	}
}