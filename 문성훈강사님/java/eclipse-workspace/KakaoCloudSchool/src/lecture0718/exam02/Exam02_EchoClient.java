package lecture0718.exam02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class Exam02_EchoClient extends Application {
   
   TextArea textarea; 
   Button connBtn; 
   TextField idField, textfield;
   
   Socket socket;
   BufferedReader br;
   PrintWriter pr;
   
   @Override
   public void start(Stage primaryStage) throws Exception {
      // 화면 구성
      BorderPane root = new BorderPane(); 
      root.setPrefSize(700, 500); 
      
      textarea= new TextArea(); 
      root.setCenter(textarea); //화면 center에 textarea를 붙인다.
      
      connBtn = new Button("Echo 서버 접속"); 
      connBtn.setPrefSize(150, 40 ); //버튼 크기 
      connBtn.setOnAction(e -> {
         textarea.clear(); 
         try{
            // 서버 process에 접속을 시도
            socket = new Socket("localhost", 5678); //Sever의 ip, port
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            pr = new PrintWriter(socket.getOutputStream());
            
            textarea.appendText("Echo Server 접속 성공!" + "\n");
            
//            // 접속을 성공했으니 이제 stream을 연다. -> byte읽기 -> InputStreamReader로 문자열 읽기 -> BufferedReader로 line 단위로 읽기 
//            InputStreamReader ir= new InputStreamReader(socket.getInputStream());
//            BufferedReader br = new BufferedReader(ir); 
//         
//            String msg = br.readLine(); //readLine는 blocking 메소드 -> 읽을 것이 있을 때까지 대기
//            
//            textarea.appendText(msg+"\n"); // 나중에 문제생길 수도 있다.
//            
//            //사용한 자원 반납 - 사용한 것 역순으로 반납
//            br.close(); 
//            ir.close();
//            socket.close();
//            
//            textarea.appendText("서버와의 연결이 종료되었어요."); 

            }catch(Exception e2) {
            
         }
      });
      
      idField = new TextField();
      idField.setPrefSize(100, 40);
      
      textfield= new TextField(); 
      textfield.setPrefSize(300,40); 
      textfield.setOnAction(e -> {
    	  String msg = idField.getText() + " : " + textfield.getText();	// id : text
    	  pr.println(msg);
    	  pr.flush();	// 전송
    	  
    	  if (textfield.getText().equals("/exit")) {
    		  textarea.appendText("서버와의 연결을 종료합니다."); 
    		  textfield.setDisable(true);	// textfield 사용 불가
    	  } else {
    		  try {
				String serverMsg = br.readLine();
				textarea.appendText(serverMsg + "\n");
			} catch (Exception e2) {
				// TODO: handle exception
			}
    	  }
    	  
    	  
      }); //입력상자에 글 입력 후 enter 입력하면 이벤트 처리
      
      FlowPane flowPane = new FlowPane(); 
      flowPane.setPadding(new Insets(10, 10, 10, 10)); //여백 주기 
      flowPane.setPrefSize(700,40); 
      flowPane.setHgap(10);
      flowPane.getChildren().add(connBtn);	// 버튼 부착
      flowPane.getChildren().add(idField);	// id 필드 부착
      flowPane.getChildren().add(textfield);
      
      root.setBottom(flowPane);
      
      Scene scene = new Scene(root); 
      primaryStage.setScene(scene);
      primaryStage.show(); 
      
   }
   
   public static void main(String[] args) {
      launch(); 
   }
}