package College.State.College;

import College.State.College.Model.College;
import College.State.College.Repository.CollegeRepo;
import College.State.College.Service.CollegeService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;


@SpringBootTest
@RunWith(SpringRunner.class)
public class CollegeTest {
    @InjectMocks
    private CollegeService collegeService;

    @Mock
    private CollegeRepo collegeRepo;
  @Mock
  College college = new College();
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }
    @Test
    public void saveCollegeTest() {
       // College college=new College(128L, "Karthika", "Hyderabad", "EastGodavari");
        College college = new College();
        college.setId(128L);
        college.setName("Karthika");
        college.setCity("Hyderabad");
        college.setDistrict("EastGodavari");
        Mockito.when(collegeRepo.save(college)).thenReturn(college);
        College college1=collegeService.collegeAdd(college);
        assertEquals(college,college1);
    }

    @Test
    public void getCollegeTest()
    {
        Mockito.when(collegeRepo.findAll()).thenReturn(Stream.of(new College(126L,"ISTS","Kakinada","EastGodavari")).collect(Collectors.toList()));
        assertEquals(1,collegeService.getAllCollege().size());
    }

    @Test
    public void getCollegeByIdTest()
    {
        Long id= 124L;
        College college = new College(124L,"Samhitha Degree College","Rajahmundry","East Godavari");

        Mockito.when(collegeRepo.findById(id)).thenReturn(Optional.of(college));
        assertEquals(college, collegeService.getCollegeById(id));
    }

    @Test
    public void updateTest() {
        College college = new College(4L, "Adithya", "Peddapuram", "EastGodavari");
        Mockito.when(collegeRepo.save(college)).thenReturn(college);
        assertEquals(college, collegeService.update(college, college.getId()));
    }
@Test
    public void deleteTest()
{
    College college=new College(10L, "Adithya", "Peddapuram", "EastGodavari");
    collegeService.delete(college.getId());
    Mockito.verify(collegeRepo,times(1)).deleteById(college.getId());
}
}
