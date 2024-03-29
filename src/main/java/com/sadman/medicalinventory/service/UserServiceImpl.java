package com.sadman.medicalinventory.service;

import com.sadman.medicalinventory.dto.ChangePasswordDTO;
import com.sadman.medicalinventory.exception.RecordNotFoundException;
import com.sadman.medicalinventory.iservice.UserService;
import com.sadman.medicalinventory.model.Role;
import com.sadman.medicalinventory.model.User;
import com.sadman.medicalinventory.repository.RoleRepository;
import com.sadman.medicalinventory.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    public boolean existsByUserName(String username) {
        return userRepository.existsByUserName(username);
    }

    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public User findUserByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }

    public User saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
//        user.setPassword(user.getPassword());
        user.setActive(true);
//        Role userRole = roleRepository.findByName("ADMIN");
//        user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) throws RecordNotFoundException {
        return userRepository.findById(id).orElseThrow(() -> new RecordNotFoundException(id));
    }

    public User createUser(User user){
        return saveUser(user);
    }

    public User updateUser(User newUser, Long id)
    {
        return userRepository.findById(id)
                .map(user -> {
                    user.setFirstName(newUser.getFirstName());
                    user.setLastName(newUser.getLastName());
                    user.setEmail(newUser.getEmail());
                    user.setUserName(newUser.getUserName());
                    user.setRoles(newUser.getRoles());
//                    user.setPassword(passwordEncoder.encode(newUser.getPassword()));
//                    user.setPassword(newUser.getPassword());
                    user.setPhone(newUser.getPhone());
                    user.setAddress(newUser.getAddress());
                    user.setActive(newUser.getActive());
                    return userRepository.save(user);
                })
                .orElseGet(() -> {
                    newUser.setId(id);
                    return saveUser(newUser);
                });
    }

    public User updateProfile(User newUser) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();
        User user = userRepository.findByUserName(userName);
        newUser.setRoles(user.getRoles());
        newUser.setActive(user.getActive());
        return updateUser(newUser, user.getId());
    }

    public void changePassword(ChangePasswordDTO changePasswordDTO) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();
        User user = userRepository.findByUserName(userName);
        user.setPassword(passwordEncoder.encode(changePasswordDTO.getNewPassword()));
        userRepository.save(user);
    }

    public void deleteUserById(Long id){
        userRepository.deleteById(id);
    }
}
