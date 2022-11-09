package com.example.XpenseTracker.services;

import com.example.XpenseTracker.exceptions.ResourceNotFoundException;
import com.example.XpenseTracker.models.ExpenseModel;
import com.example.XpenseTracker.repositories.ExpenseRepository;
import org.springframework.stereotype.Service;
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

    public Optional<ExpenseModel> findExpenseById(Long id) throws ResourceNotFoundException {
        Optional<ExpenseModel> expenseModel = expenseRepository.findById(id);
        if (expenseModel.isPresent()){
            return expenseModel;
        }else
            throw new ResourceNotFoundException("Resource" + id + " cannot be found!");
    }

    public List<ExpenseModel> findAllExpenses(){
        return expenseRepository.findAll();
    }
}
