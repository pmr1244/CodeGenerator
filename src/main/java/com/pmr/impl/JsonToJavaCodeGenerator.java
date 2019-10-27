/**
 * 
 */
package com.pmr.impl;

import com.pmr.AbstractCodeGenerator;
import com.pmr.common.FileTypes;

/**
 * @author pmr
 *
 */
public class JsonToJavaCodeGenerator extends AbstractCodeGenerator {

	/* (non-Javadoc)
	 * @see com.pmr.AbstractCodeGenerator#generate()
	 */
	public JsonToJavaCodeGenerator(String filePath) {
		this.setFileType(FileTypes.JSON);
		this.setFileName(filePath);
		this.setFileParser(new JsonToPojoConverter());
		this.setFileCompiler(new JavaCodeCompiler());
	}
}
