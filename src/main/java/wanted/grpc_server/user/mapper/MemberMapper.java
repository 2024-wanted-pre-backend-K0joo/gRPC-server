package wanted.grpc_server.user.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import wanted.grpc_server.MemberProto;
import wanted.grpc_server.user.dto.MemberSignUpRequestDTO;
import wanted.grpc_server.user.entity.Member;

/**
 * componentModel = "spring"을 통해서 spring container에 Bean으로 등록 해 준다. (외부에서 주입 받아서 사용하면 된다.)
 * unmappedTargetPolicy IGNORE 만약, target class에 매핑되지 않는 필드가 있으면, null로 넣게 되고, 따로 report 하지 않는다.
 * */

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MemberMapper {
    // gRPC request를 DTO로 변환
    MemberSignUpRequestDTO requestProtoToDto(MemberProto.MemberRequest member);

    // Entity를 gRPC response로 변환
    MemberProto.MemberCreateResponse dtoToResponseProto(Member createdMember);

    // DTO를 Entity로 변환
    Member dtoToEntity(MemberSignUpRequestDTO memberDTO);
}
