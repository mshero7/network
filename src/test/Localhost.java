package test;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Localhost {
	public static void main(String[] args) {
		try {
			// InetAddress return
			InetAddress inetAddress = InetAddress.getLocalHost();
			
			// PC�� �̸� + IP���
			String hostName = inetAddress.getHostName();
			String hostAddress = inetAddress.getHostAddress();
			System.out.println(hostName + " " + hostAddress);

			System.out.println();
			
			byte[] addresses = inetAddress.getAddress();
			for( byte addr : addresses) {
				// ��Ʈ������
				System.out.println(addr & 0x000000ff);
			}
			
//			InetAddress[] inetAddresses = InetAddress.getAllByName(hostName);
//			
//			for(InetAddress addr : inetAddresses) {
//				System.out.println(addr.getHostAddress());
//			}
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
