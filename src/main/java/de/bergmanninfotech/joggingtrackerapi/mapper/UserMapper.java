package de.bergmanninfotech.joggingtrackerapi.mapper;

import de.bergmanninfotech.joggingtrackerapi.dto.UserCreationRequest;
import de.bergmanninfotech.joggingtrackerapi.dto.UserResponse;
import de.bergmanninfotech.joggingtrackerapi.entity.User;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper {
    UserResponse map(User u);
    User map(UserCreationRequest creationRequest);
}
