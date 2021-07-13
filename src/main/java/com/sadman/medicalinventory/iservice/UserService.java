package com.sadman.medicalinventory.iservice;

import com.sadman.medicalinventory.dto.ChangePasswordDTO;
import com.sadman.medicalinventory.exception.RecordNotFoundException;
import com.sadman.medicalinventory.model.User;

import java.util.List;

/**
 * @author Sadman
 */
public interface UserService {
    boolean existsByEmail(String email);
    boolean existsByUserName(String username);
    User findUserByEmail(String email);
    User findUserByUserName(String userName);
    User saveUser(User user);
    List<User> getAllUsers();
    User getUserById(Long id) throws RecordNotFoundException;
    User createUser(User user);
    User updateUser(User newUser, Long id);
    User updateProfile(User newUser);
    void changePassword(ChangePasswordDTO changePasswordDTO);
    void deleteUserById(Long id);
}
