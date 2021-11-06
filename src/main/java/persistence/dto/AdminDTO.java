package persistence.dto;

public class AdminDTO extends UserDTO {

    String adminId;


    public String getAdminId() {
        return adminId;
    }
    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

    public AdminDTO(long userId, String adminId, String name, String password, String phoneNumber) {
        this.userId = userId;
        this.adminId = adminId;
        this.name = name;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }

    public AdminDTO(String adminId, String name, String password, String phoneNumber) {
        this.adminId = adminId;
        this.name = name;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "AdminDTO{" +
                "userId=" + userId +
                ", adminId=" + adminId +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
