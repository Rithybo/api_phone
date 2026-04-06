package rithy.com.phonshop.util;

import org.springframework.stereotype.Component;

import rithy.com.phonshop.dto.BrandDTO;
import rithy.com.phonshop.entity.Brand;
@Component
public class BrandMapper {
	public  Brand toEntity(BrandDTO brandDTO)  {
		if(brandDTO == null) return null;
		Brand brand = new Brand(); 
		brand.setId(brandDTO.getId());
		brand.setName(brandDTO.getName());
		return brand;
	}
	public BrandDTO toDTO(Brand brand) {
		if(brand ==null) return null;
		BrandDTO brandDTO = new BrandDTO();
		brandDTO.setId(brand.getId());
		brandDTO.setName(brand.getName());
		return brandDTO;
	}
}
