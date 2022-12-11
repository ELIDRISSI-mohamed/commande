package com.budgetservice.repository;

import com.budgetservice.model.Budget;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BudgetRepo extends JpaRepository<Budget, Long> {
    Budget findByNom(String nom);
}
