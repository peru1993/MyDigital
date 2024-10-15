package constants;

import java.io.File;

public class FrameworkConstants {

	private final static int IMPLICITWAITTIME = 15;
	private final static String projectDirectory = System.getProperty("user.dir");
	private final static String RESOURCES_FILEPATH = projectDirectory + File.separator + "src" + File.separator +  "test" + File.separator +  "resource";
	private final static String CONFIG_FILEPATH = RESOURCES_FILEPATH + File.separator +  "config.properties";

	public static String getConfigFilePath() {
		return CONFIG_FILEPATH;
	}

	public static int getImplicitWaitTime() {
		return IMPLICITWAITTIME;
	}

}
