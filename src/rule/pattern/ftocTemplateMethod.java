package rule.pattern;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import rule.pattern.abs.Application;

public class ftocTemplateMethod extends Application 
{
	private InputStreamReader isr;
	private BufferedReader br;
	
	public static void main(String[] args) throws Exception
	{
		new ftocTemplateMethod().run(); 
	}
	
	@Override
	protected void init() 
	{
		// TODO Auto-generated method stub
		isr = new InputStreamReader(System.in);
		br = new BufferedReader(isr);

	}

	@Override
	protected void idle() 
	{
		// TODO Auto-generated method stub
		String fahrString = readLineAndReturnNullIfError();
		if (fahrString == null || fahrString.length() == 0)
		{
			setDone();
		}
		else 
		{
			double fahr = Double.parseDouble(fahrString);
			double celcius = 5.0 / 9.0 * (fahr - 32);
			System.out.println("F=" + fahr + ", C=" + celcius);
		}
	}

	@Override
	protected void cleanup() 
	{
		// TODO Auto-generated method stub
		System.out.println("ftoc exit");
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
