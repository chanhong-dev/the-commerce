package thecommerce.project.security;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import thecommerce.project.domain.User;
import thecommerce.project.repository.UserRepository;

@RequiredArgsConstructor
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;


    public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
        // 로그인 닉네임 있는 확인
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UsernameNotFoundException("Can't find " + id));

        return new UserDetailsImpl(user);

    }
}