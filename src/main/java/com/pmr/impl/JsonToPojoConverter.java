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
	private String filePath;

	public JsonToPojoConverter(String filePath) {
		this.filePath = filePath;
	}
	
	@Override
	public RootNode convert() {
		ObjectMapper mapper = new ObjectMapper();
		try {
			RootNode classes = mapper.readValue(new File(this.filePath), RootNode.class);
			System.out.println(classes.toString());
			return classes;
		} catch (IOException e) {
			System.out.println("Error occurred"+ e);
		}
		return null;
			
	}
}
