package co.simplon.wishmegift.service;


import co.simplon.wishmegift.entity.User;
import co.simplon.wishmegift.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsersService {

    private final UsersRepository usersRepository;
    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(16);


    public User findUserById(Long id) {
        return usersRepository.findUserById(id);
    }

    public void saveUser(User newUser) {
        newUser.setPassword(encoder.encode(newUser.getPassword()));
        System.out.println(newUser.getEmail());
        usersRepository.save(newUser);
    }

    public void modifyUserById(User newUser, Long id) {
        usersRepository.findById(id).map(user -> {
            user.setFirstname(newUser.getFirstname());
            user.setEmail(newUser.getEmail());
            user.setName(newUser.getName());
            user.setPassword(newUser.getPassword());
            return usersRepository.save(user);
        }).orElseGet(() -> {
            return usersRepository.save(newUser);
        });
    }

    public void modifyPartialyUserById(User newUser, Long id) {
        usersRepository.findById(id).map(user -> {
            if (newUser.getFirstname() != null) {
                user.setFirstname(newUser.getFirstname());
            }
            if (newUser.getEmail() != null) {
                user.setEmail(newUser.getEmail());
            }
            if (newUser.getPassword() != null) {
                user.setPassword(newUser.getPassword());
            }
            if (newUser.getName() != null) {
                user.setName(newUser.getName());
            }
            return usersRepository.save(user);
        });
    }

    public void deleteUser(Long id) {
        usersRepository.deleteById(id);
    }

}
