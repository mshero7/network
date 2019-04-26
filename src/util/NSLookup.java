package util;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class NSLookup {

	public static void main(String[] args) {
		try {
			Scanner rd = new Scanner(System.in);
			
			while(true) {
				String hostName = rd.nextLine();
				
				if(hostName.equals("exit")) {
					return;
				}
				
				InetAddress[] inetAddresses = InetAddress.getAllByName(hostName);

				for(InetAddress addr : inetAddresses) {
					System.out.println(hostName + " : " + addr.getHostAddress());
				}
			}
			
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}