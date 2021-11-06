package persistence.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import persistence.dto.Opening_subjectDTO;

import persistence.mapper.Opening_subjectMapper;

import java.util.List;

public class Opening_subjectDAO {
    private SqlSessionFactory sqlSessionFactory = null;

    public Opening_subjectDAO(SqlSessionFactory sqlSessionFactory){
        this.sqlSessionFactory = sqlSessionFactory;
    }

    public void updateRegisterTimes(Opening_subjectDTO opening_subjectDTO){
        SqlSession session = sqlSessionFactory.openSession();
        Opening_subjectMapper mapper = session.getMapper(Opening_subjectMapper.class);
        try{
            mapper.updateNewRegisterTime(opening_subjectDTO.getSubject_id(), opening_subjectDTO.getRegister_start(), opening_subjectDTO.getRegister_close());
            session.commit();
        } catch(Exception e){
            e.printStackTrace();
            session.rollback();
        } finally{
            session.close();
        }
    }

    public List<Opening_subjectDTO> selectAllWithAnnotation(){
        List<Opening_subjectDTO> list = null;
        SqlSession session = sqlSessionFactory.openSession();
        Opening_subjectMapper mapper = session.getMapper(Opening_subjectMapper.class);
        try{
            list = mapper.selectAll();
            session.commit();
        } catch(Exception e){
            e.printStackTrace();
            session.rollback();
        } finally{
            session.close();
        }
        return list;
    }
}
