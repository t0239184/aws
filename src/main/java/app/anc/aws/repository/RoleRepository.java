package app.anc.aws.repository;

import app.anc.aws.dao.RoleDao;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * The interface Role repository.
 */
public interface RoleRepository extends JpaRepository<RoleDao, Long> {
    /**
     * 查詢權限 by role
     *
     * @param role the role
     * @return the role dao
     */
    RoleDao findRoleByRole(String role);

    /**
     * 查詢權限 by role id
     *
     * @param id the role id
     * @return the role dao
     */
    RoleDao findRoleById(String id);
}
