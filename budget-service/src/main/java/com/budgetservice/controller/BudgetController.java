package com.budgetservice.controller;

import com.budgetservice.model.Budget;
import com.budgetservice.repository.BudgetRepo;
import com.budgetservice.service.BudgetService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("budgets")
public class BudgetController {
    BudgetService budgetService;

    public BudgetController(BudgetService budgetService) {
        this.budgetService = budgetService;
    }

    @PostMapping("")
    public Budget add(@RequestBody Budget budget) throws Exception {
        return budgetService.add(budget);
    }
    @PutMapping("")
    public Budget update(@RequestBody Budget budget) throws Exception{
        return budgetService.update(budget);
    }
    @GetMapping("/rechercheByNom/{nom}")
    public Budget recherche(@PathVariable String nom) throws Exception {
        return budgetService.recherche(nom);
    }
    @GetMapping("/{id}")
    public Budget rechercheById(@PathVariable Long id) throws Exception {
        System.out.println("id=====> "+id);
        return budgetService.rechercheById(id);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        budgetService.delete(id);
    }
    @GetMapping("")
    public List<Budget> all() throws Exception {
        return budgetService.all();
    }
}
