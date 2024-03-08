package exam.repository;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import dn.exam.model.ExamModel;
import java.sql.*;
public class ExamRepository extends DBConfig {
	List<ExamModel> listExam=new ArrayList<ExamModel>();
    public boolean isExamPresent(String examName) {
    	try {
    		stmt=conn.prepareStatement("select *from exam where ExamName=?");
    		stmt.setString(1, examName);
    		rs=stmt.executeQuery();
    		return rs.next();
    	}catch(Exception ex) {
    		System.out.println("Error is>"+ex);
    		
    	}
		return false;
    }
    public boolean isAddExam(ExamModel model) {
    	try {
    		stmt=conn.prepareStatement("insert into exam values('0',?,?,?)");
    		stmt.setString(1,model.getName());
    		stmt.setInt(2,model.getTotalMarks());
    		stmt.setInt(3,model.getPassingMarks());
    		int value=stmt.executeUpdate();
    		if(value>0)
    		{
    			return true;
    		}
    		else
    		{
    			return false;
    		}
    	}catch(Exception ex) {
    		System.out.println("Error is:"+ex);
    		return false;
    	}
    }
    public List<ExamModel> getAllExams(){
    	try {
    		stmt=conn.prepareStatement("select *from exam");
    		rs=stmt.executeQuery();
    		while(rs.next()) {
    			ExamModel model=new ExamModel();
    			model.setId(rs.getInt(1));
    			model.setName(rs.getString(2));
    			model.setTotalMarks(rs.getInt(3));
    			model.setPassingMarks(rs.getInt(4));
    			listExam.add(model);
    		}
    		return listExam.size()>0?listExam:null;
    	}catch(Exception ex) {
    		System.out.println("Error is>>"+ex);
    		return null;
    	}
		
    }
    public ExamModel getExamIdByName(String name) {
    	try {
    		 stmt=conn.prepareStatement("select *from exam where examname='"+name+"'");
    		 rs=stmt.executeQuery();
    		 ExamModel model=null;
    		 if(rs.next())
    		 { 
    			 model=new ExamModel();
    			 model.setId(rs.getInt(1));
    			 model.setName(rs.getString(2));
    			 model.setTotalMarks(rs.getInt(3));
    			 model.setPassingMarks(rs.getInt(4));
    		 }
    		 return model!=null?model:null;
    	}catch(Exception e) {
    		System.out.println("Error is>>>"+e);
    		return null;
    	}
    	
    }
    
    
    
    
}
