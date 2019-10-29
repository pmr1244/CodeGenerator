/**
 * 
 */
package com.pmr;

import com.pmr.common.FileTypes;
import com.pmr.impl.JsonToPojoConverter;

/**
 * @author pmr
 *
 */
public class ConfigToPojoConverterFactory {

	public static ConfigToPojoConverter getConverter(String configFile) {
		String fileType = getFileType(configFile);
		if(fileType.equalsIgnoreCase(FileTypes.JSON.toString()))
			return new JsonToPojoConverter(configFile);
		else
			return null;
	}
	
	private static String getFileType(String configFile) {
		int lastIdx = configFile.lastIndexOf('.');
		return configFile.substring(lastIdx+1);
	}
}
