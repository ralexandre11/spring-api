package com.springapi.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Request {
	private Long id;
	private String subject;
	private String description;
	private Date creationDate;
	private RequestStage state;
	private List<RequestStage> stages = new ArrayList<RequestStage>();
	
}
