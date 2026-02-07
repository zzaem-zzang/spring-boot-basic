package hello.core.member;

public class MemberServiceImpl implements MemberService{

    private final MemberRespository memberRespository;

    public MemberServiceImpl(MemberRespository memberRespository) {
        this.memberRespository = memberRespository;
    }

    @Override
    public void join(Member member) {
        memberRespository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRespository.findbyId(memberId);
    }
}
