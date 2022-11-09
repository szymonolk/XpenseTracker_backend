package com.example.XpenseTracker.models;
import javax.persistence.*;

import com.example.XpenseTracker.LocalDateConverter;
import com.expenseTracker.expenseTracker.models.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity (name = "expenses")
public class ExpenseModel extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    private Integer cost;
    private String expenseName;
    @Setter
    private String priority;
    private String description;

    @Override
    public String toString() {
        return "ExpenseModel{" +
                "id=" + id +
                ", cost='" + cost + '\'' +
                ", expenseName='" + expenseName + '\'' +
                ", priority='" + priority + '\'' +
                '}';
    }
}
