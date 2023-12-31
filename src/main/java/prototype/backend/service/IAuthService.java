package prototype.backend.service;

import prototype.backend.dto.request.LoginRequestDTO;
import prototype.backend.dto.response.UserResponseDTO;

public interface IAuthService {
    UserResponseDTO login(LoginRequestDTO userRequestDTO);
}
