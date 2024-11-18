package br.com.gabriel.course.services;

import br.com.gabriel.course.dto.UserDTO;
import br.com.gabriel.course.entities.User;
import br.com.gabriel.course.repositories.UserRepository;
import br.com.gabriel.course.services.exceptions.DatabaseException;
import br.com.gabriel.course.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final ModelMapper modelMapper = new ModelMapper();

    @Autowired
    private UserRepository repository;

    public List<UserDTO> findAll() {
        return repository.findAll()
                .stream()
                .map(user -> modelMapper.map(user, UserDTO.class))
                .collect(Collectors.toList());
    }

    public UserDTO findById(Long id) {
        Optional<User> obj = repository.findById(id);
        return obj.map(user -> modelMapper.map(user, UserDTO.class))
                .orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public UserDTO insert(UserDTO obj) {
        return Optional.ofNullable(obj)
                .map(userDTO -> modelMapper.map(userDTO, User.class))
                .map(user -> repository.save(user))
                .map(user -> modelMapper.map(user, UserDTO.class))
                .get();
    }

    public void delete(Long id) {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    public UserDTO update(Long id, UserDTO obj) {
        try {
            User entity = repository.getOne(id);
            updateData(entity, obj);
            return modelMapper.map(repository.save(entity), UserDTO.class);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateData(User entity, UserDTO obj) {
        entity.setName(obj.getName());
        entity.setEmail(obj.getEmail());
        entity.setPhone(obj.getPhone());
    }
}
