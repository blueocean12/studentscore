package db;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;
import com.opencsv.exceptions.CsvValidationException;

import dto.StudentDTO;
import util.Constant;

public class StudentManageDB {

	public static void insertStudent(StudentDTO student) {
		CSVWriter writer;
		
		try {
			CSVReader reader = new CSVReader (new FileReader(Constant.STUDENTINFO_FILE_PATH));
			List<String[]> csvBody = reader.readAll();
			
			if(csvBody.size() != 0 ) {
				int lastIndex = Integer.parseInt(csvBody.get(csvBody.size()-1)[0]);
//				System.out.println(lastIndex);
				student.setStudentId(lastIndex +1 );
			}
//			student.printStudentinfo();
			
			writer = new CSVWriter(new FileWriter(Constant.STUDENTINFO_FILE_PATH, true));
			String lineArr[] = {student.getName(), String.valueOf(student.getGrade()), String.valueOf(student.getBirthday())};
			writer.writeNext(lineArr);
			writer.close();

		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (CsvValidationException e) {
			e.printStackTrace();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		catch (CsvException e) {
			e.printStackTrace();
		}
		
		
		


//		return result;
		

		

	}

	public static ArrayList<StudentDTO> selectAllStudent() {
		ArrayList<StudentDTO> studentManageList = new ArrayList<>();

		try {
			CSVReader reader = new CSVReader(new FileReader(Constant.STUDENTINFO_FILE_PATH));
			String[] nextLine;

			while((nextLine = reader.readNext()) != null) {
				StudentDTO tempStudent = new StudentDTO();
				tempStudent.setStudentId(nextLine[0]);
				tempStudent.setName(nextLine[1]);
				tempStudent.setGrade(nextLine[2]);
				tempStudent.setBirthday(nextLine[3]);
				studentManageList.add(tempStudent);
				
				//아이디, 이름, 학년, 생일

			}
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (CsvValidationException e) {
			e.printStackTrace();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}

		return studentManageList;


	}

	public static StudentDTO searchStudent(String findStudentName) {
		StudentDTO student = new StudentDTO();
		
		try {
			CSVReader reader = new CSVReader(new FileReader(Constant.STUDENTINFO_FILE_PATH));
			String[] nextLine;
			
			while((nextLine = reader.readNext()) != null) {
				if(nextLine[1].compareTo(findStudentName) == 0) {
					student.setStudentId(nextLine[0]);
					student.setName(nextLine[1]);
					student.setGrade(nextLine[2]);
					student.setBirthday(nextLine[3]);
					break;
					//아이디, 이름, 학년, 생일
				}
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (CsvValidationException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
		return student;
	}

	public static StudentDTO updateStudent(String findStudentName, StudentDTO updateinfo) {
		
		StudentDTO result = new StudentDTO();
		
		try {
			CSVReader reader = new CSVReader(new FileReader(Constant.STUDENTINFO_FILE_PATH));
			
			List<String[]> csvBody = reader.readAll();
			for(int i = 0 ; i<csvBody.size();i++) {
				if(csvBody.get(i)[1].compareTo(findStudentName) == 0 ) {
					csvBody.get(i)[1] = updateinfo.getName();
					csvBody.get(i)[2] = String.valueOf(updateinfo.getGrade());
					csvBody.get(i)[3] = String.valueOf(updateinfo.getBirthday());
					
					result.setName(updateinfo.getName());
					result.setGrade(updateinfo.getGrade());
					result.setBirthday(updateinfo.getBirthday());
					break;
				}
			}
			CSVWriter writer = new CSVWriter(new FileWriter(Constant.STUDENTINFO_FILE_PATH));
			writer.writeAll(csvBody);
			writer.flush();
			writer.close();
			
			
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (CsvValidationException e) {
			e.printStackTrace();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		catch (CsvException e) {
			e.printStackTrace();
		}
		
		
		
		return result;
	}

	public static StudentDTO deleteStudent(String findStudentName) {
		
		StudentDTO result = new StudentDTO();
		
		try {
			CSVReader reader = new CSVReader ( new FileReader(Constant.STUDENTINFO_FILE_PATH));
			
			List<String[]> csvBody = reader.readAll();
			for(int i = 0 ; i <csvBody.size(); i++) {
				if(csvBody.get(i)[1].compareTo(findStudentName) == 0 ) {
					
					result.setName(csvBody.get(i)[1]);
					result.setGrade(csvBody.get(i)[2]);
					result.setBirthday(csvBody.get(i)[3]);
					
					csvBody.remove(i);
					break;
					
				}
			}
			CSVWriter writer = new CSVWriter(new FileWriter(Constant.STUDENTINFO_FILE_PATH));
			writer.writeAll(csvBody);
			writer.flush();
			writer.close();
			
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (CsvValidationException e) {
			e.printStackTrace();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		catch (CsvException e) {
			e.printStackTrace();
		}


		return result;
		
	}

	public static void insertStudentScore(StudentDTO studentDTO) {
		// TODO Auto-generated method stub
		CSVWriter writer;
		try {
			 writer = new CSVWriter(new FileWriter(Constant.STUDENTINFO_SCORE_FILE_PATH, true));
			String lineArr[] = {String.valueOf(studentDTO.getStudentid()), studentDTO.getKoreanScore(), studentDTO.getEnglishScore(), studentDTO.getMathScore(), studentDTO.getScienceScore()};
			writer.writeNext(lineArr);
			writer.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
//		return null;
	}
	
	public static StudentDTO showStudentScore(String findStudentName) {
		StudentDTO student = new StudentDTO();
		
		try {
			CSVReader reader = new CSVReader(new FileReader(Constant.STUDENTINFO_SCORE_FILE_PATH))
		}
		
		
	}
	
}
