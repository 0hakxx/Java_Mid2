package collection.map.test.member;

import java.util.HashMap;
import java.util.Map;

public class MemberRepository {
    // key: 회원의 id(String), value: 회원 객체(Member)
    private Map<String, Member> membermap = new HashMap<>();

    // 회원의 id를 key로 하여 Map에 저장
    public void save(Member member){
        membermap.put(member.getId(), member);
    }

    // key(id)로 Map에서 해당 회원(Member) 객체를 반환
    public Member findById(String id){
        return membermap.get(id);
    }

    public Member findByName(String name) {
        for (String s : membermap.keySet()) {
            if (s.equals(name)) { // key(=id)가 name과 같으면
                return membermap.get(s); // 해당 회원 반환
            }
        }
        return null; // 찾는 회원이 없으면 null 반환
    }

    // id로 회원을 삭제하는 메서드
    // key(id)를 이용해 Map에서 회원 정보 제거
    public void remove(String id){
        membermap.remove(id);
    }
}
