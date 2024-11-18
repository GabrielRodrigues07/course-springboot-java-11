package br.com.gabriel.course.services;

import br.com.gabriel.course.dto.OrderDTO;
import br.com.gabriel.course.repositories.OrderRepository;
import br.com.gabriel.course.services.exceptions.ResourceNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderService {

    private final ModelMapper modelMapper = new ModelMapper();

    @Autowired
    private OrderRepository repository;

    public List<OrderDTO> findAll() {
        return repository.findAll()
                .stream()
                .map(order -> modelMapper.map(order, OrderDTO.class))
                .collect(Collectors.toList());
    }

    public OrderDTO findById(Long id) {

        Optional<OrderDTO> obj = repository.findById(id)
                .map(order -> modelMapper.map(order, OrderDTO.class));
        if (obj.isPresent()) {
            return obj.get();
        } else {
            throw new ResourceNotFoundException(id);
        }
    }
}
