package prototype.backend.service;

import prototype.backend.dto.request.CreateUserRequestDTO;
import prototype.backend.dto.request.LoginRequestDTO;
import prototype.backend.dto.response.UserResponseDTO;

import java.util.List;

public interface IUserService {
    public UserResponseDTO getUserById(int id) throws Exception;
    public List<UserResponseDTO> getAllUser();
    public UserResponseDTO createUser(CreateUserRequestDTO user);
    public UserResponseDTO updateUser(int id, CreateUserRequestDTO user);
    public void deleteUser(int id);
}
