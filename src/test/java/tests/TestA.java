package tests;

import java.io.File;

import net.sourceforge.tess4j.Tesseract;


public class TestA
{
	public static void main(String[] args) throws Exception
	{
		//Get Text in that captcha image(using Tess4j)
		File f=new File("target\\mycaptcha.png");
		Tesseract t=new Tesseract();
		t.setDatapath("src\\test\\resources");//which consists of trained data file                            
		String x=t.doOCR(f); //OCR on given image with the help of "eng.traineddata"
		System.out.println(x);
	}

}
