package io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

public class KeyboardTest {
	public static void main(String[] args) {

		BufferedReader br = null;
		InputStreamReader isr = null;
		
		// ���Stream (�ҽ����ٰ� �ٷ� ���� �� �ִ°�)
		// ǥ���Է�, Ű����� �̹� ������ �Ǿ����� => System.in
		
		try {
			// ������Ʈ��1
			// byte1|byte2|byte3 -> char
			isr = new InputStreamReader(System.in,"UTF-8");
			
			// ������Ʈ��2
			// char1|char2|char3|\n -> "char1char2char3"
			br = new BufferedReader(isr);
			
			// read
			String line = null;
			while((line = br.readLine()) != null) {
				System.out.println(">>" + line);
			}
			
			
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
