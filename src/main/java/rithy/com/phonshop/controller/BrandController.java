package rithy.com.phonshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import rithy.com.phonshop.dto.BrandDTO;
import rithy.com.phonshop.service.BrandService;
@RestController
@RequestMapping("/api/brands")
public class BrandController {
	@Autowired
	private BrandService brandService;
	@PostMapping
	public ResponseEntity<?>  create(@RequestBody BrandDTO brandDTO) {
		BrandDTO saveBrand = brandService.createBrandDTO(brandDTO);
		return new ResponseEntity<>(saveBrand, HttpStatus.CREATED);
	}
	@GetMapping("/{id}")
	public ResponseEntity<?> getById(@PathVariable Long id) {
		 BrandDTO brandById = brandService.getBrandById(id);
		 return ResponseEntity.ok(brandById);
	
	}
	@GetMapping
	public ResponseEntity<List<BrandDTO>> getAll(){
		List<BrandDTO> list = brandService.getAllBrand();
		return ResponseEntity.ok(list);
	}
	@PutMapping("/{id}")
	public ResponseEntity<BrandDTO> updateBrand(@RequestBody BrandDTO updateBrandDTO,@PathVariable Long id){
		BrandDTO brandUpdate = brandService.updateBrandDTO(id, updateBrandDTO);
		return ResponseEntity.ok(brandUpdate);
	}
	@GetMapping("/search")
	public ResponseEntity<List<BrandDTO>> getByName(@RequestParam("name") String keyword){
			List<BrandDTO> brandsByName = brandService.getBrandsByName(keyword);
		return ResponseEntity.ok(brandsByName);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deEntity(@PathVariable long id){
		brandService.delete(id);
		return ResponseEntity.ok("Brand delete successfully with id:" + id);
	}
	/*
	 * Old Version 
	 * public Brand create(@RequestBody Brand brand) {
		return brandService.create(brand);
	}
	 */
}
