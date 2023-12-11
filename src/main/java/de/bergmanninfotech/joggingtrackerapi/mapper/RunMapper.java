package de.bergmanninfotech.joggingtrackerapi.mapper;

import de.bergmanninfotech.joggingtrackerapi.dto.RunFinishResponse;
import de.bergmanninfotech.joggingtrackerapi.dto.RunResponse;
import de.bergmanninfotech.joggingtrackerapi.dto.RunStartRequest;
import de.bergmanninfotech.joggingtrackerapi.dto.RunStartResponse;
import de.bergmanninfotech.joggingtrackerapi.entity.Run;
import de.bergmanninfotech.joggingtrackerapi.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface RunMapper {
    Run map(RunStartRequest request, User user);
    @Mapping(target = "userId", source = "r.user.id")
    RunStartResponse mapToStartResponse(Run r);

    @Mapping(target = "userId", source = "r.user.id")
    RunFinishResponse mapToFinishResponse(Run r);

    RunResponse mapToResponse(Run r, Long userId);
}
