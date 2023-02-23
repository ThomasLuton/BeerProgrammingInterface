package co.simplon.bpi.dtos;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class UserAccountDto {
    @NotNull
    @Size(min = 4, max = 255)
    private String pseudo;
    @NotNull
    @Email
    private String mail;
    @NotNull
    @Pattern(regexp = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[%||!||*])(?!.* ).{8,42}")
    private String password;

    public UserAccountDto() {
	super();
	// TODO Auto-generated constructor stub
    }

    public String getPseudo() {
	return pseudo;
    }

    public void setPseudo(String pseudo) {
	this.pseudo = pseudo;
    }

    public String getMail() {
	return mail;
    }

    public void setMail(String mail) {
	this.mail = mail;
    }

    public String getPassword() {
	return password;
    }

    public void setPassword(String password) {
	this.password = password;
    }

    @Override
    public String toString() {
	return "UserAccountDto [pseudo=" + pseudo
		+ ", mail=" + mail
		+ ", password={protected}";
    }

}
