package likelion.springbootbbaco.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import org.hibernate.annotations.Comment;

@Entity
@Data
public class Member {
    @Id @GeneratedValue
    private Long id;

    private String name;

    private String city;
    private String state;
    private String street;
    private String zipcode;
}
