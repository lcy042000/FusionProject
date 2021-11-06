package service;

import persistence.MyBatisConnectionFactory;
import persistence.dao.Opening_subjectDAO;
import persistence.dao.SubjectDAO;
import persistence.dto.Opening_subjectDTO;
import persistence.dto.SubjectDTO;

import java.util.List;

public class OpeningSubjectService {
    Opening_subjectDAO opening_subjectDAO = new Opening_subjectDAO(MyBatisConnectionFactory.getSqlSessionFactory());
    SubjectDAO subjectDAO = new SubjectDAO((MyBatisConnectionFactory.getSqlSessionFactory()));

    public void updateRegisterTime(int grade, Opening_subjectDTO opening_subjectDTO){
        List<SubjectDTO> list = subjectDAO.selectByGrade(grade);
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).getId() == opening_subjectDTO.getSubject_id()){
                opening_subjectDAO.updateRegisterTimes(opening_subjectDTO);
            }
        }
    }
}
