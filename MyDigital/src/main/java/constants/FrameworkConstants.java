package constants;

import java.io.File;

public class FrameworkConstants {

	private final static int IMPLICITWAITTIME = 15;

	@SuppressWarnings("unused")
	private final static String projectDirectory = System.getProperty("user.dir");

	private final static String CONFIG_FILEPATH = System.getProperty("user.dir") + File.separator + "properties"
			+ File.separator + "config.properties";

	public static String getConfigFilePath() {
		return CONFIG_FILEPATH;
	}

	public static int getImplicitWaitTime() {
		return IMPLICITWAITTIME;
	}

}
