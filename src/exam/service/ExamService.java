package exam.service;


import dn.exam.model.ExamModel;
import exam.repository.ExamRepository;
import java.util.*;
public class ExamService {
   ExamRepository examRepo=new ExamRepository(); 
   public int isAddExam(ExamModel model) {
	   return(examRepo.isExamPresent(model.getName()))?-1:(examRepo.isAddExam(model))?1:0;
   }
   public List<ExamModel> getAllExams(){
	   return examRepo.getAllExams();
   }
   public ExamModel getExamIdByName(String name) {
	   return examRepo.getExamIdByName(name);
   }
}
