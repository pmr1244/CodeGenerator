/**
 * 
 */
package com.pmr.impl;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pmr.ConfigToPojoConverter;
import com.pmr.common.RootNode;



/**
 * @author pmr
 *
 */
public class JsonToPojoConverter implements ConfigToPojoConverter {

	/* (non-Javadoc)
	 * @see com.pmr.ConfigFileParserAndConverter#convert()
	 */
	@Override
	public void convert(String path) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			RootNode classes = mapper.readValue(new File(path), RootNode.class);
			System.out.println(classes.toString());
		} catch (IOException e) {
			System.out.println("Error occurred"+ e);
		}
				
	}
	
	public static void main(String args[]) {
		JsonToPojoConverter converter = new JsonToPojoConverter();
		converter.convert("/home/pmr/projects/CodeGenerator/src/main/resources/config.json");
	}
}
