package com.highrise.app;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import com.highrise.model.Layout;
import com.highrise.service.ILayoutService;
import com.highrise.service.LayoutNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
*
* @author Nikhitha, April 19, 2014
*/


@Controller
public class AddEditLayoutFormController {
	
	 @Autowired
	 private ILayoutService layoutService;
	 
	 public ILayoutService getLayoutService() {
		return layoutService;
	}

	public void setLayoutService(ILayoutService layoutService) {
		this.layoutService = layoutService;
	}

	private ModelMap modelMap = new ModelMap();
	    
	    /** Creates a new instance of AddChildFormController */
	    public AddEditLayoutFormController()
	    { }

	    
	    @RequestMapping(value="/Layoutadd", method=RequestMethod.GET)
		public ModelAndView createLayoutPage(ModelMap modelMap)  {
		 	ModelAndView mav = new ModelAndView("Layoutadd");
			mav.addObject("layout", new Layout());
			return mav;
			
		}
	    
	       
	    @RequestMapping(value = "/Layoutadd", method=RequestMethod.POST)
	    public String addProject(@ModelAttribute("Layoutadd") @Valid Layout layout, BindingResult result,
	    		HttpServletRequest request,final RedirectAttributes redirectAttributes) throws Exception {
	    	
	    	Integer id = ServletRequestUtils.getIntParameter(request, "id");
	 	   if(id != null)
	        {
	 		  layout = layoutService.getLayoutById(id);
	            if(layout != null)
	         	  return  "view";
	                
	            else
	                throw new LayoutNotFoundException();
	        } 	   
	 	   
	 	 	if (result.hasErrors()) 
	        {                
	    	     return "Layoutadd";
	        }
	    	String message = "New Layout "+ layout.getLayout_description()+" was successfully created.";  
	    	layoutService.saveLayout(layout);
	    	redirectAttributes.addFlashAttribute("message", message); 
	    	System.out.println(layout.getLayout_description());
	       
	    	return "redirect:/LayoutviewAll.html";
	    }
	    
	    
	    @RequestMapping(value="/Layoutedit", method=RequestMethod.GET)
	    public ModelAndView edit( @RequestParam("id")Integer id)
	    {
	    	Layout layout = layoutService.getLayoutById(id);
	        ModelAndView mav = new ModelAndView("Layoutedit"); 
	        mav.addObject("editLayout",layout);
	        return mav;
	    }

	    @RequestMapping(value="/Layoutedit", method=RequestMethod.POST)
	    public String update(@ModelAttribute   @Valid Layout layout, BindingResult result,
	    		SessionStatus status)
	    {
	    	
	        if (result.hasErrors()) 
	        {                
	            return "Layoutedit";
	        }
	        layoutService.updateLayout(layout);
	        status.setComplete();
	        System.out.println("updated  " +layout.getLayout_description());
	        return "redirect:/LayoutviewAll.html";
	    }

	    @RequestMapping("Layoutdelete")
	    public ModelAndView Layoutdelete(@ModelAttribute   @Valid Layout layout)
	    {
	    	layoutService.deleteLayout(layout);
	    	ModelAndView mav = new ModelAndView("redirect:/LayoutviewAll.html");        
	        return mav;
	    }
}
