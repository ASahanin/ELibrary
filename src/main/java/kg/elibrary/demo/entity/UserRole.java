package kg.elibrary.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Entity
@Table(name = "user_role")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserRole extends EntityBase implements GrantedAuthority {
    @Column(name = "role_name", nullable = false)
    private String roleName;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Override
    public String getAuthority() {
        return getRoleName();
    }
}
