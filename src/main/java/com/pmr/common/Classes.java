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
public class Classes {
	@JsonProperty("packageName")
	private String packageName;
	private String name;
	private boolean finalClass;
	private String accessModifier;
	@JsonProperty("variables")
	private List<Variables> variables;
	@JsonProperty("methods")
	private List<Methods> methods;

	public String getPackageName() {
		return packageName;
	}

	public String getName() {
		return name;
	}

	public boolean getFinalClass() {
		return finalClass;
	}

	public String getAccessModifier() {
		return accessModifier;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setFinalClass(boolean finalClass) {
		this.finalClass = finalClass;
	}

	public void setAccessModifier(String accessModifier) {
		this.accessModifier = accessModifier;
	}

	public List<Methods> getMethods() {
		return methods;
	}

	public void setMethods(List<Methods> methods) {
		this.methods = methods;
	}

	public List<Variables> getVariables() {
		return variables;
	}

	public void setVariables(List<Variables> variables) {
		this.variables = variables;
	}

}