package service;

import persistence.MyBatisConnectionFactory;
import persistence.dao.SubjectDAO;
import persistence.dto.SubjectDTO;

import java.util.HashMap;
import java.util.List;

public class SubjectService {
    SubjectDAO subjectDAO = new SubjectDAO(MyBatisConnectionFactory.getSqlSessionFactory());

    public List<SubjectDTO> selectAll(){
        List<SubjectDTO> list = subjectDAO.selectAll();

        return list;
    }

    public List<SubjectDTO> selectByGrade(int grade){
        List<SubjectDTO> list = subjectDAO.selectByGrade(grade);

        return list;
    }

    //insert subject기능
    public void insertOneSubject(String subjectName, int targetGrade, int semester, int credit){
        SubjectDTO subjectDTO = new SubjectDTO();

        subjectDTO.setSubjectName(subjectName);
        subjectDTO.setTargetGrade(targetGrade);
        subjectDTO.setSemester(semester);
        subjectDTO.setCredit(credit);

        subjectDAO.insertOneSubject(subjectDTO);
    }

    public void updateSubjectNameWithName(String prevSubjectName, String newSubjectName){
        HashMap<String, String> map = new HashMap<>();
        map.put("prevSubjectName", prevSubjectName);
        map.put("newSubjectName", newSubjectName);

        subjectDAO.updateSubjectNameWithName(map);
    }
}
