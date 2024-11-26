package co.kr.metacoding.backendtest.user;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class UserController {
    private final UserService userService;

    @PutMapping("/users/{id}")
    public ResponseEntity<?> updateUser(@PathVariable int id, @RequestBody @Valid UserRequest.UpdateDTO updateDTO) {
        return new ResponseEntity<>(userService.수정(id, updateDTO), HttpStatus.OK);

    }

    @GetMapping("/users/{id}")
    public ResponseEntity<?> findById(@PathVariable int id) {
        return new ResponseEntity<>(userService.조회(id), HttpStatus.OK);
    }

    @PostMapping("/users")
    public ResponseEntity<?> save(@RequestBody @Valid UserRequest.SaveDTO saveDTO, Errors errors) {
        return new ResponseEntity<>(userService.등록(saveDTO), HttpStatus.CREATED);
    }
}
