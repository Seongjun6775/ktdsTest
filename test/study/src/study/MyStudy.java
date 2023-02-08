package study;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MyStudy {
	public static void main(String[] args) {
//		String str = "012, 345, 678";
//		str = str.substring(3);
//		System.out.println(str);
		
		//.subString(start, end)start 인데스 부터 end 까지(end제외)
//		str = str.substring(3,6);
//		System.out.println(str);
		
//		List<String> array = Arrays.asList(str.split(","));
//		for (String word : array) {
//			System.out.println(word.trim());
//		}
		
//		Test test = ((str) -> System.out.println());
//		Test test = ()
//		Test test =(System.out::println);
		
//		test.print("람다식으로 사용");
		 
//		ASFVO asfvo = new ASFVO();
//		asfvo.setPlayerID("test");
//		asfvo.setGameID("test");
//		asfvo.setGameNum(1);
//		asfvo.setGp(5);
//		asfvo.setLgID("test");
//		asfvo.setStartingPos(1);
//		asfvo.setTeamID("test");
//		asfvo.setYear("test");
//		
//		String[] words = new String[3];
//		words[0] = "java";
//		words[1] = "in";
//		words[2] = "action";
		
//		List<String> words = Arrays.asList("")

//		String abc ="  ";
//		boolean is = abc== null;
//		System.out.println(abc.trim().isEmpty());
		
		/*복습 내용*/
//		int math = 80;
//		int physics = 91;
//		int english = 79;
//		int programming = 95;
//		double avg;
//		avg = (math+physics+english+programming)/4.0;
//		System.out.println(avg);
//		
//		int[] scoresArray = new int[4];
//		scoresArray[0] = 51;
//		scoresArray[1] = 754;
//		scoresArray[2] = 426;
//		scoresArray[3] = 1234;
//		
//		int total = scoresArray[0] + scoresArray[1] + scoresArray[2] + scoresArray[3];
//		
//		double[] doubleArray = new double[3];
//		String[] strArray = new String[5];
//		
//		strArray[0] = "adsfb";
//		strArray[1] = "ㅁㄴㅇㅀ";
//		strArray[2] = "ㅏㅑㅏㅓ";
//		strArray[3] = "가나다라";
//		strArray[4] = "안녕하세요";
		
		
		Random random = new Random();
		int randomNumber = random.nextInt(45)+1;
		System.out.println(randomNumber);
		
		List<Integer> lotto = new ArrayList<>();
		lotto.add(random.nextInt(45)+1);
		lotto.add(random.nextInt(45)+1);
		lotto.add(random.nextInt(45)+1);
		lotto.add(random.nextInt(45)+1);
		lotto.add(random.nextInt(45)+1);
		lotto.add(random.nextInt(45)+1);
		
		System.out.println(lotto.get(0));
		System.out.println(lotto.get(1));
		System.out.println(lotto.get(2));
		System.out.println(lotto.get(3));
		System.out.println(lotto.get(4));
		System.out.println(lotto.get(5));
		
//		for (int number : lotto) {
//			System.out.println(number);
//		}
		
		List<Integer> scores = new ArrayList<>();
		scores.add(100);
		scores.add(90);
//		scores.add(97);
//		scores.add(93);
//		
//		int intResult = scores.get(0);
//		System.out.println(intResult);
//		intResult = scores.get(1);
//		System.out.println(intResult);
		
	}

}

