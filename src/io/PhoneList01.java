package io;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PhoneList01 {

	public static void main(String[] args) {
		BufferedReader br = null;
		try {
			
			//보조스트림1 (bytes -> char)
			br = new BufferedReader(
								new InputStreamReader(
								new FileInputStream("phone.txt"), "UTF-8"));
			String line = null;
			
			while((line = br.readLine()) != null) {
				StringTokenizer st = 
						new StringTokenizer(line, "\t, ");
				
				// 선생님이 사용하는 방법
				
				int index = 0;

				while(st.hasMoreElements()) {
					
					String token = st.nextToken();
					// while-if 안의 반복되는 문장을 밖으로 빼냄(리팩토링)
					
					System.out.print(token);
					
					if(index == 0) {
						System.out.print(":");
					} else if(index == 1) {
						System.out.print("-");
					} else if(index == 2) {
						System.out.print("-");
					}
					index++;
				}
				System.out.println();
			}
		} catch (IOException e) {
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
