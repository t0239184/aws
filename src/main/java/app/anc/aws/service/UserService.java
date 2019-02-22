package app.anc.aws.service;

import app.anc.aws.dao.UserDao;

/**
 * The interface User service.
 */
public interface UserService {
    /**
     * 查詢使用者 by UserId
     *
     * @param userId the userId
     * @return UserDao user dao
     */
    UserDao findUserByUserId(String userId);

    /**
     * 查詢使用者 by Email
     *
     * @param mail the mail
     * @return UserDao user dao
     */
    UserDao findUserByEmail(String mail);

    /**
     * 儲存使用者
     *
     * @param user the user
     * @return user dao
     */
    UserDao save(UserDao user);
}
