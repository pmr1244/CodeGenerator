/**
 * 
 */
package com.pmr;

import com.pmr.common.TargetCodeTypes;
import com.pmr.impl.JavaCodeGenerator;

/**
 * @author pmr
 *
 */
public class CodeGeneratorFactory {

	public static AbstractCodeGenerator getCodeGenerator(String configFile, String targetCodeType) {

		ConfigToPojoConverter converter = ConfigToPojoConverterFactory.getConverter(configFile);

		if (targetCodeType.equalsIgnoreCase(TargetCodeTypes.JAVA.toString()))
			return new JavaCodeGenerator(converter);
		else
			return null;

	}

}
