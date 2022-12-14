package com.example.XpenseTracker.controllers;

import com.example.XpenseTracker.exceptions.ResourceNotFoundException;
import com.example.XpenseTracker.models.ExpenseModel;
import com.example.XpenseTracker.services.ExpenseServices;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RequestMapping("/api/expenses")
@RestController
public class ExpenseController {

    private final ExpenseServices expenseServices;

    public ExpenseController(ExpenseServices expenseServices) {
        this.expenseServices = expenseServices;
    }


    @CrossOrigin
    @PostMapping("/create")
    public ExpenseModel createNewExpense(@RequestBody ExpenseModel expenseModel) {
        System.out.println(expenseModel.toString());
        return expenseServices.createNewExpense(expenseModel);
    }

    @CrossOrigin
    @GetMapping("/find/all")
    public List<ExpenseModel> findAllExpenses(){
        return expenseServices.findAllExpenses();
    }

    @CrossOrigin
    @GetMapping("/find/{id}")
    public Optional<ExpenseModel> findExpenseById(@PathVariable Long id) throws ResourceNotFoundException {
        return expenseServices.findExpenseById(id);
    }

    @CrossOrigin
    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id){
        expenseServices.deleteById(id);
    }
}
