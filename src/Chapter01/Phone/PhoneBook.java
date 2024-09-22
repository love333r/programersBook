package Chapter01.Phone;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PhoneBook {
//    private final List<Person> people;
    private final Set<Person> people;

    public PhoneBook() {
//        people = new ArrayList<>();
        people = new HashSet<>();
    }

    public void addPerson(Person person) {
        people.add(person);
    }

    public Person search(PhoneNumber number) {
        return people.stream()          // 1. Set<Person>을 Stream<Person>으로 변환
                .filter(p -> p.hasPhoneNumber(number))// 2. number를 가지는 Person 객체들을 찾기
                .findFirst()            // 3. number를 갖는 Person 객체가 있는지 검사
                .orElse(null);    // 4. 없다면 null을 반환
    }

    @Override
    public String toString() {
        return "PersonBook{" +
                "people=" + people +
                '}';
    }


}
