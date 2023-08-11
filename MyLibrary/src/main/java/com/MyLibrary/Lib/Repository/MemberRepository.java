package com.MyLibrary.Lib.Repository;
import com.MyLibrary.Lib.Model.Member;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

public interface MemberRepository extends MongoRepository<Member, String> {

    Optional<Member> findMemberByEmail(String email);
    Optional<Member> findMemberByNickName(String nickname);
    void deleteMemberById(BigInteger id);

}