package prototype.backend.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import prototype.backend.ExceptionHandler.exception.NotFoundException;
import prototype.backend.config.jwt.JwtUtilities;
import prototype.backend.model.User;
import prototype.backend.repository.IUserRepository;
import prototype.backend.service.IAuthService;
import prototype.backend.dto.request.LoginRequestDTO;
import prototype.backend.dto.response.UserResponseDTO;

import java.util.stream.Collectors;

@Service
public class AuthService implements IAuthService {

    @Autowired
    AuthenticationManager authenticationManager ;
    @Autowired
    JwtUtilities jwtUtilities ;
    @Autowired
    IUserRepository iUserRepository;

    @Override
    public UserResponseDTO login(LoginRequestDTO userRequestDTO) {
        try{
            Authentication authentication= authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            userRequestDTO.getUsername(),
                            userRequestDTO.getPassword()
                    )
            );
            SecurityContextHolder.getContext().setAuthentication(authentication);

            String token = jwtUtilities.generateToken(userRequestDTO.getUsername());

            User user = new User()
                    .setUsername(authentication.getName());

            return new UserResponseDTO(user, token);
        } catch (AuthenticationException authenticationException){
            throw new NotFoundException("Incorrect username or password");
        }


    }
}
