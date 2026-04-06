package rithy.com.phonshop.service;

import java.util.List;

import rithy.com.phonshop.dto.BrandDTO;


public interface BrandService {
//	Brand create(Brand brand);
	BrandDTO createBrandDTO(BrandDTO brandRequestDTO);
	BrandDTO getBrandById(Long id);
	List<BrandDTO> getAllBrand();
	List<BrandDTO> getBrandsByName(String name);
	BrandDTO updateBrandDTO(Long id,BrandDTO brandUpdateDTO);
	void delete(Long id);
}
