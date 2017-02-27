package com.automation.AutomationQAChallenge_apis.QAChallenge_apis.conguration;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Properties;

/**
 * This class lists all the configuration parameters 
 */
public class Config {
	/**
	 * Configuration key: <i>timeout.large.ms</i>
	 * <p>
	 * <b>Default value: 30000</b>
	 * <p>
	 * 
	 * <pre>
	 * Usage: timeout.large.ms=180000
	 * </pre>
	 * 
	 * </p>
	 * Use this property to change the largest time out values in the test
	 * cases.
	 */
	public static String TIMEOUT_LARGE_MS = "30000";

	/**
	 * Configuration key: <i>timeout.medium.ms</i>
	 * <p>
	 * <b>Default value: 5000</b>
	 * <p>
	 * 
	 * <pre>
	 * Usage: timeout.medium.ms=8000
	 * </pre>
	 * 
	 * </p>
	 * Use this property to change the medium time out values in the test cases.
	 */
	public static String TIMEOUT_MEDIUM_MS = "6000";

	/**
	 * Configuration key: <i>timeout.small.ms</i>
	 * <p>
	 * <b>Default value: 2000</b>
	 * <p>
	 * 
	 * <pre>
	 * Usage: timeout.small.ms=2000
	 * </pre>
	 * 
	 * </p>
	 * Use this property to change the smallest time out values in the test
	 * cases.
	 */
	public static String TIMEOUT_SMALL_MS = "2000";

	/**
	 * Configuration key: <i>default.browser</i>
	 * <p>
	 * <b>OPTIONAL</b>
	 * <p>
	 * <b>Default value:</b> firefox
	 * <p>
	 * <b>Supported browser types:</b>
	 * <ul>
	 * <li>firefox</li>
	 * <li>chrome</li>
	 * <li>ie</li>
	 * <ul>
	 * </p>
	 * 
	 * <pre>
	 * Usage: default.browser=chrome
	 * </pre>
	 * 
	 * Use this property to set the browser to run the tests in.
	 */
	public static String DEFAULT_BROWSER = "firefox";


	/**
	 * Configuration key: <i>database.server</i>
	 * <p>
	 * 
	 * <pre>
	 * Usage: database.server=db.server
	 * </pre>
	 * 
	 * </p>
	 * Use this property to set the address of the database server to
	 * connect to.
	 */
	public static String DATABASE_SERVER = "db.server";
	
	/**
	 * Configuration key: <i>database.name</i>
	 * <p>
	 * 
	 * <pre>
	 * Usage: database.name=dbName
	 * </pre>
	 * 
	 * </p>
	 * Use this property to set the database instance to use.
	 */
	public static String DATABASE_NAME = "undefined";	
	
	/**
	 * Configuration key: <i>database.user.name</i>
	 * <p>
	 * 
	 * <pre>
	 * Usage: database.user.name=userName
	 * </pre>
	 * 
	 * </p>
	 * Use this property to set the username of the database server to
	 * connect to.
	 */
	public static String DATABASE_USER_NAME = "undefined";

	/**
	 * Configuration key: <i>database.password</i>
	 * <p>
	 * 
	 * <pre>
	 * Usage: database.password=password
	 * </pre>
	 * 
	 * </p>
	 * Use this property to set the password of the database server to
	 * connect to.
	 */
	public static String DATABASE_PASSWORD = "password";


	
	/**
	 * Configuration key: <i>application.url</i>
	 * <p>
	 * 
	 * <pre>
	 * Usage: application.url=undefine
	 * </pre>
	 * 
	 * </p>
	 * Use this property to set the application url 
	 * 
	 */
	public static String APPLICATION_URL = "undefine";
	
	/**
	 * Configuration key: <i>device.name</i>
	 * <p>
	 * 
	 * <pre>
	 * Usage: device.name=undefine
	 * </pre>
	 * 
	 * </p>
	 * Use this property to set the device name 
	 * 
	 */
	public static String DEVICE_NAME = "undefine";
	
