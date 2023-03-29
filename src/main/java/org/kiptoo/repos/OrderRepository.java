package org.kiptoo.repos;

import org.kiptoo.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    //TODO: implement missing method
   // List<Order> findByCustomerId();
    Optional<Order> findByPaymentId(Long id);
}