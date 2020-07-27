package com.exquis.latecomerapp.usecase.repository;

import com.exquis.latecomerapp.domain.EmployeeEntity;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

@Repository
@CrossOrigin
@RepositoryRestResource( path = "employees")
@QuerydslPredicate
public interface EmployeeRepo extends PagingAndSortingRepository<EmployeeEntity, Long>,
        QuerydslPredicateExecutor<EmployeeEntity> {

}
