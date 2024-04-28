package thecommerce.project.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class User extends Timestamped{
    @Id
    @Column(nullable = false)
    private String userId;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String nickname;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String phone;

    @Column(nullable = false)
    private String email;

    public void update(String password, String nickname, String name, String phone, String email ){
        if(password != null)
            this.password = password;
        if(nickname != null)
            this.nickname = nickname;
        if(name != null)
            this.name = name;
        if(phone != null)
            this.phone = phone;
        if(email != null)
            this.email = email;
    }
}
