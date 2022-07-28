package view;

import java.util.ArrayList;
import java.util.Scanner;

import controller.StudentManageController;
import dto.StudentDTO;
import util.Constant;

public class StudentManageView implements View{

	@Override
	public void showView() {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);

		while(true) {

			System.out.println("*****************************************************");
			System.out.println("******************1. 학생 전체 조회*********************");
			System.out.println("******************2. 학생 검색 조회*********************");
			System.out.println("******************3. 학생 신규 추가*********************");
			System.out.println("******************4. 학생 수정*************************");
			System.out.println("******************5. 학생 삭제*************************");
			System.out.println("******************6. 학생 성적 조회*********************");
			System.out.println("******************7. 학생 성적 입력*********************");
			System.out.println("******************8. 학생 성적 수정*********************");
			System.out.println("******************9. 학생 성적 삭제*********************");
			System.out.println("******************10. 프로그램 종료*********************");
			System.out.println("*****************************************************");
			System.out.println("메뉴 선택 : ");

			int menuNumber = scanner.nextInt();


			if(this.menuHandling(menuNumber)) {
				break;
			}



		}
	}

	@Override
	public boolean menuHandling(int menuNumber) {
		// TODO Auto-generated method stub

		boolean isMenuExit = false;
		switch(menuNumber) {
		case Constant.SELECT_ALL_STUDENT :
			System.out.println("학생 전체 조회");
			StudentManageView.selectAllStudent();
			break;
		case Constant.SEARCH_STUDENT :
			System.out.println("학생 검색 조회");
			StudentManageView.searchStudent();
			break;
		case Constant.INSERT_STUDENT :
			System.out.println("학생 추가 입력");
			StudentManageView.insertStudent();
			break;
		case Constant.UPDATE_STUDENT :
			System.out.println("학생 수정");
			StudentManageView.updateStudent();
			break;
		case Constant.DELETE_STUDENT :
			System.out.println("학생 삭제");
			StudentManageView.deleteStudent();
			break;
		case Constant.SHOW_STUDENT_SCORE :
			System.out.println("학생 성적 조회");
			StudentManageView.showStudentScore();
			break;
		case Constant.INSERT_STUDENT_SCORE :
			System.out.println("학생 성적 입력");
			StudentManageView.insertStudentScore();
			break;
		case Constant.UPDATE_STUDENT_SCORE :
			System.out.println("학생 성적 수정");
			//			StudentManageView.updateStudentScore();
			break;
		case Constant.DELETE_STUDENT_SCORE :
			System.out.println("학생 성적 삭제");
			//			StudentManageView.deleteStudentScore();
			break;
		case Constant.CLOSE_PROGRAM :
			isMenuExit = true;

			break;
		default :
			wrongMenuSelected();
			break;
		}

		return isMenuExit;
	}

	public static void insertStudent() {
		Scanner scanner = new Scanner(System.in);
		//studentDTO라는 인스턴스에 아래를 저장해라
		StudentDTO studentDTO = new StudentDTO();


		//		System.out.println("학번 입력 : ");
		//		String setStudentId = scanner.next();
		//		studentDTO.setStudentId(setStudentId);

		//값을 입력할 때마다 학번이 추가

		System.out.println("이름 입력 : ");
		String setName = scanner.next();
		studentDTO.setName(setName);

		System.out.println("학년 입력 : ");
		int setGrade = scanner.nextInt();
		studentDTO.setGrade(setGrade);

		System.out.println("생일 입력 : ");
		int setBirthday = scanner.nextInt();
		studentDTO.setBirthday(setBirthday);

		//		studentDTO.printStudentinfo();
		//컨트롤러로 위임한다.
		StudentManageController.insertStudent(studentDTO);

	}



	public static void selectAllStudent() {
		System.out.println("----------------모든 학생 조회---------------");
		ArrayList<StudentDTO> studentManageList = StudentManageController.selectAllStudent();
		for(int i = 0 ; i < studentManageList.size(); i++ ) {
			studentManageList.get(i).printStudentinfo();
		}
	}

	public static void searchStudent() {
		System.out.println("-------------------학생  검색----------------");
		System.out.println("찾고자 하는 학생 입력 : ");
		Scanner scanner = new Scanner(System.in);
		String findStudentName = scanner.next();
		StudentDTO studentDTO = StudentManageController.searchStudent(findStudentName);

		if(studentDTO.getName() != null) {
			studentDTO.printStudentinfo();
		}
		else {
			System.out.println("일치하는 학생이 없습니다.");
		}
	}

	public static void updateStudent() {
		Scanner scanner = new Scanner(System.in);
		StudentDTO updateinfo = new StudentDTO();
		System.out.println("-----------------학생 수정-----------------");
		System.out.println("찾고자 하는 학생 입력 : ");
		String findStudentName = scanner.next();

		StudentDTO temp = StudentManageController.searchStudent(findStudentName);
		if(temp.getName() != null) {
			System.out.println("수정할 이름 입력 : ");
			updateinfo.setName(scanner.next());
			System.out.println("수정할 학년 입력 : ");
			updateinfo.setGrade(scanner.next());
			System.out.println("수정할 생일 입력 : ");
			updateinfo.setBirthday(scanner.next());

			StudentDTO studentDTO = StudentManageController.updateStudent(findStudentName, updateinfo);
			studentDTO.printStudentinfo();
		}
		else {
			System.out.println("일치하는 학생이 없습니다.");
		}

	}


	public static void deleteStudent() {
		System.out.println("-----------------학생 삭제-----------------");
		System.out.println("삭제할 학생 이름 입력 : ");
		Scanner scanner = new Scanner(System.in);
		String findStudentName = scanner.next();

		StudentDTO studentDTO = StudentManageController.deleteStudent(findStudentName);

		if(studentDTO.getName() != null) {
			System.out.println("정상적으로 삭제되었습니다. ");

		}
		else {
			System.out.println("일치하는 학생이 없습니다. ");
		}
	}


	public static void insertStudentScore() {
		Scanner scanner = new Scanner(System.in);
		StudentDTO studentDTO = new StudentDTO();

		System.out.println("학번 입력 : ");
		String studentId = scanner.next();
		studentDTO.setStudentId(studentId); // 학번을 입력하는 것

		System.out.println("국어 성적 입력 :");
		String koreanScore = scanner.next();
		studentDTO.setKoreanScore(koreanScore);

		System.out.println("영어 성적 입력 :");
		String englishScore = scanner.next();
		studentDTO.setEnglishScore(englishScore);

		System.out.println("수학 성적 입력 :");
		String mathScore = scanner.next();
		studentDTO.setMathScore(mathScore);

		System.out.println("과학 성적 입력 :");
		String scienceScore = scanner.next();
		studentDTO.setScienceScore(scienceScore);

		studentDTO.printStudentinfo();
		StudentManageController.insertStudentScore(studentDTO);

	}
	public static void showStudentScore() {
		System.out.println("조회 대상 이름 입력 : ");
		System.out.println("조회한 " + findStudentName + "의 성적은 다음과 같습니다.");
	}
	
	


}
