package my.mycompany.myapp.repository.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import my.mycompany.myapp.domain.User;
import my.mycompany.myapp.repository.IUserDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class UserDaoImpl implements IUserDao {
	private JdbcTemplate jdbcTemplate;
	private SimpleJdbcInsert insertProduct;
	
	@Autowired
	private void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		this.insertProduct = new SimpleJdbcInsert(dataSource).withTableName("users")
				.usingColumns("userid", "email", "passphrase", "salt", "date_created", "description")
				.usingGeneratedKeyColumns("id");		
	}
	
	@Override
	public boolean exists(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public User findOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User insert(User entity) {
		Map<String, Object> parameters = new HashMap<String, Object>(6);
        parameters.put("userid", entity.getUserId());	      
        parameters.put("email", entity.getEmail());
        parameters.put("description", entity.getDescription());
        parameters.put("passphrase", entity.getPassphrase());
        parameters.put("salt", entity.getSalt());
        parameters.put("passphrase", entity.getPassphrase());
        parameters.put("date_created", entity.getCreatedDate());
        
        Number newId = insertProduct.executeAndReturnKey(parameters);
        entity.setId(newId.longValue());				
		return entity;
	}

	@Override
	public void update(User entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

}
