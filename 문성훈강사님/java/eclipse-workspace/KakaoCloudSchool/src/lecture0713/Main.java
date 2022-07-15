package lecture0713;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Student {
	
}

public class Main {
	public static void main(String[] args) {
		// 배열과 비슷하지만 동적으로 크기를 변화시킬 수 있음
		// 저장은 객체 형태로만 저장됨
		// 다양한 형태의 객체 저장 가능
		List list = new ArrayList<>();
		list.add("Hello");
		list.add("홍길동");
		list.add(100);	
		// 3번째 칸에 숫자(int) 100이 저장된 듯 보이지만
		// 실제로는 new Integer(100)으로 객체화하여 저장되는 것임.
		list.add(new Student());
		
		// List를 만들어 사용
		// 같은 데이터 타입을 저장하는 경우가 대부분이다.
		List<String> list1 = new ArrayList<String>();
		list1.add("홍길동");
//		list1.add(100);	// error
		
		// Map
		Map<String, String> map = new HashMap<String, String>();	// Generic : 데이터 형태를 지정해줌
		map.put("1", "홍길동");
		map.put("2", "Hello");
		
		// API Reference를 참조해서 각 collection의 이용방법을 찾아 써보시오.
	}
}
