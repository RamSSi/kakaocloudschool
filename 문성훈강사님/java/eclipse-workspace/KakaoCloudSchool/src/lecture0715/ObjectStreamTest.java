package lecture0715;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

public class ObjectStreamTest {

	public static void main(String[] args) {
		Map<String, String> map = new HashMap<String, String>();
		
		map.put("1", "홍길동");
		map.put("2", "아이유");
		map.put("3", "김연아");

		File file = new File("C:/Users/user/Desktop/readme.txt");
		FileOutputStream fos = null;
		
		try {
			fos = new FileOutputStream(file);	// 경로에 file이 없으면 생성 후 stream이 생성됨
			// FileOutputStream()은 객체 자체를 보낼 수 있는 능력은 없음 (HashMap 객체를 전달해줄 메소드가 필요)
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(map);	// 객체를 파일에 write
			
			// 모두 write한 후 stream을 close() 해주어야 하는데
			// 이때 나중에 만들어진 stream을 먼저 close 한다.
			oos.close();
			fos.close();
			
			// 메모장을 열면 알아볼 수 없는 형식으로 저장된다. 
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
