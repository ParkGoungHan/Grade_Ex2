package sungjuk;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class SungJukManagerV3 {

	static List<Student> studentList = new ArrayList<Student>();

	static int index = -1;
	

	static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		while(true) {
			printMenu();
			switch(scan.next().charAt(0)) {
			case 'i':
			case 'I':
				getData(); 
				break;
			case 'l':
			case 'L':
				printList();
				break;
			case 's':
			case 'S':
				searchData();
				break;
			case 'u':
			case 'U':
				updateData();
				break;
			case 'd':
			case 'D':
				deleteData();
				break;
			case 'q':
			case 'Q':
				scan.close();
				System.out.println("프로그램을 종료합니다.");
				return;
			}
		}

	}


	private static void deleteData() {

		System.out.print(studentList.get(index).name + "학생의 정보를 삭제하겠습니까?(Y/N) : ");
		if(scan.next().charAt(0) =='Y') {
			studentList.remove(index);

			index = -1;
		}else {
			System.out.println("삭제를 취소합니다.");
		}
	}

	private static void updateData() {
	
		System.out.print("이름(" + studentList.get(index).name + ") : ");
		studentList.get(index).name = scan.next();
		System.out.print("학번(" + studentList.get(index).studentId + ") : ");
		studentList.get(index).studentId = scan.next();
		System.out.print("점수(" + studentList.get(index).jumsu + ") : ");
		studentList.get(index).jumsu = scan.nextInt();
	}

	private static void searchData() {
		System.out.println("찾을 학생의 학번을 입력하세요: ");
		String studentId = scan.next().trim();
		for(int i=0; i<studentList.size(); i++) {
			if(studentList.get(i).studentId.equals(studentId)) {
				index = i;
				break;
			}
		}
		System.out.println("학생 찾기를 종료했습니다.");
		if(index >= 0) {
			System.out.println(studentList.get(index));
		}else {
			System.out.println("검색된 학생 정보가 없습니다.");
		}
	}

	public static void printMenu() {
		System.out.println("메뉴를 선택하세요.======================");
		System.out.print("(I)nsert, (L)ist, (Q)uit, (S)earch, (U)pdate, (D)elete : ");
	}
	public static void getData() {
		System.out.print("이름 : ");
		String name = scan.next();
		System.out.print("학번 : ");
		String studentId = scan.next();
		System.out.print("점수 : ");
		int jumsu = scan.nextInt();
		Student student = new Student(name, studentId, jumsu);

		studentList.add(student);
		System.out.println(studentList.size() + "명 데이터가 존재합니다.");
	}
	public static void printList() {
		System.out.println("==============L I S T==============");
		System.out.println("\t이름 \t학번 \t점수");
		int sum=0;
		for(int i=0; i<studentList.size(); i++) {
			System.out.println(studentList.get(i).toString());
			sum += studentList.get(i).jumsu;
		}
		double avg=sum/(double)studentList.size();
		System.out.println("-----------------------------------");
		System.out.println("\t합계 : " + sum + "\t\t평균 : " + avg);
		System.out.println("===================================");
	}
}
