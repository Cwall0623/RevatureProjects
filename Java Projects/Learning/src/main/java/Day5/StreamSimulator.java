package Day5;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.FileOutputStream;

public class StreamSimulator {

	public static void main (String[] args) {
		try {
			fosExample();
			fisExample();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void fosExample() throws IOException{
		
		FileOutputStream fos = new FileOutputStream("files/myfile.txt"); {
			for (char letter = 'A'; letter <= 'Z'; letter++) {
				fos.write(letter);
			}
			if(fos != null)
				fos.close();
		}	
	}
		public static void fisExample() throws IOException {
			FileInputStream fis = new FileInputStream("files/myfile.txt");
			byte input;
			while((input = (byte)fis.read() ) != -1) {
				System.out.print((char)input);
			}
	}
}
