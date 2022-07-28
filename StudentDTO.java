package dto;

public class StudentDTO {
	private int studentId;
	private String name;
	private int grade;
	private int birthday;
	
//	
//	public StudentDTO() {
//		grade = 0;
//		name = null;
//		birthday = 0;
//		
//	}
	private String koreanScore;
	private String englishScore;
	private String mathScore;
	private String scienceScore;
	
	
	public int getStudentid() {
		return studentId;
	}
	
	public void setStudentId(int studentId) {
	      this.studentId = studentId;
	}


	public void setStudentId(String studentId) {
		this.studentId = Integer.parseInt(studentId);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}
	 
	public void setGrade(String grade) {
	      this.grade = Integer.parseInt(grade);
   }

	public int getBirthday() {
		return birthday;
	}

	public void setBirthday(int birthday) {
		this.birthday = birthday;
	}
	
	 public void setBirthday(String birthday) {
	      this.birthday = Integer.parseInt(birthday);
	   }

	 public void printStudentinfo() {
		 System.out.println(studentId + "," + name + "," + grade + "," + birthday);
	 }
	 
	 public String getKoreanScore() {
			return koreanScore;
		}
	 
	public void setKoreanScore(String koreanScore) {
		// TODO Auto-generated method stub
		this.koreanScore = koreanScore;
	}

	public String getEnglishScore() {
		return englishScore;
	}
	
	public void setEnglishScore(String englishScore) {
		// TODO Auto-generated method stub
		this.englishScore = englishScore;
	}

	public String getMathScore() {
		return mathScore;
	}
	
	public void setMathScore(String mathScore) {
		// TODO Auto-generated method stub
		this.mathScore = mathScore;
	}
	
	public String getScienceScore() {
		return scienceScore;
	}
	
	public void setScienceScore(String scienceScore) {
		// TODO Auto-generated method stub
		this.scienceScore = scienceScore;
	}
	
	
	
	
	
}
