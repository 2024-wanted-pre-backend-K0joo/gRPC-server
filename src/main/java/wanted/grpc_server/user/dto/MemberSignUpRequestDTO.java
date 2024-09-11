package wanted.grpc_server.user.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class MemberSignUpRequestDTO {
    private UUID user_id;
    private String account;
    private String password;
    private String name;
    private String phone;
}
