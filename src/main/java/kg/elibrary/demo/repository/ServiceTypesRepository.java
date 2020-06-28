package kg.elibrary.demo.repository;

import kg.elibrary.demo.entity.ServiceTypes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceTypesRepository extends JpaRepository<ServiceTypes, Long> {

}
