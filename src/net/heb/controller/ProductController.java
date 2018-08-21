package net.heb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import net.heb.interfaces.IProductService;
import net.heb.model.Product;


@Controller
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private IProductService productService;
	
	/**
	 * GET HTTP method for returning product page. Auto retrieves into Product data.
	 * @return ModelAndView with Product data.
	 */
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView getProducts() {
		ModelMap modelMap = new ModelMap();
		Product product = new Product();
		
		productService.setProducts(product);
		
		modelMap.addAttribute(product);
		
		return new ModelAndView("product", modelMap);
	}
	
	/**
	 * POST HTTP method for filtering Product data depending on what was chosen.
	 * @param product
	 * @return ModelAndView with Product data that has been filtered by user chosen criteria.
	 */
	@RequestMapping(method=RequestMethod.POST, params="filter")
	public ModelAndView filterTable(@ModelAttribute("product") Product product) {
		ModelMap modelMap = new ModelMap();
		
		productService.filterProducts(product);
		
		modelMap.addAttribute(product);
		
		return new ModelAndView("product", modelMap);
	}
	
	/**
	 * POST HTTP method for reseting what was filtered. Resets back to initial state
	 * with similar in output to initial retrieve of page.
	 * @param product
	 * @return ModelAndView with Product data.
	 */
	@RequestMapping(method=RequestMethod.POST, params="reset")
	public ModelAndView resetTable(@ModelAttribute("product") Product product) {
		ModelMap modelMap = new ModelMap();
		product = new Product();
		
		productService.setProducts(product);
		
		modelMap.addAttribute(product);
		
		return new ModelAndView("product", modelMap);
	}
	
	/**
	 * Provides product ID values in a list used in drop down.
	 * @return List of product IDs
	 */
	@ModelAttribute("productIDList")
	public List<String> getProductList() {
		return productService.getListByFieldName("productID");
	}
	
	/**
	 * Provides description values in a list used in drop down.
	 * @return List of of product descriptions.
	 */
	@ModelAttribute("descriptionList")
	public List<String> getDescriptionList() {
		return productService.getListByFieldName("description");
	}
	
	/**
	 * Provides department values in a list used in drop down.
	 * @return List of department.
	 */
	@ModelAttribute("departmentList")
	public List<String> getDepartmentList() {
		return productService.getListByFieldName("department");
	}
	
	/**
	 * Provides shelf life values in a list used in drop down.
	 * @return List of shelf life values.
	 */
	@ModelAttribute("shelfLifeList")
	public List<String> getShelfLifeList() {
		return productService.getListByFieldName("shelfLife");
	}
}
