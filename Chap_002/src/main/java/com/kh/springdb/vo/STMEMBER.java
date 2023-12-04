package com.kh.springdb.vo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name="STUDENT_MEMBER")
public class STMEMBER {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="st_Seq")
	@SequenceGenerator(name="st_Seq", sequenceName="st_Seq", allocationSize=1)
	private Long STNumber;
	private String memberName;
	private int koreanScore;
	private int englishScore;
	private int mathScore;
	
}
