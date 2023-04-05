package com.javaexercise;

public class MatrixMaximum {

	public void maxcol(int[][] marr)
	{
		int min=marr[0][0];
		int col=0;
		for(int i=0;i<marr.length;i++)
		{
			for(int j=0;j<marr.length;j++)
			{
				if(marr[i][j]<min)
				{
					min=marr[i][j];
					col=j;
				}
			}
		}
		
		int max=marr[0][col];
		for(int i=0;i<marr.length;i++)
		{
			if(marr[i][col]>max)
			{
				max=marr[i][col];
			}
			
		}
		System.out.println("minimum value in the Matrix is :"+min);
		System.out.println("maximum value of minimum value colomn :"+max);
		
		
	}
}
