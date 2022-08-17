package com.Assistance_Supporter.server.repository;

import com.Assistance_Supporter.server.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, String> {
}
