package CommandLine;

import entity.User;
import repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
class DataLoader implements CommandLineRunner {

    private final UserRepository userRepository;

    public DataLoader(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        if (userRepository.count() == 0) {
            User user = new User();
            user.setUsername("neptun123");
            user.setPassword("password123");
            userRepository.save(user);

            System.out.println("Alapértelmezett felhasználó hozzáadva: neptun123 / password123");
        }
    }
}
