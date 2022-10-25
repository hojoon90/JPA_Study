package com.jpatest.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
//모든 설명의 출처는 https://data-make.tistory.com/610 [Data Makes Our Future:티스토리] 에서 가져옴.

/*
@Entity
위 어노테이션가 붙은 클래스는 JPA가 관리하는 것으로, 엔티티라고 불림

Name : JPA에서 사용할 엔티티 이름을 지정. 보통 기본값인 클래스 이름을 사용

주의사항
- 기본 생성자는 필수 (JPA가 엔티티 객체 생성 시 기본 생성자를 사용)
- final 클래스, enum, interface, inner class 에는 사용할 수 없음
- 저장할 필드에 final 사용 불가
 */
@Entity
/*
@Table
- 엔티티와 매핑할 테이블을 지정
- 생략 시 매핑한 엔티티 이름을 테이블 이름으로 사용

Name : 매핑할 테이블 이름 (기본적으로 엔티티 이름 사용한다.)
Catalog : catalog 기능이 있는 DB에서 catalog 를 매핑 (default. DB 명) -> 거의 쓸일이 없어보임
Schema : schema 기능이 있는 DB에서 schema를 매핑
uniqueConstraints : DDL 생성 시 유니크 제약조건을 만든다. 스키마 자동 생성 기능을 사용해서 DDL을 만들 때만 사용
 */
@Table(
        name = "employees"
        // 아래는 유니크 키 세팅을 위한 설정.
//        , uniqueConstraints = {@UniqueConstraint(
//                name = "emp_no_uniq"
//                , columnNames = "emp_no"
//        )}
)
public class Employees {
    @Id //기본키 매핑 어노테이션
    /*
    @Column
    객체필드를 테이블 컬럼에 매핑. name과 nullable이 주로 사용되며 나머지 옵션은 잘 사용되지 않음.

    name : 필드와 매핑할 테이블 컬럼 이름 (default. 객체의 필드 이름)
    nullable (DDL) : null 값의 허용 여부 설정, false 설정 시 not null (default. true) @Column 사용 시 nullable = false 로 설정하는 것이 안전
    unique (DDL) : @Table 의 uniqueConstraints와 같지만 한 컬럼에 간단히 유니크 제약조건을 적용
    columnDefinition (DDL) : 데이터베이스 컬럼 타입을 직접 지정. default 값 설정 (default. 필드의 자바 타입과 방언 정보를 사용해 적절한 컬럼 타입을 생성)
    length (DDL) : 문자 길이. String 타입에만 사용 (default. 255)
    percision, scale (DDL) : BigDecimal, BigInteger 타입에서 사용. 아주 큰 숫자나 정밀한 소수를 다룰 때만 사용(default. precision = 19, scale = 2)
     */
    @Column(name = "emp_no", nullable = false)
    private int empNo;

    @Column(name = "birth_date", nullable = false)
    private Date birthDate;

    @Column(name = "first_name", nullable = false, length = 14)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 16)
    private String lastName;

    @Column(name = "gender", nullable = false)
    private String gender;

    @Column(name = "hire_date", nullable = false)
    private Date hireDate;


}
