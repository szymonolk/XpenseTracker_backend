package com.example.XpenseTracker.repositories;

import com.example.XpenseTracker.models.ExpenseModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpenseRepository extends JpaRepository<ExpenseModel, Long> {
}
