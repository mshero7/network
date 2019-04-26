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
			// 1. 서버소켓 생성
			serverSocket = new ServerSocket();
			
			// 2. 바인딩(binding)
			// : Socket에 SocketAddress(IPAddress + Port)
			//   를 바인딩한다.
			InetAddress inetAddress = InetAddress.getLocalHost();
			// * String localhost = inetAddress.getHostAddress();
			// serverSocket.bind(new InetSocketAddress(localhost,5000));
			// * inetAddress 객체가 들어간 경우
			// serverSocket.bind(new InetSocketAddress(inetAddress,5000));
			// * 0.0.0.0 -> 모든 호스트로 접근할 수 있음.
			// ipconfig에 올라가있는 호스트 가능. (127.0.0.1 불가)
			serverSocket.bind(new InetSocketAddress("0.0.0.0",5000));
			
			// 3. accept
			// : 클라이언트의 연결요청을 기다림.
			Socket socket = serverSocket.accept(); // blocking / accept가 되기전까지 막아줌.
			
			// 클라이언트 소켓의 정보를 가지고 있는 InetSocketAddress 를 가져옴
			InetSocketAddress inetRemoteSocketAddress = 
					(InetSocketAddress) socket.getRemoteSocketAddress();
			// 상대편의 address, port가 나옴
			String remoteHostAddress = inetRemoteSocketAddress.getAddress().getHostAddress();
			int remoteHostPort = inetRemoteSocketAddress.getPort();
			
			System.out.println(
					"[server] connected by client ["
								+remoteHostAddress + " : "+remoteHostPort
								+"]");
			
			try {
				// 4. 클라이언트 socket의 스트림을 받아옴.
				InputStream is = socket.getInputStream();
				OutputStream os = socket.getOutputStream();
				
				while(true) {
					// 5. 데이터 읽기
					byte [] buffer = new byte [256];

					// 여기서 한번 블로킹
					int readByteCount = is.read(buffer);
					
					// 클라이언트의 disconnect가 입력되면 연결이 해제됨.
					if(readByteCount == -1) {
						// 클라리언트 정상종료한 경우
						// close() 메소드 호출을 통해
						System.out.println("[server] closed by client");
						break;
					}
					
					String data = new String(buffer, 0, readByteCount, "utf-8");
					System.out.println("[server] received :" + data);

					// 6. 데이터 쓰기
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
