package com.junker.api.findpet.converter;

import com.junker.api.findpet.domain.User;
import com.junker.api.findpet.dto.UserDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserConverter {

    UserDTO userToUserDTO(User user);

    User userDTOToUser(UserDTO userDTO);

}
