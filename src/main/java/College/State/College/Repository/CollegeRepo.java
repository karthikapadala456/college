package College.State.College.Repository;

import College.State.College.Model.College;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CollegeRepo extends CrudRepository<College, Long> {

}
