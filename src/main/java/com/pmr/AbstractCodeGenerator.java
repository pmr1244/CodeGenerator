/**
 * 
 */
package com.pmr;

import java.util.List;

import com.pmr.common.Classes;
import com.pmr.common.FileTypes;

/**
 * @author pmr
 *
 */
public abstract class AbstractCodeGenerator {
	public String fileName;
	public FileTypes fileType;
	public ConfigToPojoConverter fileParser;
	public CodeCompiler fileCompiler;
	public List<Classes> classList;
	
	public void generate(List<Classes> classList) {
		//TODO: Implement this
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public FileTypes getFileType() {
		return fileType;
	}

	public void setFileType(FileTypes fileType) {
		this.fileType = fileType;
	}

	public ConfigToPojoConverter getFileParser() {
		return fileParser;
	}

	public void setFileParser(ConfigToPojoConverter fileParser) {
		this.fileParser = fileParser;
	}

	public CodeCompiler getFileCompiler() {
		return fileCompiler;
	}

	public void setFileCompiler(CodeCompiler fileCompiler) {
		this.fileCompiler = fileCompiler;
	}

	public List<Classes> getClassList() {
		return classList;
	}

	public void setClassList(List<Classes> classList) {
		this.classList = classList;
	}
}
