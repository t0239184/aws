package app.anc.aws.dao;

import lombok.Data;
import javax.persistence.*;


@Data
@Entity
@Table(name = "Role")
public class RoleDao {
    /**
     * 唯一值
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "pk_role_id")
    private int id;
    /**
     * 權限
     */
    @Column(name = "role")
    private String role;

}
