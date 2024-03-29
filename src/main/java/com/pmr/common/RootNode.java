/**
 * 
 */
package com.pmr.common;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author pmr
 *
 */
@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonIgnoreProperties(ignoreUnknown = true)
public class RootNode {
	@JsonProperty("classes")
	private List<ClassSchema> classes;

	public List<ClassSchema> getClasses() {
		return classes;
	}

	public void setClasses(List<ClassSchema> classes) {
		this.classes = classes;
	}

}
