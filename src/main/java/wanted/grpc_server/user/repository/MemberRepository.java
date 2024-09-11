package wanted.grpc_server.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wanted.grpc_server.user.entity.Member;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findByAccount(String acocunt);
    Optional<Member> findByAccountAndPassword(String account, String password);

}
