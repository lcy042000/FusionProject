package persistence.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import persistence.dto.SubjectDTO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SubjectDAO {
    private SqlSessionFactory sqlSessionFactory = null;

    public SubjectDAO(SqlSessionFactory sqlSessionFactory){
        this.sqlSessionFactory = sqlSessionFactory;
    }

    public List<SubjectDTO> selectAll(){

        List<SubjectDTO> list = null;
        SqlSession session = sqlSessionFactory.openSession();
        try{
            list = session.selectList("mapper.SubjectMapper.selectAll");
        }finally
        {
            session.close();
        }
        return list;
    }
    public List<SubjectDTO> selectByGrade(int grade){
        List<SubjectDTO> list = null;
        SqlSession session = sqlSessionFactory.openSession();
        try{
            list = session.selectList("mapper.SubjectMapper.selectByGrade", grade);
        }finally
        {
            session.close();
        }
        return list;
    }

    public void insertOneSubject(SubjectDTO subjectDTO){
        SqlSession session = sqlSessionFactory.openSession();

        try{
            session.insert("mapper.SubjectMapper.insertOneSubject", subjectDTO);
            session.commit();
        }finally{
            session.close();
        }
    }

    public void updateSubjectNameWithName(HashMap map){
        SqlSession session = sqlSessionFactory.openSession();

        try{
            session.update("mapper.SubjectMapper.updateOneSubjectName", map);
            session.commit();
        }finally{
            session.close();
        }
    }
}
