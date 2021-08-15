package ir.ghorbani.login;

import javax.persistence.*;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column
    public Integer id;
    @Column
    public String firstName;
    @Column
    public String lastName;
    @Column
    public String eMail;
    @Column(unique = true)
    public String userName;
    @Column
    public  String password;
}
