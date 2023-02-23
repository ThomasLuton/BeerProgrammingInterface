package co.simplon.bpi.dtos;

public class UserAccountRoleUpdateDto {

    private Long roleId;

    public UserAccountRoleUpdateDto() {
	super();
	// TODO Auto-generated constructor stub
    }

    public Long getRoleId() {
	return roleId;
    }

    public void setRoleId(Long roleId) {
	this.roleId = roleId;
    }

    @Override
    public String toString() {
	return "UserAccountRoleUpdateDto [roleId=" + roleId
		+ "]";
    }

}
