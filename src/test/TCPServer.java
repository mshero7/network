package test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		try {
			// 1. �������� ����
			serverSocket = new ServerSocket();
			
			// 2. ���ε�(binding)
			// : Socket�� SocketAddress(IPAddress + Port)
			//   �� ���ε��Ѵ�.
			InetAddress inetAddress = InetAddress.getLocalHost();
			// * String localhost = inetAddress.getHostAddress();
			// serverSocket.bind(new InetSocketAddress(localhost,5000));
			// * inetAddress ��ü�� �� ���
			// serverSocket.bind(new InetSocketAddress(inetAddress,5000));
			// * 0.0.0.0 -> ��� ȣ��Ʈ�� ������ �� ����.
			// ipconfig�� �ö��ִ� ȣ��Ʈ ����. (127.0.0.1 �Ұ�)
			serverSocket.bind(new InetSocketAddress("0.0.0.0",5000));
			
			// 3. accept
			// : Ŭ���̾�Ʈ�� �����û�� ��ٸ�.
			Socket socket = serverSocket.accept(); // blocking / accept�� �Ǳ������� ������.
			
			// Ŭ���̾�Ʈ ������ ������ ������ �ִ� InetSocketAddress �� ������
			InetSocketAddress inetRemoteSocketAddress = 
					(InetSocketAddress) socket.getRemoteSocketAddress();
			// ������� address, port�� ����
			String remoteHostAddress = inetRemoteSocketAddress.getAddress().getHostAddress();
			int remoteHostPort = inetRemoteSocketAddress.getPort();
			
			System.out.println(
					"[server] connected by client ["
								+remoteHostAddress + " : "+remoteHostPort
								+"]");
			
			try {
				// 4. Ŭ���̾�Ʈ socket�� ��Ʈ���� �޾ƿ�.
				InputStream is = socket.getInputStream();
				OutputStream os = socket.getOutputStream();
				
				while(true) {
					// 5. ������ �б�
					byte [] buffer = new byte [256];

					// ���⼭ �ѹ� ���ŷ
					int readByteCount = is.read(buffer);
					
					// Ŭ���̾�Ʈ�� disconnect�� �ԷµǸ� ������ ������.
					if(readByteCount == -1) {
						// Ŭ�󸮾�Ʈ ���������� ���
						// close() �޼ҵ� ȣ���� ����
						System.out.println("[server] closed by client");
						break;
					}
					
					String data = new String(buffer, 0, readByteCount, "utf-8");
					System.out.println("[server] received :" + data);

					// 6. ������ ����
					os.write( data.getBytes("utf-8"));
				}
				
			} catch(IOException e) {
				e.printStackTrace();
			} finally {
				try {
					if(socket != null & serverSocket.isClosed() == false)
						socket.close();	
				} catch (Exception e) {
					
				}
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
		}
		
		
	}

}
