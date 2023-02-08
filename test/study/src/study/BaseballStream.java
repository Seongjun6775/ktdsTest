package study;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BaseballStream {

	public static List<ASFVO> readASF() {

		try {
			List<ASFVO> list = Files.readAllLines(Paths.get("C:\\Devs\\data\\baseball\\core\\AllstarFull.csv"))
									.stream()
									.skip(1)
									.map((line) -> {
										String[] strArr = line.split(",");
										ASFVO asfVO = new ASFVO();
										asfVO.setPlayerID(strArr[0]);
										asfVO.setYear(strArr[1]);
										asfVO.setGameNum(Integer.parseInt(strArr[2]));
										asfVO.setGameID(strArr[3]);
										asfVO.setTeamID(strArr[4]);
										asfVO.setLgID(strArr[5]);
										asfVO.setGp(Integer.parseInt(strArr[6]));
										if (strArr.length == 8) {
											asfVO.setStartingPos(Integer.parseInt(strArr[7]));
										} else {
											asfVO.setStartingPos(0);
										}
										return asfVO;
									})
									.collect(Collectors.toList());
			return list;
		} catch (IOException ioe) {
			ioe.printStackTrace();
			return new ArrayList<>();
		}
	}

	public static void main(String[] args) {
		//파일 읽어와 가공후 List형태로 list에 저장
		List<ASFVO> list = readASF();
		
		//
		list.stream()
			.filter( (vo) -> vo.getYear().equals("1933"))
			.forEach( vo -> {
				System.out.println(vo.getPlayerID() + "\t" + vo.getYear());
			});
		//
		System.out.println("---------------------");
		List<ASFVO> playIn1993 = list.stream()
									.filter( vo -> vo.getYear().equals("1993"))
									.collect(Collectors.toList());
		playIn1993.forEach( vo ->{
			System.out.println(vo.getPlayerID());
		});
		//
		System.out.println("---------------------");
		ASFVO asfvo = list.stream()
						.filter( vo -> vo.getYear().equals("1993"))
						.findFirst()
						.orElse(new ASFVO());
		System.out.println(asfvo.getPlayerID());
		//
		System.out.println("---------------------");
		list.stream()
			.filter( vo -> vo.getPlayerID().toUpperCase().startsWith("F"))
			.forEach( vo -> {
				System.out.println(vo.getPlayerID());
			});
		//
		System.out.println("---------------------");
		list.stream()
			.filter( vo -> vo.getYear().equals("2004"))
			.filter( vo -> vo.getTeamID().equals("TEX"))
			.forEach( vo ->{
				System.out.println(vo.getPlayerID());
				System.out.println(vo.getYear());
				System.out.println(vo.getTeamID());
			});
		//
		System.out.println("---------------------");
		list.stream()
			.filter( vo -> vo.getStartingPos() == 0)
			.forEach( vo -> {
				System.out.println(vo.getPlayerID());
				System.out.println(vo.getYear());
			});
		//
		System.out.println("---------------------");
		list.stream()
			.filter( vo -> vo.getGp() == 0)
			.filter( vo -> vo.getTeamID().equals("NYA") )
			.filter( vo -> vo.getPlayerID().toUpperCase().contains("FO"))
			.forEach( vo ->{
				System.out.println(vo.getPlayerID());
				System.out.println(vo.getYear());
			});
		//
		System.out.println("---------------------");
		List<String> playerNameList = list.stream()
										.map( vo -> vo.getPlayerID())
										.distinct()
										.sorted()
										.collect(Collectors.toList());
		playerNameList.forEach(System.out::println);
		//
		System.out.println("---------------------");
		List<String> playerIDList = list.stream()
										.filter( vo -> vo.getStartingPos() == 4)
										.map( vo -> vo.getPlayerID())
										.distinct()
										.sorted()
										.collect(Collectors.toList());
		playerIDList.forEach(System.out::println);
		//1. gameNum 이 0이 아닌 것을 추출해 출력하세요.
		System.out.println("----------1번---------");
		List<ASFVO> gameNum = list.stream()
								.filter( vo -> vo.getGameNum() != 0)
								.collect(Collectors.toList());
		gameNum.forEach( vo ->{
			System.out.println(vo.getPlayerID());
		});
		//2. gameNum 이 0 인 것만 추출해 출력하기
		System.out.println("----------2번---------");
		List<ASFVO> isZeroNum = list.stream()
									.filter( vo -> vo.getGameNum() == 0)
									.collect(Collectors.toList());
		isZeroNum.forEach( vo -> {
			System.out.println(vo.getPlayerID());
		});
		//3. 1950년대에 플레이한 선수의 이름만 출력하세요
		System.out.println("----------3번---------");
		list.stream()
			.filter( vo -> vo.getYear().startsWith("195"))
			.forEach( vo -> {
				System.out.println(vo.getYear()+"\t"+vo.getPlayerID());
			});
		//4. 2000년대 BOS 팀의 선수 이름을 중복 제거한 후 출력하세요
		System.out.println("----------4번---------");
		list.stream()
			.filter( vo -> vo.getYear().startsWith("200"))
			.filter( vo -> vo.getTeamID().equals("BOS"))
			.map( vo -> vo.getPlayerID())
			.distinct()
			.forEach(System.out::println);
		//5. 1937년 DET 팀의 선수 중 첫 번째 선수 이름을 출력하세요.
		System.out.println("----------5번---------");
		ASFVO playerName = list.stream()
								.filter( vo -> vo.getYear().equals("1937"))
								.filter( vo -> vo.getTeamID().equals("DET"))
								.findFirst()
								.orElse(new ASFVO());
		System.out.println(playerName.getPlayerID());
		
		
		
		}

}
