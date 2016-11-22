package com.aartek.prestigepoint.repositoryImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;


import org.springframework.stereotype.Repository;


import com.aartek.prestigepoint.model.LoginDto;
import com.aartek.prestigepoint.repository.LoginRepository;








@Repository
public class LoginRepositoryImpl implements LoginRepository {
	
	@Autowired
	private HibernateTemplate hibernateTemplate;
	

	
	









	public List<LoginDto> checkLogin(LoginDto loginDto) {
		if (loginDto.getEmail_id() != null && loginDto.getPassword()!= null) {
			//System.out.println(loginDto.getEmail_id()+" "+loginDto.getPassword());
			List<LoginDto> login = hibernateTemplate.find(
					"from LoginDto  where email_id = ? and password = ?", loginDto.getEmail_id(), loginDto.getPassword());
			return login;
		}
		
		else {
			return null;
		}
	}



	

}