	/**
	 * Configuration key: <i>platform.version</i>
	 * <p>
	 * 
	 * <pre>
	 * Usage: platform.version=undefine
	 * </pre>
	 * 
	 * </p>
	 * Use this property to set the platform version
	 * 
	 */
	public static String PLATFORM_VERSION = "undefine";
	
	
	/**
	 * Configuration key: <i>platform.name</i>
	 * <p>
	 * 
	 * <pre>
	 * Usage: platform.name=undefine
	 * </pre>
	 * 
	 * </p>
	 * Use this property to set the platform name
	 * 
	 */
	public static String PLATFORM_NAME = "undefine";
	
	/**
	 * Configuration key: <i>device.type</i>
	 * <p>
	 * 
	 * <pre>
	 * Usage: device.type=undefine
	 * </pre>
	 * 
	 * </p>
	 * Use this property to set the device type
	 * 
	 */
	public static String DEVICE_TYPE = "undefine";
	
	/**
	 * Configuration key: <i>card.no</i>
	 * <p>
	 * 
	 * <pre>
	 * Usage: card.no=undefine
	 * </pre>
	 * 
	 * </p>
	 * Use this property to set the credit card no
	 * 
	 */
	public static String CARD_NO = "undefine";
	
	/**
	 * Configuration key: <i>expiration.date</i>
	 * <p>
	 * 
	 * <pre>
	 * Usage: expiration.date=undefine
	 * </pre>
	 * 
	 * </p>
	 * Use this property to set the expiration date
	 * 
	 */
	public static String EXPIRATION_DATE = "undefine";
	
	/**
	 * Configuration key: <i>cvv.no</i>
	 * <p>
	 * 
	 * <pre>
	 * Usage: cvv.no=undefine
	 * </pre>
	 * 
	 * </p>
	 * Use this property to set the cvv no
	 * 
	 */
	public static String CVV_NO = "undefine";
	
	//
	// Non execution related class attributes.
	//
	private static final String CONFIG_FILE = "config.file";
	private static final String DEFAULT_CONFIG_FILE = "localhost.properties";

	private static boolean hasAlreadyReadProperties = false;
	private static Properties executionSettings = null;

	/**
	 * Reads the configuration given by the 'config.file' system property. Or
	 * from the default property file if it is not given as a system property.
	 */
	public static void readConfig() throws Exception {
		if (!hasAlreadyReadProperties) {
			String propertiesFile = System.getProperty(CONFIG_FILE,
					DEFAULT_CONFIG_FILE);
			if (new File(propertiesFile).exists()) {
				executionSettings = new Properties();
				try {
					executionSettings.load(new FileReader(propertiesFile));
				} catch (IOException ioe) {
					throw new Exception("Problems parsing properties file, '"
							+ propertiesFile + "'.");
				}

				// Set values for the set valid configurations.
				for (ConfigKeys key : ConfigKeys.values()) {
					String value = getConfigProperty(key.getKey());
					if (value != null) {
						Field f = Config.class.getField(key.getName());
						f.setAccessible(true);
						f.set(Config.class, value.trim());
					}
				}
			} else {
				throw new Exception("No properties file to be read, '"
						+ new File(propertiesFile) + "'.");
			}
			hasAlreadyReadProperties = true;
			// print the properties
			System.out.print("Test execution configuration: ");
			for (ConfigKeys key : ConfigKeys.values()) {
				Field f = Config.class.getField(key.getName());
				f.setAccessible(true);
				System.out.print(key.getKey() + "='" + f.get(Config.class)
						+ "', ");
			}
			System.out.println("\n");
		}
	}

	private static String getConfigProperty(String propertyName)
			throws Exception {
		if (executionSettings.containsKey(propertyName)) {
			return executionSettings.getProperty(propertyName);
		} else {
			return null;
		}
	}
}
