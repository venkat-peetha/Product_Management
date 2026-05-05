package com.satya.mvcproject.Controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.satya.mvcproject.Models.Product;
import com.satya.mvcproject.Serviece.ProductServiece;

import jakarta.persistence.criteria.Path;







@Controller
public class ProductController {
	@Autowired
	ProductServiece productServiece;
	
	@GetMapping("/Products")
    public String getAddProductForm(Model model) 
	{
		Product product = new Product();
		model.addAttribute("product", product);
        return "add-product";
	}
	
	/*@PostMapping("/product/save")
	public String saveProductData(@ModelAttribute Product product,Model model)
	{
		Product saveProduct = productServiece.saveProductData(product);
		
		if(saveProduct!= null) 
		{
			model.addAttribute("SuccessMessage","Product saved SuccessFully...");
		}
		else 
		{
			model.addAttribute("ErrorMessage","Product saved Fail...");
		}
		return "product-insertion-status";
		
	}*/
	
	@GetMapping("/getall")
	public String showProducts(Model model) {
	    List<Product> productList = productServiece.getAllProducts();
	    model.addAttribute("products", productList);
	    return "product-list";
	}
	
	 @GetMapping("/search-page")
	    public String showSearchPage() {
	        return "search-product";
	    }
	 
	 @GetMapping("/search")
	    public String searchProduct(@RequestParam("id") Long id, Model model) {
	        Optional<Product> productOpt = productServiece.getProductById(id);

	        if (productOpt.isPresent()) {
	            model.addAttribute("product", productOpt.get());
	        } else {
	            model.addAttribute("errorMessage", "Product ID not found!");
	        }

	        return "search-product";
	    }
	 
	 @PostMapping("/product/save")
	 public String saveProduct(@ModelAttribute Product product,@RequestParam("imageFile") MultipartFile imageFile, RedirectAttributes redirectAttributes) {
		 String uploadDir = "uploads/"; 
	        File directory = new File(uploadDir);
	        if (!directory.exists()) {
	            directory.mkdirs(); // ✅ make all dirs
	        }

	        String imageName = imageFile.getOriginalFilename();
	        java.nio.file.Path destinationPath = Paths.get(uploadDir, imageName);

	        try {
	            Files.copy(imageFile.getInputStream(), destinationPath, StandardCopyOption.REPLACE_EXISTING);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }

	        product.setImageUrl(imageName);
	        
	     Product savedProduct = productServiece.saveProductData(product);
	     redirectAttributes.addFlashAttribute("SuccessMessage", "Product updated successfully!");
	     if (savedProduct != null) {
	         redirectAttributes.addFlashAttribute("SuccessMessage", "Product saved successfully!");
	     } else {
	         redirectAttributes.addFlashAttribute("ErrorMessage", "Product save failed!");
	     }

	     return "redirect:/getall";
	 }

	 @GetMapping("/product/delete/{id}")
	 public String deleteById(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
		 productServiece.deleteById(id);
	     redirectAttributes.addFlashAttribute("deleteMsg", "Product deleted successfully.");
	     return "redirect:/getall";
	 }

	 @GetMapping("/product/edit/{id}")
	 public String editProductForm(@PathVariable Long id, Model model) {
	    Product product = productServiece.getProductById1(id);
	     model.addAttribute("product", product);
	     return "edit-product"; // This will open edit-product.html
	 }
	 
	 @PostMapping("/product/update")
	 public String updateProduct(@ModelAttribute Product product,
	                             RedirectAttributes redirectAttributes) {
	     productServiece.saveProductData(product);
	     redirectAttributes.addFlashAttribute("SuccessMessage", "Product updated successfully!");
	     return "redirect:/getall";
	 }




}
