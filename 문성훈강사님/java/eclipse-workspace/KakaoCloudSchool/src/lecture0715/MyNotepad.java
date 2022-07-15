package lecture0715;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

//notepad 만들기
//JavaFX를 이용
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;


public class MyNotepad extends Application {

	TextArea textarea;
	Button openBtn, saveBtn;
	File file; 
	
	private void writeMsg(String msg) {
		Platform.runLater(() -> {
			textarea.appendText(msg + "\n");
		});
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// 화면을 구성하는 전체 panel
		BorderPane root = new BorderPane();	// 5개의 layout이 나누어져 있는 panel
		// BorderPane의 크기 (width, height)
		root.setPrefSize(700, 500);
		
		// TextArea 생성
		textarea = new TextArea();
		root.setCenter(textarea);
		
		
		// button 생성
		openBtn = new Button("파일 열기");
		openBtn.setPrefSize(150, 40);
		
		// button의 Event를 발생시킴 -> 인자로 event handler를 전달
		// EventHandler를 람다식으로 간단하게 축약하여 사용할 수 있다.
		
		openBtn.setOnAction(e -> {
			// open 파일을 찾아 그 내용을 textarea에 출력
			textarea.clear();	// textarea 초기화 (새로운 내용을 넣어야 함)
			FileChooser fileChooser = new FileChooser();
			fileChooser.setTitle("파일 선택");
			file = fileChooser.showOpenDialog(primaryStage);
			
			try {
				FileReader fr = new FileReader(file);
				BufferedReader br = new BufferedReader(fr);
				String line = "";
				while((line = br.readLine()) != null) {
					writeMsg(line);
				}	// 통로(stream)를 통해 데이터를 모두 받았다!
				br.close();	// stream을 닫아준다!
			} catch (FileNotFoundException e1) {
				// TODO: handle exception
			} catch (IOException e2) {
				
			}
		});
//		openBtn.setOnAction(new EventHandler<ActionEvent>() {
//			
//			@Override
//			public void handle(ActionEvent arg0) {
//				System.out.println("버튼 누름");
//			}
//		});
		
		
		saveBtn = new Button("파일 저장");
		saveBtn.setPrefSize(150, 40);
		
		saveBtn.setOnAction(e -> {
			String text = textarea.getText();	// 기존 내용 + 수정한 내용
			try {
				FileWriter fw = new FileWriter(file);
				fw.write(text);	// 텍스트를 파일에 쓴다.
				fw.close();	// stream을 닫아준다.
			} catch (Exception e2) {
			}
		});
		
		
		FlowPane flowPane = new FlowPane();
		flowPane.setPadding(new Insets(10, 10, 10, 10));
		flowPane.setColumnHalignment(HPos.CENTER);	// 가운데 정렬
		flowPane.setPrefSize(700, 40);
		flowPane.setHgap(10);	// 간격
		
		// flowPane에 button들을 붙인다!
		flowPane.getChildren().add(openBtn);
		flowPane.getChildren().add(saveBtn);
		
		root.setBottom(flowPane);
		
		// Scene 객체 생성
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("메모장");
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch();	// start() 호출 -> 내부적으로 Thread가 생성되면서 창이 나타남 창의 모든 설정은 start에서 한다.
	}
}
