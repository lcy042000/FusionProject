import persistence.MyBatisConnectionFactory;
import persistence.dao.AdminDAO;
import persistence.dao.Opening_subjectDAO;
import persistence.dao.SubjectDAO;
import persistence.dto.AdminDTO;
import persistence.dto.Opening_subjectDTO;
import persistence.dto.SubjectDTO;
import service.AdminService;
import service.OpeningSubjectService;
import service.SubjectService;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        AdminDAO adminDAO = new AdminDAO();
//        AdminService adminService = new AdminService(adminDAO);

        // admin insert
//        AdminDTO adminDTO = new AdminDTO(
//                "admin2",
//                "손정동",
//                "pass",
//                "010-1234-1234"
//        );
//
//        if(adminDAO.insertAdmin(adminDTO)) System.out.println("삽입 성공");
//        else System.out.println("삽입 실패");
//
//        adminDTO = adminService.findByAdminId("admin2");
//        System.out.println(adminDTO);
//        System.out.println();

//        SubjectDAO subjectDAO = new SubjectDAO(MyBatisConnectionFactory.getSqlSessionFactory());

//        SubjectService subjectService = new SubjectService();
//
//        List<SubjectDTO> subjectDTOS = subjectService.selectByGrade(2);
//        for(SubjectDTO dto:subjectDTOS){
//           System.out.println("dto.toString() = " + dto.toString());
//        }
//        subjectService.insertOneSubject("자료구조",2, 2, 3);
//        subjectService.insertOneSubject("컴퓨터네트워크",2, 2, 3);
//        subjectService.insertOneSubject("c++",2, 2, 3);
//        subjectService.insertOneSubject("과기영독",2, 2, 3);
//        subjectService.insertOneSubject("확통",2, 2, 3);
        //        subjectService.updateSubjectNameWithName("네트워크", "운영체제");

//         List<SubjectDTO> subjectDTOS = subjectDAO.selectAll();

//        Scanner sc = new Scanner(System.in);
        LocalDateTime ldt = LocalDateTime.now();
        Opening_subjectDAO opening_subjectDAO = new Opening_subjectDAO((MyBatisConnectionFactory.getSqlSessionFactory()));
//        SubjectDAO subjectDAO = new SubjectDAO((MyBatisConnectionFactory.getSqlSessionFactory()));
//
        List<Opening_subjectDTO> subjectDTOS = opening_subjectDAO.selectAllWithAnnotation();
//        for(Opening_subjectDTO dto:subjectDTOS){
//           System.out.println("dto.toString() = " + dto.toString());
//        }
//
//        System.out.println("학년: ");
//        int grade = sc.nextInt();
//        List<Integer> subject_Ids = subjectDAO.selectIdByGrade(grade);
//
//        for(int i = 0; i < subject_Ids.size(); i++){
//            opening_subjectDAO.updateRegister_start(subject_Ids.get(i), ldt);
//        }
//
//        sc.nextLine();
//
//        System.out.println("과목 이름: ");
//        String subjectName = sc.nextLine();
//
//        int subject_Id = subjectDAO.selectSubjectNameByGrade(subjectName);
//        opening_subjectDAO.updateRegister_start(subject_Id, ldt);

        OpeningSubjectService openingSubjectService = new OpeningSubjectService();
        int grade = 3;
        for(int i = 0; i < subjectDTOS.size(); i++){
            subjectDTOS.get(i).setRegister_start(ldt);
            subjectDTOS.get(i).setRegister_close(ldt);
            openingSubjectService.updateRegisterTime(grade, subjectDTOS.get(i));
        }

        List<Opening_subjectDTO> subjectDTOS2 = opening_subjectDAO.selectAllWithAnnotation();
        for(Opening_subjectDTO dto:subjectDTOS2){
            System.out.println("dto.toString() = " + dto.toString());
        }
    }
}
