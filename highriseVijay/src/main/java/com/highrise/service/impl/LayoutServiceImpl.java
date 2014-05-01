package com.highrise.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Propagation;  


import com.highrise.dao.ILayoutDao;
import com.highrise.model.Layout;
import com.highrise.service.ILayoutService;

@Service("layoutBO")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)  
public class LayoutServiceImpl implements ILayoutService {

	@Autowired
	ILayoutDao layoutDao;
	// now we only have to call the dao object for completing our service
    
	public ILayoutDao getLayoutDao() {
		return layoutDao;
	}

	public void setLayoutDao(ILayoutDao layoutDao) {
		this.layoutDao = layoutDao;
	}

 	@Override
	public Layout getLayoutById(Integer id) {
			return getLayoutDao().getLayoutById(id);
	}

	
	@Override
	public List<Layout> getAllLayout() {
		return getLayoutDao().getAllLayout();
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void saveLayout(Layout layout) {
		getLayoutDao().saveLayout(layout);	
	}

	@Override

	public void updateLayout(Layout layout) {
		getLayoutDao().updateLayout(layout);
	}

	@Override

	public void deleteLayout(Layout layout) {
		getLayoutDao().deleteLayout(layout);
	}

}
