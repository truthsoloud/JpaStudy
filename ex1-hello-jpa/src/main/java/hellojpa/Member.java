package hellojpa;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Member {

    //pk매핑
    @Id
    private Long id;

    //객체는 username이라고 쓰고 싶고 db에는 name이라고 쓰고 싶을 때
    //db column명은 name
    @Column(name = "name", nullable = false) //not null 제약조건
    private String username;

    private Integer age;

    @Enumerated(EnumType.STRING)
    private RoleType roleType;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

    //db에 varchar를 넘어서는 큰 컨텐츠를 넣고 싶을 때 Lob사용
    @Lob
    private String description;

    @Transient
    private int temp;

    public Member() {
    }
}
