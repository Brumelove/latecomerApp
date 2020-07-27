package com.exquis.latecomerapp.usecase.repository;

import com.exquis.latecomerapp.domain.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.function.Predicate;

@Repository
@CrossOrigin
@RepositoryRestResource( path = "employees")
@QuerydslPredicate
public interface EmployeeRepo extends PagingAndSortingRepository<Employee, Long>,
        QuerydslPredicateExecutor<Employee> {
    Page<Employee> findBy(Predicate predicate, Pageable pageable);

}
