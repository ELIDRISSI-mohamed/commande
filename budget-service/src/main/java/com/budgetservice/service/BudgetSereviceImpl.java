package com.budgetservice.service;

import com.budgetservice.model.Budget;
import com.budgetservice.repository.BudgetRepo;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service @Transactional
public class BudgetSereviceImpl implements BudgetService{
    BudgetRepo budgetRepo;

    public BudgetSereviceImpl(BudgetRepo budgetRepo) {
        this.budgetRepo = budgetRepo;
    }

    @Override
    public Budget add(Budget budget) throws Exception {
        System.out.println(budget);
        if(budget.getBudget()==0.0 || budget.getNom()==null) throw new Exception("MISSING_PARAMS");
        return budgetRepo.save(budget);
    }

    @Override
    public Budget update(Budget budget) throws Exception {
        return budgetRepo.save(budget);
    }

    @Override
    public Budget recherche(String nom) throws Exception {
        Budget budget = budgetRepo.findByNom(nom);
        if (budget==null) throw new Exception("NO_ITEM_FOUND");
        return budget;
    }

    @Override
    public Budget rechercheById(Long id) throws Exception {
        Budget budget = budgetRepo.findById(id).get();
        System.out.println(budget);
        if (budget==null) throw new Exception("NO_ITEM_FOUND");
        return budget;
    }

    @Override
    public void delete(Long id) {
        budgetRepo.deleteById(id);
    }

    @Override
    public List<Budget> all() throws Exception {
        List<Budget> budgets = budgetRepo.findAll();
        if (budgets==null) throw new Exception("NO_DATA_FOUND");
        return budgets;
    }
}
