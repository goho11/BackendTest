package co.kr.metacoding.backendtest.user;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

public class UserRequest {

    @Data
    public static class UpdateDTO {
        @Size(min = 2, max = 50)
        @NotEmpty
        private String name;

        public User toEntity() {
            return new User(null, name);
        }
    }

    @Data
    public static class SaveDTO {
        @Size(min = 2, max = 50)
        @NotEmpty
        private String name;

        public User toEntity() {
            return new User(null, name);
        }
    }
}
