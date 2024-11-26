package co.kr.metacoding.backendtest.user;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class UserRepository {
    private final EntityManager em;

    // 유저 등록
    public User save(User user) {
        em.persist(user);
        return user;
    }

    // 유저 한건 조회
    public Optional<User> findById(Integer id) {
        return Optional.ofNullable(em.find(User.class, id));
    }
}
