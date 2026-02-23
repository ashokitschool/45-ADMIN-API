package in.ashokit.service;

import in.ashokit.dto.UserDto;

import java.util.List;

public interface UserService {

    public UserDto createUser(UserDto userDto);

    public List<UserDto> getAllUsers();

    public UserDto getUserById(Integer userId);

    public UserDto getUserByEmail(String email);

    public UserDto updateUser(Integer userId, UserDto userDto);

    public List<UserDto> getUsersByRoleId(Integer roleId);

    public UserDto deleteUser(Integer userId, Integer updatedBy);
}
