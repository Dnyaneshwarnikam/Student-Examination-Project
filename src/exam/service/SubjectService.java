package exam.service;

import java.util.List;

import dn.exam.model.SubjectModel;
import exam.repository.SubjectRepository;

public class SubjectService {
  SubjectRepository SubRepo = new SubjectRepository();
  public int addSubject(SubjectModel model) {
	  return (SubRepo.isSubjectPresent(model.getName()))?-1:SubRepo.isAddSubject(model)?1:0;
  }
  public List<String> getAllSubjects(){
	  return this.SubRepo.getAllSubjects();
	}
  }

  
