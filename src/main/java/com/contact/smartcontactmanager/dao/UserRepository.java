package com.contact.smartcontactmanager.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.contact.smartcontactmanager.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
