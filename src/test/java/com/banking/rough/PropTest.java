package com.banking.rough;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropTest  {
	
	public static FileInputStream fis;
	
	public static void main(String[] args) throws IOException {
		
		
		 fis=new FileInputStream("B:\\finalProjects\\Hybrid_Data_Keyword_driven_framework\\src\\test\\resources\\properties\\Config.properties");

		 fis=new FileInputStream("B:\\finalProjects\\Hybrid_Data_Keyword_driven_framework\\src\\test\\resources\\properties\\OR.properties");
		Properties config=new Properties();
		Properties OR=new Properties();
		
		config.load(fis);
		OR.load(fis);
		System.out.println(config.getProperty("browser"));
		System.out.println(OR.getProperty("name"));
		
	}

}
