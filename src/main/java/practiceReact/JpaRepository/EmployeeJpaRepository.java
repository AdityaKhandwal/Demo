package practiceReact.JpaRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import practiceReact.entity.EmployeeEntity;

public interface EmployeeJpaRepository extends JpaRepository<EmployeeEntity, Integer> {

}
