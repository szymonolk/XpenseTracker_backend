package com.example.XpenseTracker.controllers;

import com.example.XpenseTracker.models.ExpenseModel;
import com.example.XpenseTracker.services.ExpenseServices;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RequestMapping("/api/expenses")
@RestController
public class XpenseController {

    private final ExpenseServices expenseServices;

    public XpenseController(ExpenseServices expenseServices) {
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
    public Optional<ExpenseModel> findExpenseById(@RequestParam Long id){
        return expenseServices.findExpenseById(id);
    }
}
