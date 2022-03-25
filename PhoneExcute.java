package com.mire.phoneinfo.test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


public class PhoneExcute {
	
	public static int ObjectCount = 0;
	public static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		System.out.print("총 인원수 ->");
		 ObjectCount = scan.nextInt();
		//객체 배열 생성
		PhoneInfo[] pio = new PhoneInfo[ObjectCount];
		boolean flag = false;
		//전화번호부메뉴
		while(!flag) {
			System.out.print("1. 저장");
			System.out.print("\t 2. 출력");
			System.out.println("\t 3. 검색");
			System.out.print("4. 삭제");
			System.out.print(" \t 5. 정렬");
			System.out.println("\t 6. 종료");
			System.out.print("번호 선택 >>");
			int num = scan.nextInt();
			
			switch(num){
			case 1 : SaveInfo(pio, ObjectCount); break;
			case 2 : PrintInfo(pio, ObjectCount); break;
			case 3 : SearchInfo(pio); break;
			case 4 : RemoveInfo(pio); break;
			case 5 : SortInfo(pio); break;
			case 6 : flag = true; System.out.println("종료합니다."); break;
			default :
			}	
		}
	}
	//랜덤정보입력함수
	private static void SaveInfo(PhoneInfo[] pio, int ObjectCount) {
			Random random = new Random();
			for(int i = 0; i < ObjectCount; i++) {
				String name = randomHangulName();
				String hp =  "010-"+(random.nextInt(8999)+1000)+"-"+(random.nextInt(8999)+1000);
				String birth = (random.nextInt(46)+54)+"년"+(random.nextInt(10)+1)+"월"+(random.nextInt(10)+1)+"일";
				int age = 	random.nextInt(15)+5;
				String gender = randomGender();
				String job = randomJob();
				int num = random.nextInt(100)+50;
				PhoneInfo data = new PhoneInfo(name, hp, birth, age, gender, job, num);
				
				boolean flag = false;
				flag = findHpInArray(pio, data);
				if(flag) {
					i--;
					continue;
				}
				pio[i] = data;
			}
			System.out.println("저장 완료");
	}
	
	private static boolean findHpInArray(PhoneInfo[] pio, PhoneInfo CompData) {
		boolean flag = false;
		for(PhoneInfo data: pio) {
			if(data != null) {
				flag = data.equals(CompData);
				if(flag) break;
			}
		}
		return flag;
	}
	
	//출력함수
	private static void PrintInfo(PhoneInfo[] pio, int ObjectCount) {
		for(int i = 0;i < ObjectCount; i++) {
			System.out.println(pio[i]);
		}
	}
	//검색함수
	private static void SearchInfo(PhoneInfo[] pio) {
		System.out.print("찾고자 하는 번호 입력 010-0000-0000 >>");
		scan.nextLine();
		String hp = scan.nextLine();
		
		boolean flag = false;
		for(PhoneInfo data : pio) {
			if(data != null) {
				flag = data.getHp().equals(hp);
				if(flag) {
					System.out.println(data);
					break;
				}
			}
		}
		if(!flag) System.out.println("찾고자 하는 번호가 없습니다.");
	}
	//정렬함수
	private static void SortInfo(PhoneInfo[] pio) {
		
		Arrays.sort(pio);
		
		for(PhoneInfo data: pio) {
			System.out.println(data);
		}
	}
	//삭제함수
	private static void RemoveInfo(PhoneInfo[] pio) {
		System.out.print("삭제하고자 할 이름 입력 >>");
		scan.nextLine();
		String name = scan.nextLine();
		boolean flag = false;
		for(int i = 0; i< PhoneExcute.ObjectCount; i++) {
			flag = name.equals(pio[i].getName());
			if(flag) {
				for(int j= i;j <PhoneExcute.ObjectCount-1; j++) {
					pio[j] = pio[j+1];
				}
				PhoneExcute.ObjectCount--;
				break;
			}
		}	
	}
	
	public static String randomHangulName() {
        List<String> name = Arrays.asList("김", "이", "박", "최", "정", "강", "조", "윤", "장", "임", "한", "오", "서", "신", "권", "황", "안",
            "송", "류", "전", "홍", "고", "문", "양", "손", "배", "조", "백", "허", "유", "남", "심", "노", "정", "하", "곽", "성", "차", "주",
            "우", "구", "신", "임", "나", "전", "민", "유", "진", "지", "엄", "채", "원", "천", "방", "공", "강", "현", "함", "변", "염", "양",
            "변", "여", "추", "노", "도", "소", "신", "석", "선", "설", "마", "길", "주", "연", "방", "위", "표", "명", "기", "반", "왕", "금",
            "옥", "육", "인", "맹", "제", "모", "장", "남", "탁", "국", "여", "진", "어", "은", "편", "구", "용");
        Collections.shuffle(name);
        return name.get(0) + name.get(1) + name.get(2);
    }
	
	public static String randomJob() {
		List<String> job = Arrays.asList("수학선생님","사회선생님","기술선생님","가정선생님","국어선생님","영어선생님"
				,"의사","수의사","경찰","검사","판사","대학생","대학원생","회사원","미용사");
		Collections.shuffle(job);
		return job.get(0);
	}
	public static String randomGender() {
		List<String> gender = Arrays.asList("남","여");
		Collections.shuffle(gender);
		return gender.get(0);
	}
}
