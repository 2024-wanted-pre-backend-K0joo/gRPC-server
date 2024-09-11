package wanted.grpc_server.user.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import wanted.grpc_server.user.dto.MemberSignUpRequestDTO;
import wanted.grpc_server.user.entity.Member;
import wanted.grpc_server.user.mapper.MemberMapper;
import wanted.grpc_server.user.repository.MemberRepository;

@RequiredArgsConstructor
@Service
public class MemberService {
    private final MemberRepository memberRepository;
    private final MemberMapper memberMapper;

    public Member createMember(MemberSignUpRequestDTO memberDTO){
        Member member = memberMapper.dtoToEntity(memberDTO);
        return memberRepository.save(member);
    }
}
