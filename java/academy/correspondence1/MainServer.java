package NetWork;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

public class MainServer {
	int port = 7777; // 정수변수 port선언후 7777 대입
	ServerSocket server = null; // ServerSocket타입 server 선언 후 null 대입
	Socket child = null; // Socket타입 child 선언 후 null 대입

	HashMap<String, PrintWriter> hm; 
    //컬렉션인 HashMap타입의 키값을 String 값은 PrintWriter인 hm 변수 선언

	public MainServer() { //ChatServer 생성자

		ChatSverThread sr;
        //ChatServerThread타입에 sr 변수 선언
        //브로드 캐스팅을 하기위한 쓰레드 객체
		Thread t;
        //Thread 타입의 t 변수 선언

		try { //시도하다
			server = new ServerSocket( port ); //서버소켓을 생성해서 server 변수에 대입

			System.out.println( "**************************************" );//출력
			System.out.println( "*              채팅 서버                *" );//출력
			System.out.println( "**************************************" );//출력
			System.out.println( "클라이언트의 접속을 기다립니다." );//출력

			hm = new HashMap<String, PrintWriter>(); //hashMap객체를 생성해서 hm 변수에 대입

			while( true ) { // 무한 반복
				child = server.accept(); 
                //ServerSocket의 변수인 server를 이용하여 accept함수 호출을 하여
                //클라이언트 접속시까지 대기를 합니다.
                //접속시에는 클라이언트와 연결 됩니다.
                //클라이언트의 소켓을 연결받습니다.
				if( child != null ) { 
                //Socket타입에 변수인 child가 null 값이 아니면 실행
                //child에는 클라이언트 소켓과 연결을 할 수 있는 소켓입니다.
					sr = new ChatSverThread( child, hm ); 
                    //ChatSverThread 객체를 Socket과 HashMap을 받아서 생성 후에
                    //ChatSverThread의 변수인 sr에 대입
					t = new Thread(sr); 
                    //Thread객체를 ChatSverThread을 받아서 생성후 
                    //Thread의 변수인 t에 대입
					t.start();//쓰레드 시작
				}
			}
		}
		catch ( Exception e )	{ //예외처리가 발생하면 실행
			e.printStackTrace(); //예외처리 출력
		}
	}



	public static void main(String[] args) 
	{
		new MainServer(); //MainServer 객체 생성
	}
}
