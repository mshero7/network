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
			
			//������Ʈ��1 (bytes -> char)
			br = new BufferedReader(
								new InputStreamReader(
								new FileInputStream("phone.txt"), "UTF-8"));
			String line = null;
			
			while((line = br.readLine()) != null) {
				StringTokenizer st = 
						new StringTokenizer(line, "\t, ");
				
				// �������� ����ϴ� ���
				
				int index = 0;

				while(st.hasMoreElements()) {
					
					String token = st.nextToken();
					// while-if ���� �ݺ��Ǵ� ������ ������ ����(�����丵)
					
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
