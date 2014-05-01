package com.highrise.app;

import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.highrise.model.Layout;
import com.highrise.service.ILayoutService;
import com.highrise.service.LayoutNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

/**
*
* @author Nikhitha, April 19, 2014
*/


@Controller
public class LayoutController extends MultiActionController{

	@Autowired
	private ILayoutService layoutService;
	
	public void setLayoutService(ILayoutService layoutService) {
		this.layoutService = layoutService;
	}



	@RequestMapping("/Layoutview")
    public ModelAndView view(final Model model, HttpServletRequest request,
            HttpServletResponse response) throws IOException,
            HttpRequestMethodNotSupportedException, ServletRequestBindingException
    {
        if (!request.getMethod().equals(METHOD_GET))
        {
            throw new HttpRequestMethodNotSupportedException("The requested method is not supported");
        }
       Integer id = ServletRequestUtils.getIntParameter(request, "id") ;
        return new ModelAndView("Layoutview", "layout",layoutService.getLayoutById(new Integer(id)));
    }
	
	
	
	@RequestMapping("/LayoutviewAll")
    public ModelAndView viewAllLayout(final Model model) {
	 	List<Layout> layoutList =layoutService.getAllLayout();
		return new ModelAndView("LayoutviewAll", "layoutList", layoutList);
	  }
 

	@ResponseBody
    @RequestMapping("/getAllLays")
 public Map<String, Object[]> getAllLayout()
 {
	 
	 try{
		 List<Layout> lData=  layoutService.getAllLayout();
         if (lData == null) {
             throw new  LayoutNotFoundException("Unable to fetch all Layouts - ");
         }
         return Collections.singletonMap("lData", getJSONForLay(lData));
      
     }catch(LayoutNotFoundException se){
         throw new LayoutNotFoundException("Unable to fetch all Layouts  ");
     }

 }
  
    
	/**
     * I only want certain Layouts info..
     */
     public Object[] getJSONForLay(Collection<Layout> lays){
         Object[] rdArray = new Object[lays.size()];
         int i = 0;
         for(Layout u:lays){
        	 Object[] us = new String[]{
        			 u.getLayout_description()
        			};
        	 System.out.println(rdArray[i]);     
        	 rdArray[i] = us;                 
	             i++;           
	         }
         
	         return rdArray;
    }

    
}
