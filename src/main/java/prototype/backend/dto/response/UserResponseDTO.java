package prototype.backend.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import prototype.backend.model.User;

@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseDTO {

    private String username;
    private String email;
    private String token;

    public UserResponseDTO(User user, String token){
        this.username = user.getUsername();
        this.email = user.getEmail();
        this.token = token;
    }

    public UserResponseDTO(User user){
        this.username = user.getUsername();
        this.email = user.getEmail();
    }

}
