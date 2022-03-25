package com.mire.phoneinfo.test;

public class PhoneInfo implements Comparable {
	//�ν��Ͻ��������
	private String name;
	private String hp;
	private String birth;
	private int age;
	private String gender;
	private String job;
	private int num;

	//������
	public PhoneInfo() {
		this(null, null, null, 0, null, null, 0);
	}
	
	
	public PhoneInfo(String name, String hp, String birth, int age, String gender, String job, int num){
		super();
		this.name = name;
		this.hp = hp;
		this.birth = birth;
		this.age = age;
		this.gender = gender;
		this.job = job;
		this.num = num;
	}

	//����,����
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getHp() {
		return hp;
	}


	public void setHp(String hp) {
		this.hp = hp;
	}


	public String getBirth() {
		return birth;
	}


	public void setBirth(String birth) {
		this.birth = birth;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getJob() {
		return job;
	}


	public void setJob(String job) {
		this.job = job;
	}

	public int getNum() {
		return num;
	}


	public void setNum(int num) {
		this.num = num;
	}

	//hash, equals
	@Override
	public int hashCode() {

		return hp.hashCode();
	}


	@Override
	public boolean equals(Object object) {
		boolean flag = false;
		
		if(object instanceof PhoneInfo) {
			PhoneInfo pio = (PhoneInfo)object;
			flag = this.hp.equals(pio.hp);
		}
		return flag;
		
	}
	
	//toString
	@Override
	public String toString() {
		return name + "\t" + hp + "\t" + birth + "\t" + age + "\t" + gender + "\t"
				+ job + "\t" + "\t" + "������ȣ:" + num + "\t";
	}


	@Override
	public int compareTo(Object object) {
		if(!(object instanceof PhoneInfo)) {
			   throw new IllegalArgumentException("�񱳰� �ȵǴ� ��ü�Դϴ�.");
		   }
		  PhoneInfo phoneInfo =(PhoneInfo)object;
		   
		   if(this.num < phoneInfo.num ) {
			   return -1;
		   }else if(this.num > phoneInfo.num) {
			   return 1;
		   }else {
			   return 0;
		   }
	}
}
