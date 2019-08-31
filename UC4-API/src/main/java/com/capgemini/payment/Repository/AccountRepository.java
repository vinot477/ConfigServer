package com.capgemini.payment.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.payment.model.Account;

public interface AccountRepository extends JpaRepository<Account, String> {

}
