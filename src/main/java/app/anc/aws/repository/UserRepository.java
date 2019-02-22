package app.anc.aws.repository;

import app.anc.aws.dao.UserDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * The interface User repository.
 */
@Repository
public interface UserRepository extends JpaRepository<UserDao, Long> {
       /**
        * 查詢使用者 by userId
        *
        * @param userId the id
        * @return the user dao
        */
       UserDao findUserByUserId(String userId);

       /**
        * 查詢使用者 by Email
        *
        * @param mail the mail
        * @return the user dao
        */
       UserDao findUserByEmail(String mail);
}
