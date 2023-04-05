package com.javaexercise;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileExercise {
	
	
	public void copyFileWithoutError() throws IOException
	{
		//Read file
		File f=new File("C:\\Users\\raghuvr\\Documents\\file1.txt");
		FileReader fr=new FileReader(f);
		BufferedReader br=new BufferedReader(fr);
		
		
		//write file
		File f1=new File("C:\\Users\\raghuvr\\Documents\\without_error_lines.txt");
		FileWriter fw=new FileWriter(f1);
		BufferedWriter bw=new BufferedWriter(fw);
		
		//logic to read a line from file1 and write it into the file2(without error line)
		String line=br.readLine();
		while(line!=null)
		{
			if(!line.contains("error"))
			{
				bw.write(line);
				bw.newLine();
				
			}
			line=br.readLine();
		}
		
		bw.flush(); //save a file
		//close a file
		bw.close();
		br.close();
		System.out.println("File copied to file2 without an 'error' word!!! ");
		
	}
	public void copyToUpperCase() throws IOException
	{
		//Read file
		File f=new File("C:\\Users\\raghuvr\\Documents\\file1.txt");
		FileReader fr=new FileReader(f);
		BufferedReader br=new BufferedReader(fr);
		
		//write a file
		File f1=new File("C:\\Users\\raghuvr\\Documents\\UpperCase.txt");
		FileWriter fw=new FileWriter(f1);
		BufferedWriter bw=new BufferedWriter(fw);
		
		
		//logic to write file with upper case
		
		String line;
		while((line=br.readLine())!=null)
		{
			bw.write(line.toUpperCase());
			bw.newLine();
		}
		bw.flush();
		bw.close();
		br.close();
		System.out.println("File copied to uppercase file with capital letters!!!");
	}

}
