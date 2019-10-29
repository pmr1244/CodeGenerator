/**
 * 
 */
package com.pmr.impl;

import com.pmr.AbstractCodeGenerator;
import com.pmr.ConfigToPojoConverter;
import com.pmr.common.RootNode;

/**
 * @author pmr
 *
 */
public class JavaCodeGenerator implements AbstractCodeGenerator {
	
	private ConfigToPojoConverter converter;

	public JavaCodeGenerator(ConfigToPojoConverter converter) {
		this.converter = converter;
	}

	@Override
	public void generate() {
		RootNode classes = converter.convert();
		classes.getClasses();
	}
	
	
}
