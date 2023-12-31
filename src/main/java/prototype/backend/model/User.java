package prototype.backend.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import prototype.backend.datatype.UserRole;
import prototype.backend.dto.request.LoginRequestDTO;

import java.util.Date;

@Entity
@Table(name = "user", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"username"})
})
@Data
@Accessors(chain = true)
@NoArgsConstructor
public class User {
//    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "active")
    private Boolean active;

    @Column(name = "email")
    private String email;


    public User(LoginRequestDTO loginRequestDTO){
        this.username = loginRequestDTO.getUsername();
        this.password = loginRequestDTO.getPassword();
    }
}
