package com.budgetservice.service;


import com.budgetservice.model.Budget;

import java.util.List;

public interface BudgetService {

    public Budget add(Budget bdget) throws Exception;
    public Budget update(Budget budget) throws Exception;
    public Budget recherche(String nom) throws Exception;
    public Budget rechercheById(Long id) throws Exception;
    public void delete(Long id);
    public List<Budget> all() throws Exception;
}
