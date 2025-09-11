package org.example.livedemoiot2025.repos;

import org.example.livedemoiot2025.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<Customer, Long> {

}
