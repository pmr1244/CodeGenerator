/**
 * 
 */
package com.pmr.common;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @author pmr
 *
 */
@JsonInclude(JsonInclude.Include.NON_ABSENT)
public class Args {
	private String type;
	private String name;

	public String getType() {
		return type;
	}

	public String getName() {
		return name;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setName(String name) {
		this.name = name;
	}
}
