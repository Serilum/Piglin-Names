package com.natamus.piglinnames.util;

import com.natamus.collective.data.GlobalVariables;
import com.natamus.collective.functions.DataFunctions;
import com.natamus.collective.functions.StringFunctions;
import com.natamus.piglinnames.config.ConfigHandler;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Names {
	public static List<String> customPiglinNames = new ArrayList<String>();
	
	public static void setCustomNames() throws IOException {
		String dirpath = DataFunctions.getConfigDirectory() + File.separator + "piglinnames";
		File dir = new File(dirpath);
		File file = new File(dirpath + File.separator + "customnames.txt");
		
		if (dir.isDirectory() && file.isFile()) {
			Path customNamePath = Paths.get(dirpath + File.separator + "customnames.txt");
			String cn = Files.readString(customNamePath);

			cn = cn.replace("\n", "").replace("\r", "").strip();

			String[] cns = cn.split("[,\\n]");
			for (String n : cns) {
				String name = n.strip();

				if (!name.isEmpty()) {
					customPiglinNames.add(name);
				}
			}
		}
		else {
			boolean ignored = dir.mkdirs();
			
			PrintWriter writer = new PrintWriter(dirpath + File.separator + "customnames.txt", StandardCharsets.UTF_8);
			writer.close();
		}
	}
	
	public static String getRandomName() {
		List<String> piglinNameList = new ArrayList<String>();

		if (ConfigHandler.useCustomNames && !customPiglinNames.isEmpty()) {
			if (ConfigHandler.useBothCustomAndDefaultNames) {
				piglinNameList.add(randomFromList(customPiglinNames));
			}
			else {
				String name = randomFromList(customPiglinNames);

				if (ConfigHandler.shouldCapitalizeNames) {
					return StringFunctions.capitalizeEveryWord(name);
				}
				return name;
			}
		}

		if (ConfigHandler.useDefaultFemaleNames) {
			piglinNameList.add(randomFromList(GlobalVariables.femaleNames));
		}

		if (ConfigHandler.useDefaultMaleNames) {
			piglinNameList.add(randomFromList(GlobalVariables.maleNames));
		}

		piglinNameList.removeIf(name -> name.equals(""));
		
		if (piglinNameList.isEmpty()) {
			return "";
		}

		String name = randomFromList(piglinNameList);

		if (ConfigHandler.shouldCapitalizeNames) {
			return StringFunctions.capitalizeEveryWord(name);
		}
		return name;
	}

	private static String randomFromList(List<String> list) {
		if (list.size() == 0) {
			return "";
		}
		return list.get(GlobalVariables.random.nextInt(list.size()));
	}
}
