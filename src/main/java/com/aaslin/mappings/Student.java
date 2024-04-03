package com.aaslin.mappings;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
@Entity
public class Student {
		@Id
		private int sid;
		private String sname;
		@ManyToMany
		@JoinTable(name="student_teach")
		private List<Teacher>teachers;
		
		public List<Teacher> getTeachers() {
			return teachers;
		}
		public void setTeachers(List<Teacher> teachers) {
			this.teachers = teachers;
		}
		public int getSid() {
			return sid;
		}
		public void setSid(int sid) {
			this.sid = sid;
		}
		public String getSname() {
			return sname;
		}
		public void setSname(String sname) {
			this.sname = sname;
		}
}
