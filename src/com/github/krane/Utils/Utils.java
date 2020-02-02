package com.github.krane.Utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.text.AbstractDocument.BranchElement;

public class Utils {

	
	
	public static String loadFileAsString(String path)
	{
		StringBuilder builder = new StringBuilder();
		
		try {
			BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
			String line;
			
			while((line = bufferedReader.readLine() )  != null)
			{
				builder.append(line + "\n");
				
			}
			
			bufferedReader.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return builder.toString();
		
	}
	
	
	public static int parseInt(String number)
	{
		try {
			
			return Integer.parseInt(number);
			
		} catch (NumberFormatException e) {
			// TODO: handle exception
			e.printStackTrace();
			return 0;
		}
	}
}
