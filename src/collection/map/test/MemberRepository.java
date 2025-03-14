package collection.map.test;

import java.util.HashMap;
import java.util.Map;


import java.util.HashMap;
import java.util.Map;

// MemberRepository 클래스: 회원 정보를 관리하는 저장소 역할을 하는 클래스
public class MemberRepository {
    // Membermap: 회원 정보를 저장하는 HashMap. 키는 회원 ID(String), 값은 Member 객체
    Map<String, Member> Membermap = new HashMap<>();

    // save 메서드: 새로운 회원을 저장소에 추가하는 메서드
    // @param member 저장할 Member 객체
    public void save(Member member) {
        Membermap.put(member.getId(), member);
    }

    // remove 메서드: 지정된 ID를 가진 회원을 저장소에서 제거하는 메서드
    // @param id 제거할 회원의 ID
    public void remove(String id){
        Membermap.remove(id);
    }

    // findById 메서드: 지정된 ID를 가진 회원을 찾아 반환하는 메서드
    // @param id 찾을 회원의 ID
    // @return 찾은 Member 객체, 없으면 null
    public Member findById(String id){
        return Membermap.get(id);
    }

    // findByName 메서드: 지정된 이름을 가진 회원을 찾아 반환하는 메서드
    // @param name 찾을 회원의 이름
    // @return 찾은 Member 객체, 없으면 null
    public Member findByName(String name){
        // Membermap의 모든 값(Member 객체)을 순회하며 이름이 일치하는 회원을 찾음

        for(Member member : Membermap.values()){
            if(member.getName().equals(name)){
                return member;
            }
        }

        // 일치하는 이름의 회원을 찾지 못한 경우 null 반환
        return null;
    }
}
