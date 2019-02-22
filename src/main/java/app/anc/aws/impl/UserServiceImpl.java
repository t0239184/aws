package app.anc.aws.impl;

import app.anc.aws.dao.RoleDao;
import app.anc.aws.dao.UserDao;
import app.anc.aws.repository.RoleRepository;
import app.anc.aws.service.UserService;
import app.anc.aws.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

/**
 * The type User service.
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    /**
     * The User repository.
     */
    @Autowired
    UserRepository userRepository;
    /**
     * The Role repository.
     */
    @Autowired
    RoleRepository roleRepository;

    @Override
    @Transactional(readOnly = true)
    public UserDao findUserByUserId(String userId) {
        return userRepository.findUserByUserId(userId);
    }

    @Override
    @Transactional(readOnly = true)
    public UserDao findUserByEmail(String mail) {
        return userRepository.findUserByEmail(mail);
    }

    @Override
    @Transactional(timeout = 600)
    public UserDao save(UserDao user) {
        user.setPassword(Integer.toString(user.getPassword().hashCode()));
        user.setActive("Y");
        // TODO 給予一個基本的權限
        RoleDao userRole = roleRepository.findRoleByRole("ADMIN");
        Set<RoleDao> roleSet = new HashSet<>();
        roleSet.add(userRole);
        user.setRoles(roleSet);
        return userRepository.save(user);
    }
}
