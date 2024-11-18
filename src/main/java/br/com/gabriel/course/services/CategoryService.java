package br.com.gabriel.course.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import br.com.gabriel.course.dto.CategoryDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gabriel.course.entities.Category;
import br.com.gabriel.course.repositories.CategoryRepository;

@Service
public class CategoryService {

	private final ModelMapper modelMapper = new ModelMapper();

	@Autowired
	private CategoryRepository repository;
	
	public List<CategoryDTO> findAll() {
		return repository.findAll()
				.stream()
				.map(category -> modelMapper.map(category, CategoryDTO.class))
				.collect(Collectors.toList());
	}
	
	public CategoryDTO findById(Long id) {
		Optional<Category> obj = repository.findById(id);
		return modelMapper.map(obj.get(), CategoryDTO.class);
	}
}
