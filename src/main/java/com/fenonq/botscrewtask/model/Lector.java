package com.fenonq.botscrewtask.model;

import com.fenonq.botscrewtask.model.enums.Degree;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Lector {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    private BigDecimal salary;
    private Degree degree;

    @OneToOne(mappedBy = "headOfDepartment", cascade = CascadeType.ALL, orphanRemoval = true)
    private Department mainDepartment;

    @ManyToMany(cascade = CascadeType.ALL,
            mappedBy = "lectors", fetch = FetchType.EAGER)
    private Set<Department> departments;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Lector lector = (Lector) o;
        return id != null && Objects.equals(id, lector.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    @Override
    public String toString() {
        return "Lector{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", degree='" + degree + '\'' +
                ", salary=" + salary +
                ", department=" + mainDepartment +
                ", departments=" + departments +
                '}';
    }
}