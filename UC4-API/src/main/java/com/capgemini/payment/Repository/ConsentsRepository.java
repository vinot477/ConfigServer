package com.capgemini.payment.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.payment.model.Consents;

public interface ConsentsRepository extends JpaRepository<Consents,Integer> {

}
