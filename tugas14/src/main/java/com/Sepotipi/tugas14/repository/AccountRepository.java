package com.Sepotipi.tugas14.repository;

import com.Sepotipi.tugas14.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, String> {
}
