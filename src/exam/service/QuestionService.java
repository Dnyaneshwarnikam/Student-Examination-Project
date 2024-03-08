package exam.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import dn.exam.model.QuestionModel;
import exam.helper.PathHelper;
import exam.repository.QuestionRepository;

public class QuestionService {
   QuestionRepository qRepo=new QuestionRepository();
   SubjectService ss= new SubjectService();
   public boolean isAddQuestion(QuestionModel qModel,String subName) {
	   return qRepo.isAddQuestion(qModel, subName);
   }
   public boolean createFiles() {
	   try {
		   String path="C:\\Users\\dnyan\\Documents\\questionbank";
		   File f=new File(path);
		   if(!f.exists()) {
			   f.mkdir();
		   }
		   List<String> subList=ss.getAllSubjects();
		   if(subList!=null) {
			   for(String subName:subList) {
//				   System.out.println(subName);
				   
				   f=new File(path+"\\"+subName+".csv");
				   if(!f.exists()) {
					  f.createNewFile(); 
				   } 
			   }
			   
		   }else {
			   System.out.println("Subject Not Found....");
		   }
		   
	   }catch(Exception ex) {
		   System.out.println("Error is:"+ex);
	   }
	   return true;
   }
   public boolean uploadBulkqQuestion(String subName) {
	   boolean b=this.createFiles();
	   if(b)
	   {
		   File f=new File("C:\\Users\\dnyan\\Documents\\questionbank");
		   File []fileList=f.listFiles();
		   boolean flag=false;
		   for(File file:fileList) {
			   if(file.isFile()) {
				int index=file.toString().indexOf(subName);
				if(index!=-1)
				{
					flag=true;
					break;
				}
			  }
		   }
		   if(flag) {
			   try{
			 FileReader fr= new FileReader(PathHelper.filePath+"\\"+subName+".csv");
			 BufferedReader br= new BufferedReader(fr);
			 String question;
			 flag=false;
			 while((question=br.readLine())!=null) {
					 String qwithop[]=question.split(",");
					 flag=qRepo.uploadBulkQuestion(qwithop,subName);
				 }
			} catch (Exception e) {
				
				e.printStackTrace();
			}
		   }
		   else {
			   System.out.println("Subject File Not Found....");
		   }
		   return true;
	   }
	   else 
	   {
		   return false;
		   
	   }
	   
   }
}
