package com.login.dao;



import java.sql.SQLException;

import javax.sql.DataSource;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional
public class UserRoleDAO extends JdbcDaoSupport {
	
	//@Autowired
	//private DataSource dataSource;
	/*
	@Autowired
    private EntityManager entityManager;
	*/
	 @Autowired
	    public UserRoleDAO(DataSource dataSource) {
	        this.setDataSource(dataSource);
	    }

	//public UserRoleDAO() {
		// TODO Auto-generated constructor stub
	//}

	  
    public void delete(long id) throws DataAccessException, SQLException   {
    	
          String sql = "DELETE FROM XX_USER_ROLE1 where USER_ID = "+ id +" " ;//
      
     
        
         this.getJdbcTemplate().update(sql); 
    		
    }

}