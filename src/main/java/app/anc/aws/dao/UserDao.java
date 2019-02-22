package app.anc.aws.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Set;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "User")
public class UserDao {
    /**
     * 唯一值
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "pk_user_id")
    private int id;
    /**
     * 使用者代碼
     */
    @NotEmpty
    @Column(name = "user_id")
    private String userId;
    /**
     * 密碼
     */
    @NotEmpty
    @Column(name = "password")
    private String password;
    /**
     * 使用者名稱
     */
    @Column(name = "user_name")
    private String userName;
    /**
     * 電子信箱
     */
    @NotEmpty
    @Column(name = "email")
    private String email;
    /**
     * 是否有效
     */
    @Column(name = "active", columnDefinition = "CHAR(1)")
    private String active = "Y";
    /**
     * 權限表
     */
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "pk_user_id"), inverseJoinColumns = @JoinColumn(name = "pk_role_id"))
    private Set<RoleDao> roles;

    public UserDao(String userId, String password, String email, String userName){
        this.userId = userId;
        this.password = password;
        this.email = email;
        this.userName = userName;
    }
}
