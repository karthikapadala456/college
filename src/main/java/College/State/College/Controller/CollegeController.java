package College.State.College.Controller;
import College.State.College.Model.College;
import College.State.College.Service.CollegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CollegeController {
@Autowired
    CollegeService collegeService;

@PostMapping("/College")
    private College saveCollege(@RequestBody College college)
    {
        return collegeService.collegeAdd(college);
    }

@GetMapping("/college")
private List<College> getAllCollege()
{
    return collegeService.getAllCollege();
}

@GetMapping("college/{id}")
private College getCollege(@PathVariable("id")Long id)
{
    return collegeService.getCollegeById(id);
}


@DeleteMapping("/dcollege/{id}")
private void deleteCollege(@PathVariable("id") Long id )

{
    collegeService.delete(id);
}

@PutMapping("/COLLEGE/{id}")
    private College update(@RequestBody College college, Long id)
{
    collegeService.update(college,id);
    return college;
}
}
