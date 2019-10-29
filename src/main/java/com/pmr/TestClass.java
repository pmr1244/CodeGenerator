/**
 * 
 */
package com.pmr;

import java.io.IOException;

/**
 * @author pmr
 *
 */
public class TestClass {

	public static void main(String[] args) throws IOException {
		
		AbstractCodeGenerator factory = CodeGeneratorFactory.getCodeGenerator("/home/pmr/projects/CodeGenerator/src/main/resources/config.json", "java");
		factory.generate();
	}

}
