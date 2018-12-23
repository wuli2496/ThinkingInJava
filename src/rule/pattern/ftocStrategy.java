package rule.pattern;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import rule.pattern.itf.Application;

public class ftocStrategy implements Application 
{
	private InputStreamReader isr;
	private BufferedReader br;
	private boolean isDone = false;
	
	public static void main(String[] args) throws Exception
	{
		new ApplicationRunner(new ftocStrategy()).run();
	}
	
	@Override
	public void init() 
	{
		// TODO Auto-generated method stub
		isr = new InputStreamReader(System.in);
		br = new BufferedReader(isr);
	}

	@Override
	public void idle() 
	{
		// TODO Auto-generated method stub
		String fahrString = readLineAndReturnNullIfError();
		if (fahrString == null || fahrString.length() == 0)
		{
			isDone = true;
		}
		else 
		{
			double fahr = Double.parseDouble(fahrString);
			double celcius = 5.0 / 9.0 * (fahr - 32);
			System.out.println("F=" + fahr + ", C=" + celcius);
		}
	}

	@Override
	public void cleanup() 
	{
		// TODO Auto-generated method stub
		System.out.println("ftoc exit");
	}

	@Override
	public boolean done() 
	{
		// TODO Auto-generated method stub
		return isDone;
	}

	private String readLineAndReturnNullIfError()
	{
		String s;
		try 
		{
			s = br.readLine();
		}
		catch (IOException e)
		{
			s = null;
		}
		
		return s;
	}
}
