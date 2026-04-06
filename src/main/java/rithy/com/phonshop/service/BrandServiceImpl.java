package rithy.com.phonshop.service;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import rithy.com.phonshop.dto.BrandDTO;
import rithy.com.phonshop.entity.Brand;
import rithy.com.phonshop.exception.ResourceNotFoundException;
import rithy.com.phonshop.repository.BrandRepository;
import rithy.com.phonshop.util.BrandMapper;
@AllArgsConstructor
@Service
public class BrandServiceImpl  implements BrandService{
	@Autowired
	private final BrandRepository brandRepository;
	private final BrandMapper brandMapper;
	@Override
	public BrandDTO createBrandDTO(BrandDTO brandRequestDTO) {
		Brand brand = brandMapper.toEntity(brandRequestDTO);
		Brand saveBrand = brandRepository.save(brand);
		return brandMapper.toDTO(saveBrand);
	}
	@Override
	public BrandDTO getBrandById(Long id) {
		Brand brand = brandRepository.findById(id)
	            .orElseThrow(() -> new ResourceNotFoundException("Brand not found with id: " + id));
	    return brandMapper.toDTO(brand);
	}
	@Override
	public List<BrandDTO> getAllBrand() {
		List<Brand> brand = brandRepository.findAll();
		return brand.stream()
				.map(brandMapper::toDTO)
				.collect(Collectors.toList());
	}
	@Override
	public BrandDTO updateBrandDTO(Long id, BrandDTO brandUpdateDTO) {
		Brand brand =brandRepository.findById(id)
				.orElseThrow(()->new ResourceNotFoundException("Brand not found with id: " + id));
		brand.setName(brandUpdateDTO.getName());
		Brand updateBrand = brandRepository.save(brand);
		return brandMapper.toDTO(updateBrand);
	}
	@Override
	public List<BrandDTO> getBrandsByName(String name) {
		List<Brand> brands = brandRepository.findByNameContaining(name);
		return brands.stream()
		        .map(brandMapper::toDTO) // ខ្លី ស្អាត និងមិនបាច់បារម្ភរឿងដាក់ឈ្មោះ Variable
		        .collect(Collectors.toList());
	}
	@Override
	public void delete(Long id) {
		Brand brand=brandRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Brand not found with id: " + id));
		brandRepository.delete(brand);
	}

//	@Override
//	public void delete(Long id) {
//		brandRepository.deleteById(id);
//	}
	

	
	/*
	 * @Override
	   public Brand create(Brand brand) {
	   return brandRepository.save(brand);
	   	}
	 * Call Directly Logic DTO 
	Brand brand = new Brand();
	brand.setName(brandRequestDTO.getName());
	Brand saveBrand = brandRepository.save(brand);
	BrandDTO reSponeDto = new BrandDTO();
	reSponeDto.setName(saveBrand.getName());
	return reSponeDto;
	 */
	
}
