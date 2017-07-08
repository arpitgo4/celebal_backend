package com.eze.ai.api.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Result {
@Id
@GeneratedValue (strategy = GenerationType.IDENTITY)
private String result="Success";

public String getResult() {
	return result;
}

public void setResult(String result) {
	this.result = result;
}

public String toString(){
	return "Result [result="+result+"]";
}


}
