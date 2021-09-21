package com.example.bookstoreSystem.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bookstoreSystem.model.Authority;
import com.example.bookstoreSystem.repository.AuthorityRepository;

@Service
public class AuthorityService {

	@Autowired
	private AuthorityRepository authorityRepository;
	
	public List<Authority> findById(Long id) {
		Authority authority = this.authorityRepository.findOneById(id);
		List<Authority> authorities = new ArrayList<>();
		authorities.add(authority);
		return authorities;
	}
	
	public List<Authority> findByName(String name) {
		Authority authority = this.authorityRepository.findOneByName(name);
		List<Authority> authorities = new ArrayList<>();
		authorities.add(authority);
		return authorities;
	}
}
