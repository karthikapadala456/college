package College.State.College.Service;


import College.State.College.Model.College;
import College.State.College.Repository.CollegeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollegeService {
    @Autowired
    CollegeRepo collegeRepo;

    public College collegeAdd(College college) {
        return collegeRepo.save(college);
    }

    public List<College> getAllCollege() {
        String college = new String();
        System.out.println("Getting data from db : " + college);
        return (List<College>) collegeRepo.findAll();
    }

    public College getCollegeById(Long id) {
        return collegeRepo.findById(id).get();

    }

    public void delete(Long id) {
        collegeRepo.deleteById(id);
    }

    public College update(College college, Long id) {
        return collegeRepo.save(college);
    }



}



