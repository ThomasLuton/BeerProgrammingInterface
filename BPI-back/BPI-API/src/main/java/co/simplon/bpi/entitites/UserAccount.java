package co.simplon.bpi.entitites;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user_accounts")
public class UserAccount extends AbstractEntity {
    @Column(name = "pseudo")
    private String pseudo;
    @Column(name = "mail")
    private String mail;
    @Column(name = "password")
    private String password;
    @JoinColumn(name = "role_id")
    @ManyToOne
    private Role role;

    public UserAccount() {
	super();
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

    public Role getRole() {
	return role;
    }

    public void setRole(Role role) {
	this.role = role;
    }

    @Override
    public String toString() {
	return "UserAccount [pseudo=" + pseudo + ", mail="
		+ mail + ", password= {protected}, role="
		+ role + "]";
    }

}
