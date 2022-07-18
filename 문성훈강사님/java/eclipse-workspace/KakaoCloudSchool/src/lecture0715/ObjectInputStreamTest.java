package lecture0715;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.ObjectInputStream;
import java.util.HashMap;
import java.util.Map;


public class ObjectInputStreamTest {

	public static void main(String[] args) {

		File file = new File("C:/Users/user/Desktop/readme.txt");
		
		try {
			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			Object obj = ois.readObject();
			// Object로 반환됨 (파일 내에 어떤 객체가 존재하는지 모르기 때문에)
			
			Map<String, String> map = (Map<String, String>)obj;
			
			System.out.println(map.get("2"));
			
			ois.close();
			fis.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
}
