package exam.client;
import java.util.*;

import dn.exam.model.ExamModel;
import dn.exam.model.QuestionModel;
import dn.exam.model.SubjectModel;
import exam.service.ExamService;
import exam.service.QuestionService;
import exam.service.SubjectService;
public class ExamClientApplication {
public static void main(String[] args) {
	SubjectService sv=new SubjectService();
	QuestionService qService = new QuestionService();
	ExamService examSer = new ExamService();
	do {
		System.out.println("1:Add New Subject:");
		System.out.println("2:Add Single Question:");
		System.out.println("3:Add Bulk Question:");
		System.out.println("4:Add Exam:");
		System.out.println("5:Create Exam Schdule:");
		System.out.println("Enter Your Choice:");
		Scanner sc=new Scanner(System.in);
		int choice=sc.nextInt();
		switch(choice)
		{
		case 1:
			sc.nextLine();
			System.out.println("Enter Subject Name");
			String subname=sc.nextLine();
			SubjectModel model=new SubjectModel();
			model.setName(subname);
			int result=sv.addSubject(model);
			System.out.println((result==1)?"Subject Added Successfully.............":(result==-1)?"Subject Already Present...":"Some Probelms There....");
			break;
		case 2:
			sc.nextLine();
			System.out.println("Enter Question:");
			String question=sc.nextLine();
			System.out.println("Enter Option1:");
			String op1=sc.nextLine();
			System.out.println("Enter Option2:");
			String op2=sc.nextLine();
			System.out.println("Enter Option3:");
			String op3=sc.nextLine();
			System.out.println("Enter Option4:");
			String op4=sc.nextLine();
			System.out.println("Enter Option number As Answer:");
			int ans=sc.nextInt();
			sc.nextLine();
			System.out.println("Enter Subject name:");
			subname=sc.nextLine();
			QuestionModel qModel=new QuestionModel(question,op1,op2,op3,op4,ans);
			boolean b=qService.isAddQuestion(qModel, subname);
			if(b)
			{
				System.out.println("Question Added Successfully........");
			}
			else
			{
				System.out.println("Some Problems There.......");
			}
			break;
		case 3:
			sc.nextLine();
			System.out.println("Enter Subject Name For Store Bulk Question:");
			String subName=sc.nextLine();
			qService.uploadBulkqQuestion(subName);
			
			break;
		case 4:
			sc.nextLine();
			System.out.println("Enter Exam Name:");
			String examname=sc.nextLine();
			System.out.println("Enter Total Marks:");
			int totalMarks=sc.nextInt();
			System.out.println("Enter Passing Marks:");
			int passingMarks=sc.nextInt();
			ExamModel examModel=new ExamModel(examname,totalMarks,passingMarks);
			result=examSer.isAddExam(examModel);
			String st=(result==1)?"Exam Added Successfully....!":(result==-1)?"Exam Already Present..........":"Some Problems There....";
			System.out.println(st);
			break;
		case 5:
			sc.nextLine();
			List<ExamModel> list=examSer.getAllExams();
			System.out.println("Select One For Schdule:");
			for(ExamModel m:list) {
				System.out.println(m.getId()+"\t"+m.getName()+"\t"+m.getTotalMarks()+"\t"+m.getPassingMarks());
			}
			System.out.println("-----------------------------------------------------------------------------------------");
			System.out.println("Enter exam name for schedule:");
			String examName=sc.nextLine();
			ExamModel emodel=examSer.getExamIdByName(examName);
			if(emodel!=null)
			{
			    System.out.println("Enter exam date startTime and endTime:");
			    Date d=new Date();
			}
			else
			{
				System.out.println("Enter Correct Exam Name:");
			}
			break;
			default:
				System.out.println("Wrong Choice....+");
		}
		
	}while(true);
}
}
