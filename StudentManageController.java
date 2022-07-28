package controller;

import java.util.ArrayList;

import db.StudentManageDB;
import dto.StudentDTO;

public class StudentManageController {

	public static void insertStudent(StudentDTO studentDTO) {
		// TODO Auto-generated method stub
		StudentManageDB.insertStudent(studentDTO);
		
	}

	public static ArrayList<StudentDTO> selectAllStudent() {
		// TODO Auto-generated method stub
		return StudentManageDB.selectAllStudent();
	}

	public static StudentDTO searchStudent(String findStudentName) {
		// TODO Auto-generated method stub
		return StudentManageDB.searchStudent(findStudentName);
	}

	public static StudentDTO updateStudent(String findStudentName, StudentDTO updateinfo) {
		// TODO Auto-generated method stub
		return StudentManageDB.updateStudent(findStudentName, updateinfo);
	}

	public static StudentDTO deleteStudent(String findStudentName) {
		// TODO Auto-generated method stub
		return StudentManageDB.deleteStudent(findStudentName);
	}

	public static void insertStudentScore(StudentDTO studentDTO) {
		// TODO Auto-generated method stub
		StudentManageDB.insertStudentScore(studentDTO);
	}

}
