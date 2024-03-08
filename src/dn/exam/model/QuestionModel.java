package dn.exam.model;

public class QuestionModel {
private String Question,Op1,Op2,Op3,Op4;
private int Ans;

public QuestionModel() {
	
}
public QuestionModel(String Question,String Op1,String Op2,String Op3,String Op4,int Ans ){
	this.Question=Question;
	this.Op1=Op1;
	this.Op2=Op2;
	this.Op3=Op3;
	this.Op4=Op4;
	this.Ans=Ans;
}
public String getQuestion() {
	return Question;
}
public void setQuestion(String question) {
	Question = question;
}
public String getOp1() {
	return Op1;
}
public void setOp1(String op1) {
	Op1 = op1;
}
public String getOp2() {
	return Op2;
}
public void setOp2(String op2) {
	Op2 = op2;
}
public String getOp3() {
	return Op3;
}
public void setOp3(String op3) {
	Op3 = op3;
}
public String getOp4() {
	return Op4;
}
public void setOp4(String op4) {
	Op4 = op4;
}
public int getAns() {
	return Ans;
}
public void setAns(int ans) {
	Ans = ans;
}

}
