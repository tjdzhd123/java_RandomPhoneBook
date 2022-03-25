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
		System.out.print("�� �ο��� ->");
		 ObjectCount = scan.nextInt();
		//��ü �迭 ����
		PhoneInfo[] pio = new PhoneInfo[ObjectCount];
		boolean flag = false;
		//��ȭ��ȣ�θ޴�
		while(!flag) {
			System.out.print("1. ����");
			System.out.print("\t 2. ���");
			System.out.println("\t 3. �˻�");
			System.out.print("4. ����");
			System.out.print(" \t 5. ����");
			System.out.println("\t 6. ����");
			System.out.print("��ȣ ���� >>");
			int num = scan.nextInt();
			
			switch(num){
			case 1 : SaveInfo(pio, ObjectCount); break;
			case 2 : PrintInfo(pio, ObjectCount); break;
			case 3 : SearchInfo(pio); break;
			case 4 : RemoveInfo(pio); break;
			case 5 : SortInfo(pio); break;
			case 6 : flag = true; System.out.println("�����մϴ�."); break;
			default :
			}	
		}
	}
	//���������Է��Լ�
	private static void SaveInfo(PhoneInfo[] pio, int ObjectCount) {
			Random random = new Random();
			for(int i = 0; i < ObjectCount; i++) {
				String name = randomHangulName();
				String hp =  "010-"+(random.nextInt(8999)+1000)+"-"+(random.nextInt(8999)+1000);
				String birth = (random.nextInt(46)+54)+"��"+(random.nextInt(10)+1)+"��"+(random.nextInt(10)+1)+"��";
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
			System.out.println("���� �Ϸ�");
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
	
	//����Լ�
	private static void PrintInfo(PhoneInfo[] pio, int ObjectCount) {
		for(int i = 0;i < ObjectCount; i++) {
			System.out.println(pio[i]);
		}
	}
	//�˻��Լ�
	private static void SearchInfo(PhoneInfo[] pio) {
		System.out.print("ã���� �ϴ� ��ȣ �Է� 010-0000-0000 >>");
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
		if(!flag) System.out.println("ã���� �ϴ� ��ȣ�� �����ϴ�.");
	}
	//�����Լ�
	private static void SortInfo(PhoneInfo[] pio) {
		
		Arrays.sort(pio);
		
		for(PhoneInfo data: pio) {
			System.out.println(data);
		}
	}
	//�����Լ�
	private static void RemoveInfo(PhoneInfo[] pio) {
		System.out.print("�����ϰ��� �� �̸� �Է� >>");
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
        List<String> name = Arrays.asList("��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "Ȳ", "��",
            "��", "��", "��", "ȫ", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��",
            "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "ä", "��", "õ", "��", "��", "��", "��", "��", "��", "��", "��",
            "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "ǥ", "��", "��", "��", "��", "��",
            "��", "��", "��", "��", "��", "��", "��", "��", "Ź", "��", "��", "��", "��", "��", "��", "��", "��");
        Collections.shuffle(name);
        return name.get(0) + name.get(1) + name.get(2);
    }
	
	public static String randomJob() {
		List<String> job = Arrays.asList("���м�����","��ȸ������","���������","����������","�������","�������"
				,"�ǻ�","���ǻ�","����","�˻�","�ǻ�","���л�","���п���","ȸ���","�̿��");
		Collections.shuffle(job);
		return job.get(0);
	}
	public static String randomGender() {
		List<String> gender = Arrays.asList("��","��");
		Collections.shuffle(gender);
		return gender.get(0);
	}
}
