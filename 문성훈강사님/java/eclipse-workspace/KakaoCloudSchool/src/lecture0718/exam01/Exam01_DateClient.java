package lecture0718.exam01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class Exam01_DateClient extends Application {
	
	TextArea textarea;
	Button connBtn;	// 서버와 connect button
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// 화면 구성
		BorderPane root = new BorderPane();	// 전체 window의 패널
		root.setPrefSize(700, 500);	// window 크기
		
		textarea = new TextArea();
		root.setCenter(textarea);	// 화면 중앙에 textarea를 넣어준다.
		
		connBtn = new Button("Date 서버 접속");
		connBtn.setPrefSize(150, 40);
		connBtn.setOnAction(e -> {
			textarea.clear();
			// 서버 프로세스에 접근 시도
			try {
				Socket socket = new Socket("localhost", 5678);
				// 이 라인까지 실행되었으면 클라이언트가 서버로 접근 시도하여 연결되어 소켓이 생성됨
				// 접속 성공 : steram을 만들어 통로 생성
				InputStreamReader ir = new InputStreamReader(socket.getInputStream());
				BufferedReader br = new BufferedReader(ir);	// line 단위로 데이터를 읽을 수 있음
				
				String msg = br.readLine();	// blocking
				textarea.appendText(msg + "\n");	// 나중에 문제가 생길 수 있음 (동기화 문제로 문자가 제대료 표현이 안될 가능성)
				
				// 사용한 자원 반납
				br.close();
				ir.close();
				socket.close();
				
				textarea.appendText("서버와의 연결이 종료되었습니다.");
			} catch (Exception e2) {
				// TODO: handle exception
			}
		});
		
		FlowPane flowPane = new FlowPane();
		flowPane.setPadding(new Insets(10, 10, 10, 10));	// 여백
		flowPane.setPrefSize(700, 40);
		flowPane.setHgap(10);
		flowPane.getChildren().add(connBtn);	// 버튼 붙임
		
		root.setBottom(flowPane);
		
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch();	// launch()를 실행하면 창을 open할 준비
		
	}
}
