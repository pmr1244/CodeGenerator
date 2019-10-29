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
		
		/*//Creation of a file
		File currentDirectory = new File(new File(".").getAbsolutePath());
		String path = currentDirectory.toString().replace(".", "").concat("src/main/java/com/pmr/");
		
		path = path+"TestClass2.java";
		
		File testPath = new File(path);
		System.out.println("Before creation: "+testPath.exists());
		if(testPath.exists())
			testPath.delete();
		
		if(!testPath.exists())
			testPath.createNewFile();
		System.out.println("After creation: "+testPath.exists());
		
		//Writing data to a file
		OutputStream os = new FileOutputStream(path);
		StringBuilder sb = new StringBuilder();
		sb.append("package com.pmr;\n");
		sb.append("import java.util.*;\n\n");
		sb.append("public class TestClass2 {\n\n");
		sb.append("public static void main(String args[]) {\n\n");
		sb.append("\t} \n");
		sb.append("}");
		
		os.write(sb.toString().getBytes());;*/
	}

}
