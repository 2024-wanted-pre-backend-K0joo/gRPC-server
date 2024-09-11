package wanted.grpc_server.user.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wanted.grpc_server.MemberProto;
import wanted.grpc_server.user.client.GrpcMemberClient;

@RequestMapping("/users")
@RequiredArgsConstructor
@RestController
public class MemberController {
    private final GrpcMemberClient grpcMemberClient;

    @PostMapping("create")
    public String createMember(){
        MemberProto.MemberCreateResponse member = grpcMemberClient.createMember(
                MemberProto.MemberRequest
                        .newBuilder()
                        .setAccount("testaccount")
                        .setName("kimtest")
                        .setPassword("testpw")
                        .setPhone("010-1234-5678")
                        .build()
        );

        return member.toString();
    }
}
