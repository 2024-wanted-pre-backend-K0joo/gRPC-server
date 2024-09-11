package wanted.grpc_server.user.service;

import io.grpc.stub.StreamObserver;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.server.service.GrpcService;
import wanted.grpc_server.MemberProto;
import wanted.grpc_server.MemberServiceGrpc;
import wanted.grpc_server.user.dto.MemberSignUpRequestDTO;
import wanted.grpc_server.user.entity.Member;
import wanted.grpc_server.user.mapper.MemberMapper;

@Slf4j
@RequiredArgsConstructor
@GrpcService
public class MemberServiceGrpcImpl extends MemberServiceGrpc.MemberServiceImplBase {
    private final MemberService memberService;
    private final MemberMapper memberMapper;

    @Override
    public void createMember(MemberProto.MemberRequest request,
                             StreamObserver<MemberProto.MemberCreateResponse> responseObserver){
        // 1. 클라이언트로부터 전달받은 request 데이터를 DTO로 변환한다.
        MemberSignUpRequestDTO memberDTO = memberMapper.requestProtoToDto(request);

        // 2. 서비스 레이어에서 request 데이터를 사용해서 RDB에 저장하는 로직을 수행하고 결과를 받는다.
        Member createdMember = memberService.createMember(memberDTO);

        // 3. RDB에 저장된 데이터를 gRPC response 데이터로 변환한다.
        MemberProto.MemberCreateResponse response = memberMapper.dtoToResponseProto(createdMember);

        // 4. 응답을 클라언트에게 전달한다.
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
