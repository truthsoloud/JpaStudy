package jpabook.jpashop.domain;

import org.hibernate.annotations.Parent;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Category {

    // id
    @Id @GeneratedValue
    @Column(name = "CATEGORY_ID")
    private Long id;
    // name
    private String name;

//    items(N:M 매핑)
    @ManyToMany
    @JoinTable(name = "CATEGORY_ITEM",
        joinColumns = @JoinColumn(name = "CATEGORY_ID"),
        inverseJoinColumns = @JoinColumn(name = "ITEM_ID")
    )
    private List<Item> items = new ArrayList<>();

//    parent 이거는 셀프매핑이라고 보면 됨
    @ManyToOne
    @JoinColumn(name = "PARENT_ID")
    private Category parent;

//    child를 parent랑 양방향으로
    @OneToMany(mappedBy = "parent")
    private List<Category> child = new ArrayList<>();
}
