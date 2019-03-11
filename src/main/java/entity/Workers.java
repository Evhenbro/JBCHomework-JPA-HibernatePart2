package entity;

import lombok.*;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
@Table(name = "workers")
public class Workers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer age;

    @Enumerated(EnumType.STRING)
    private Availability availability;

    private String fullName;

    @ManyToOne(fetch = FetchType.LAZY)
    private Department departmentId;

    public Workers(Integer age, Availability availability, String fullName) {
        this.age = age;
        this.availability = availability;
        this.fullName = fullName;
    }

    public Workers(Integer age, Availability availability, String fullName, Department departmentId) {
        this.age = age;
        this.availability = availability;
        this.fullName = fullName;
        this.departmentId = departmentId;
    }
}
