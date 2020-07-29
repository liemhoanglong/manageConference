package pojos;
// Generated Jul 25, 2020 9:54:21 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * User generated by hbm2java
 */
@Entity
@Table(name="user"
    ,catalog="conference_manager"
    , uniqueConstraints = @UniqueConstraint(columnNames="username") 
)
public class User  implements java.io.Serializable {


     private Integer idUser;
     private String name;
     private String username;
     private String password;
     private String email;
     private Integer type;
     private Set<UserConference> userConferences = new HashSet<UserConference>(0);

    public User() {
    }

    public User(String name, String username, String password, String email, Integer type, Set<UserConference> userConferences) {
       this.name = name;
       this.username = username;
       this.password = password;
       this.email = email;
       this.type = type;
       this.userConferences = userConferences;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="idUser", unique=true, nullable=false)
    public Integer getIdUser() {
        return this.idUser;
    }
    
    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    
    @Column(name="name", length=45)
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    
    @Column(name="username", unique=true, length=45)
    public String getUsername() {
        return this.username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }

    
    @Column(name="password", length=45)
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }

    
    @Column(name="email", length=45)
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }

    
    @Column(name="type")
    public Integer getType() {
        return this.type;
    }
    
    public void setType(Integer type) {
        this.type = type;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="user")
    public Set<UserConference> getUserConferences() {
        return this.userConferences;
    }
    
    public void setUserConferences(Set<UserConference> userConferences) {
        this.userConferences = userConferences;
    }




}


