package com.highrise.dao.impl;


import java.util.List;


import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.highrise.connection.util.CustomHibernateDaoSupport;
import com.highrise.dao.ILayoutDao;
import com.highrise.model.Layout;


/**
*
* @author Nikhitha, April 19, 2014
*/

@Repository("layoutDao")

public class LayoutDaoImpl extends  CustomHibernateDaoSupport implements ILayoutDao{

	@Override
	public Layout getLayoutById(Integer id) {
		List list = getHibernateTemplate().find(
                "from Layout where layout_id=?",id);
	return (Layout)list.get(0);
	}

	@Override
	public List<Layout> getAllLayout() {
		List list = getHibernateTemplate().find(
                "from Layout");
	return (List<Layout>)list;
	}

	@Override
	public void saveLayout(Layout layout) {
		getHibernateTemplate().save(layout);
	}

	@Override
	public void updateLayout(Layout layout) {
		getHibernateTemplate().update(layout);
		
	}

	@Override
	public void deleteLayout(Layout layout) {
		getHibernateTemplate().delete(layout);
	}
	
}
	
	
	
	/*
	 * 
	 * import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
	private static final String GET_ALL_LAYOUT_SQL =
            "select * from layout  ";
    
	@Override
	public List<Layout> getAllLayout() {
		return getJdbcTemplate().query(GET_ALL_LAYOUT_SQL, new LayoutMapper());
	}
	
	

   private static final String GET_LAYOUT_SQL = "SELECT * FROM layout  WHERE layout_id  = ?";
   
   @Override
	public Layout getLayoutById(Integer id) {
	   try
       {
        return (Layout)getJdbcTemplate().queryForObject(GET_LAYOUT_SQL,new Object[]{id},new LayoutMapper());
       }
       catch (DataAccessException dae)
       {
           return null;
       }
	}
   
	     
    private static final String UPDATE_LAYOUT_SQL = "" +
    		"UPDATE layout set layout_description= ? " +
    		           "WHERE  layout_id  = ?";
    
    @Override
	public void updateLayout(Layout layout) {
    	Object[] parameters = new Object[]{
    			layout.getLayout_description(),layout.getLayout_id(),
    			};
    	getJdbcTemplate().update(UPDATE_LAYOUT_SQL, parameters);
    	System.out.println( " row(s) Updated.");
		
	}
  
    private static final String INSERT_LAYOUT_SQL=
            "INSERT INTO  layout (layout_description) values (?)";
    
    
    @Override
	public void saveLayout(Layout layout) {
    	Object[] parameters = 
                new Object[]{
    			layout.getLayout_description()
    			};
        getJdbcTemplate().update(INSERT_LAYOUT_SQL, parameters);
        System.out.println( " row(s) Added.");
		
	}
   

   private static final String DELETE_LAYOUT_SQL = "" +
            "DELETE FROM  layout  where layout_id = ?";
   
   @Override
	public void deleteLayout(Integer id) {
	   Object[] params = { id };
       int rows = getJdbcTemplate().update(DELETE_LAYOUT_SQL, params);
       System.out.println(rows + " row(s) deleted.");
	}
	
     // Here we implement the rowmapper callback
    // for mapping a single row to a domain object
    
    private class LayoutMapper implements RowMapper
    {
        public Object mapRow(ResultSet resultSet, int i) throws SQLException
        {
            
        	Layout layout= new Layout();
        	layout.setLayout_id(resultSet.getInt("layout_id"));
        	layout.setLayout_description(resultSet.getString("layout_description"));
         	 return layout;
        }
     }
*/
