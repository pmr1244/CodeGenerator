/**
 * 
 */
package com.pmr.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.pmr.AbstractCodeGenerator;
import com.pmr.ConfigToPojoConverter;
import com.pmr.common.Args;
import com.pmr.common.ClassSchema;
import com.pmr.common.Methods;
import com.pmr.common.RootNode;
import com.pmr.common.Variables;

/**
 * @author pmr
 *
 */
public class JavaCodeGenerator implements AbstractCodeGenerator {
	
	private ConfigToPojoConverter converter;
	private final String JAVA_SRC_PATH = "src/main/java/";
	private final String DEFAULT_PKG = "default";
	private final String PACKAGE = "package ";
	private final String NEW_LINE = "\n";
	private final String NEW_LINES = "\n\n";
	private final String TAB = "\t";
	private final String JAVA_UTIL_IMPORT = "import java.util.*;";
	private final String OPEN_CURLY = " {";
	private final String CLOSE_CURLY = "}";
	private final String JAVA_FILE_EXT = ".java";
	
	
	

	public JavaCodeGenerator(ConfigToPojoConverter converter) {
		this.converter = converter;
	}

	@Override
	public void generate() {
		RootNode classes = converter.convert();
		classes.getClasses().forEach(cls ->generateCode(cls));
	}
	
	private ClassSchema generateCode(ClassSchema cls) {
		try {
		String pkg = StringUtils.isEmpty(cls.getPackageName()) ? DEFAULT_PKG : cls.getPackageName();
		String className = cls.getName();
		boolean finalCls = cls.getFinalClass();
		String accessModifiler = cls.getAccessModifier();
		
		File currentDirectory = new File(new File(".").getAbsolutePath());
		String pathString = currentDirectory.toString().replace(".", "").concat(JAVA_SRC_PATH + pkg + "/" + className);
		pathString = pathString.replace(".", "/").concat(JAVA_FILE_EXT);
		File path = new File(pathString);
		
		System.out.println("Before creation: "+path.exists());
		if(path.exists())
			path.delete();
		
		if(!path.exists())			
				path.createNewFile();
		
		OutputStream os = new FileOutputStream(path);
			
		System.out.println("After creation: "+path.exists());
		StringBuilder sb = new StringBuilder();
		sb.append(PACKAGE+ pkg + ";" + NEW_LINES);
		sb.append(JAVA_UTIL_IMPORT+NEW_LINES);
		sb.append(StringUtils.isEmpty(accessModifiler)? "" : accessModifiler);
		sb.append(finalCls? " final": "");
		sb.append(" class " + className + OPEN_CURLY);
		sb.append(NEW_LINES);
		//class variables
		String variables = generateVariables(cls.getVariables());
		sb.append(variables+NEW_LINES);
		//methods
		String methodsString = generateMethods(cls.getMethods());
		
		sb.append(methodsString);
		
		sb.append(NEW_LINE + CLOSE_CURLY);
		
		
		os.write(sb.toString().getBytes());
		return cls;
		} catch (IOException e) {
			// TODO: handle exception
		}
		
		return null;
		
		
	}

	private String generateVariables(List<Variables> variables) {
		StringBuilder variableString = new StringBuilder();
		variables.forEach(var -> {
			String accessModifier = var.getAccessModifier();
			boolean isStatic = var.getStaticVariable();
			boolean isFinal = var.getFinalVariable();
			String varType = var.getType();
			String varName = var.getName();
			Object initialVal = var.getInitialValue();
			
			variableString.append(StringUtils.isEmpty(accessModifier)? "" : accessModifier);
			variableString.append(isStatic ? " static" : "");
			variableString.append(isFinal ? " final" : "");
			variableString.append(" " + varType);
			variableString.append(" " + varName);
			if(varType.equalsIgnoreCase("string") && !StringUtils.isEmpty(initialVal.toString())) {
				initialVal = "\""+ initialVal.toString()+"\"";
			}
			variableString.append(StringUtils.isEmpty(initialVal.toString()) ? ";" : " = "+initialVal.toString()+";");
			variableString.append(NEW_LINE);
		});
		return variableString.toString();
	}
	
	private String generateMethods(List<Methods> methods) {
		StringBuilder methodString = new StringBuilder();
		methods.forEach(method -> {
			String accessModifier = method.getAccessModifier();
			boolean isStatic = method.getStaticMethod();
			boolean isFinal = method.getFinalMethod();
			String retType = method.getReturnType();
			String methodName = method.getName();
			List<Args> args = method.getArgs();
			
			methodString.append(StringUtils.isEmpty(accessModifier)? "" : accessModifier);
			methodString.append(isStatic ? " static" : "");
			methodString.append(isFinal ? " final" : "");
			methodString.append(" " + retType);
			methodString.append(" " + methodName + "(");
			
			String argsString = generateArgs(args);
			
			methodString.append(argsString + ")");
			methodString.append(" " + OPEN_CURLY + NEW_LINE);
			if(!retType.equalsIgnoreCase("void")) {
				methodString.append(TAB+"return 0;" + NEW_LINE);
			}
			methodString.append(CLOSE_CURLY + NEW_LINE);
			
			/*if(varType.equalsIgnoreCase("string") && !StringUtils.isEmpty(initialVal.toString())) {
				initialVal = "\""+ initialVal.toString()+"\"";
			}
			methodString.append(StringUtils.isEmpty(initialVal.toString()) ? ";" : " = "+initialVal.toString()+";");*/
			methodString.append(NEW_LINE);
		});
		return methodString.toString();
	}
	
	private String generateArgs(List<Args> args) {
		StringBuilder argsString = new StringBuilder();
		
		args.forEach(arg -> {
			String type = arg.getType();
			String name = arg.getName();
			argsString.append(type).append(" "+ name + " ,");
		});
		
		//removing last comma from the arg string
		return argsString.toString().substring(0, argsString.length()-2);
	}
	
	
}
