package de.bergmanninfotech.joggingtrackerapi.service;

import de.bergmanninfotech.joggingtrackerapi.dto.UserCreationRequest;
import de.bergmanninfotech.joggingtrackerapi.dto.UserResponse;
import de.bergmanninfotech.joggingtrackerapi.entity.User;
import de.bergmanninfotech.joggingtrackerapi.exception.UserNotFoundException;
import de.bergmanninfotech.joggingtrackerapi.mapper.UserMapper;
import de.bergmanninfotech.joggingtrackerapi.repo.RunRepo;
import de.bergmanninfotech.joggingtrackerapi.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepo userRepo;
    private final RunRepo runRepo;
    private final UserMapper userMapper;

    @Transactional(readOnly = true)
    public Page<UserResponse> getUsers(Pageable pageable) {
        return userRepo.findAll(pageable)
                .map(userMapper::map);
    }

    @Transactional(readOnly = true)
    public UserResponse getById(Long id) {
        return userRepo.findById(id)
                .map(userMapper::map)
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    @Transactional
    public UserResponse createUser(UserCreationRequest userCreationRequest) {
        User saved = userRepo.save(userMapper.map(userCreationRequest));
        return userMapper.map(saved);
    }

    @Transactional
    public UserResponse updateUser(Long id, UserCreationRequest userUpdateRequest) {
        User user = userRepo.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
        user.setFirstName(userUpdateRequest.getFirstName());
        user.setLastName(userUpdateRequest.getLastName());
        user.setBirthDate(userUpdateRequest.getBirthDate());
        user.setGender(userUpdateRequest.getGender());
        User updatedUser = userRepo.save(user);
        return userMapper.map(updatedUser);
    }

    @Transactional
    public void deleteUserById(Long id) {
        runRepo.deleteByUserIdWithoutSelect(id);
        userRepo.deleteByIdWithoutSelect(id);
    }
}
