package it.marczuk.restapicar.repository;

import it.marczuk.restapicar.model.Car;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

    @Query("select c from cars c" +
            " left join fetch c.engine")
    List<Car> findAllCars(Pageable page);
}
