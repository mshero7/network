package io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PhoneList2 {

	public static void main(String[] args) {
		// 파일로 뽑을 수 있는 정보
		Scanner scanner = null;

		try {
			scanner = new Scanner(new FileInputStream("phone.txt"),"UTF-8");
			
			while(scanner.hasNextLine()) {
				// 탭, 개행 스페이스바가 토크나이저로 들어가있음.
				String name = scanner.next();
				String phone1 = scanner.next();
				String phone2 = scanner.next();
				String phone3 = scanner.next();
				
				System.out.println(name + ":" + phone1 + "-" + phone2 +"-" + phone3);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (scanner != null) {
				scanner.close();
			}
		}
	}

}
