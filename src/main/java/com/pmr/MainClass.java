/**
 * 
 */
package com.pmr;

import java.io.IOException;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

/**
 * @author pmr
 *
 */
public class MainClass {
	private static String filePath;
	private static String codeType;

	public static void main(String[] args) throws IOException {
		
		Options options = new Options();
		CommandLineParser parser = new DefaultParser();
		Option configFilePath = new Option("i", "path", true, "input file path");
		configFilePath.setRequired(true);
        options.addOption(configFilePath);

        Option targetCodeType = new Option("o", "type", true, "target code type");
        targetCodeType.setRequired(true);
        options.addOption(targetCodeType);

		
		try {
			CommandLine commandLine = parser.parse(options, args);
			if (commandLine.hasOption("i")) {
				filePath = commandLine.getOptionValue("i");
			}
			if (commandLine.hasOption("o")) {
				codeType = commandLine.getOptionValue("o");
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		AbstractCodeGenerator factory = CodeGeneratorFactory.getCodeGenerator(filePath, codeType);
		factory.generate();
	}

}
