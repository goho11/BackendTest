package co.kr.metacoding.backendtest.user;

import co.kr.metacoding.backendtest.core.error.Exception404;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    @Transactional
    public UserResponse.SaveDTO 등록(UserRequest.SaveDTO saveDTO) {
        User userPs = userRepository.save(saveDTO.toEntity());
        return new UserResponse.SaveDTO(userPs);
    }

    public UserResponse.FindDTO 조회(int id) {
        User userPs = userRepository.findById(id)
                .orElseThrow(() -> new Exception404(id+"번 id를 찾을 수 없습니다"));
        return  new UserResponse.FindDTO(userPs);
    }

    @Transactional
    public UserResponse.UpdateDTO 수정(int id, UserRequest.@Valid UpdateDTO updateDTO) {
        User userPs = userRepository.findById(id)
                .orElseThrow(() -> new Exception404(id+"번 id를 찾을 수 없습니다"));
        userPs.update(updateDTO.getName());
        return new UserResponse.UpdateDTO(userPs);
    } // dirty checking
}
