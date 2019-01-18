package com.login.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.login.dao.UserRoleDAO;
import com.login.model.AppRole;
import com.login.model.AppUser;
import com.login.model.UserRole;
import com.login.repository.AppRoleRepository;
import com.login.repository.AppUserRepository;
import com.login.repository.UserRoleRepository;


@Service
public class AppUserServiceImpl {
	@Autowired
	private AppUserRepository repository;
	@Autowired
	private AppRoleRepository repository2;
	@Autowired
	private UserRoleRepository repository1; 
	@Autowired
	private DataSource dataSource;
	public List<AppUser> findAll() {
		return repository.findAll().stream()
	            .map(entity -> new AppUser(entity.getUserId(), entity.getUserName(), entity.getEncrytedPassword(),entity.isEnabled()))
	            .collect(Collectors.toList());
	    }

	    @Transactional
	    public AppUser create(AppUser user) throws SQLException {
	    	AppUser newUser = new AppUser();
	    	//newUser.setUserId(user.getUserId());
	        newUser.setUserName(user.getUserName());
	        newUser.setEncrytedPassword(user.getEncrytedPassword());
	        newUser.setEnabled(user.isEnabled());
	        AppUser saveduser = repository.save(newUser);
	       // UserRoleDAO userrole= new UserRoleDAO();
	        long a=saveduser.getUserId();
	        
			
			
	        //long aze= userrole.insert();
			//System.out.println(aze);
				// TODO Auto-generated catch block
				
	        //UserRoleDAO test =new UserRoleDAO();
	        //test.getmaxvalue(saveduser.getUserId(),(long) 2);
	        AppRole role =findOneRole((long) 2);
	        UserRole abc =new UserRole((long)0,saveduser,role);
	        repository1.save(abc);
	        return saveduser;
	    }

	    @Transactional
	    public AppUser update(Long id, AppUser user) {
	    	AppUser appuser = findOneSafe(id);
	        appuser.setUserName(user.getUserName());
	        appuser.setEnabled(user.isEnabled());
	        return new AppUser(appuser.getUserId(),appuser.getUserName(),appuser.getEncrytedPassword(),appuser.isEnabled());
	    }
	
	
	
	
	
	@Transactional
    public void delete(Long id) throws DataAccessException, SQLException {
		 UserRoleDAO test =new UserRoleDAO(dataSource);
	    // test.delete(id);
		test.delete(id);
        repository.deleteById(id);
    }

   /* private Optional<AppUser> findOneSafe(Long id) {
    	Optional<AppUser> user = repository.findById(id);
            return user;
    }
	*/
	private AppUser findOneSafe(Long id) {
		Optional<AppUser> user = repository.findById(id);
	     AppUser appuser =user.get();
	     return appuser;
	    }
	private AppRole findOneRole(Long id) {
		Optional<AppRole> user = repository2.findById(id);
		AppRole appuser =user.get();
	     return appuser;
	    }
	
}
