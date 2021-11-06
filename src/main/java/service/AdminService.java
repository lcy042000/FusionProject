package service;

import persistence.dao.AdminDAO;
import persistence.dto.AdminDTO;

import java.util.List;

public class AdminService {
    private final AdminDAO adminDAO;

    public AdminService(AdminDAO adminDAO) {
        this.adminDAO = adminDAO;
    }

    // add admin
    public List<AdminDTO> findAll() {

        return adminDAO.findAll();

    }

    public AdminDTO findByAdminId(String adminId) {

        return adminDAO.findByAdminId(adminId);

    }
}
