package com.util.property;

import java.io.IOException;
import java.util.ArrayList;

public class ReadExcelDataMainClass {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ReadDataFromExcel rd=new ReadDataFromExcel();
		ArrayList<String> data=new ArrayList<>();
		data=rd.getData("testDropDown");
		System.out.println(data);

		ReadDataExcelExercise ex=new ReadDataExcelExercise();
		String value=ex.getValue("Data1 From");
		System.out.println(value);
	}

}
