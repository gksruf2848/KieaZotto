package org.tain.jpa.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "tbl_word")
@Data
public class TblWord {

	@Id
	private Long id;
	
	private String code;
	
	private String word;
	
	private String meaning;
}
