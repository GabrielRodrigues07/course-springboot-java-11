package br.com.gabriel.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.gabriel.course.entities.OrderItem;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{
}
