package com.highrise.dao;

import java.util.List;
import com.highrise.model.Layout;


/**
*
* @author Nikhitha , April 19-2014
*/
public interface ILayoutDao {
	Layout getLayoutById(Integer id);
    List<Layout> getAllLayout();
    void saveLayout(Layout layout);
    void updateLayout(Layout layout);
    void deleteLayout(Layout layout);
	
}
