package com.example.XpenseTracker.services;

import com.example.XpenseTracker.models.ExpenseModel;
import com.example.XpenseTracker.repositories.ExpenseRepository;
import net.bytebuddy.asm.Advice;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ExpenseServices {

    private final ExpenseRepository expenseRepository;

    public ExpenseServices(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    public ExpenseModel createNewExpense(ExpenseModel expenseModel){
        switch (expenseModel.getPriority()) {
            case "Low" -> expenseModel.setPriority("Low");
            case "Medium" -> expenseModel.setPriority("Medium");
            case "High" -> expenseModel.setPriority("High");
            default -> throw new IllegalArgumentException("Illegal argument!");
        }
        return expenseRepository.save(expenseModel);
    }

    public List<ExpenseModel> findAllExpenses(){
        return expenseRepository.findAll();
    }

    public Optional<ExpenseModel> findExpenseById(Long id){
        return expenseRepository.findById(id);
    }
}
