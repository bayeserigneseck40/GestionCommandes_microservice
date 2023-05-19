package com.example.serviceclient.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.example.serviceclient.model.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

}
