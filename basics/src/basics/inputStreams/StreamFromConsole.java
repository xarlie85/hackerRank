package basics.inputStreams;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

public class StreamFromConsole {

	public static void main(String[] args) {
		System.out.print("-- started --");
		
		BufferedReader inputB = new BufferedReader(new InputStreamReader(System.in));
		InputStreamReader in = new InputStreamReader(System.in,Charset.defaultCharset());
		int b = 'b';
		try {
			while ((b = System.in.read()) != -1) {
				System.out.print("Inserta algún carácter:");
				System.out.print(b +"\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.print("-- finished --");
	}
}
