package br.com.gabriel.course.services;

import br.com.gabriel.course.dto.ProductDTO;
import br.com.gabriel.course.repositories.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {

	private final ModelMapper modelMapper = new ModelMapper();

	@Autowired
	private ProductRepository repository;
	
	public List<ProductDTO> findAll() {
		return repository.findAll()
				.stream()
				.map(product -> modelMapper.map(product, ProductDTO.class))
				.collect(Collectors.toList());
	}
	
	public ProductDTO findById(Long id) {
		Optional<ProductDTO> productDTO = repository.findByIdWithCategories(id)
				.map(product -> modelMapper.map(product, ProductDTO.class));
		return productDTO.get();
	}
}
