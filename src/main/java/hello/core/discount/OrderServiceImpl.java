package hello.core.discount;

import hello.core.member.Member;
import hello.core.member.MemberRespository;


public class OrderServiceImpl implements  OrderService{

    private final MemberRespository memberRespository;
    private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRespository memberRespository, DiscountPolicy discountPolicy) {
        this.memberRespository = memberRespository;
        this.discountPolicy = discountPolicy;
    }


    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice){
        Member member = memberRespository.findbyId(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
