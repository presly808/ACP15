package university.service;

import org.junit.BeforeClass;
import org.junit.Test;
import university.dao.QueryCreator;
import university.models.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

public class ServiceTest {

    private static QueryCreator mockedQueryCreator;

    private static Service service;

    int offset = 1;
    int length = 10;

    private static Group testGroup;
    private static Student testStudent;
    private static SubjectCategory testSubjectCategory;
    private static Subject testSubject;
    private static Teacher testTeacher;

    @BeforeClass
    public static void setUp() throws Exception {
        int testId = 5;

        String testStudentsGroupName = "TestGroup";
        testGroup = new Group();
        testGroup.setId(testId);
        testGroup.setName(testStudentsGroupName);

        String testStudentsName = "TestStudent";
        testStudent = new Student();
        testStudent.setId(testId);
        testStudent.setName(testStudentsName);
        testStudent.setGroup(testGroup);

        String testSubjectCategoryName = "TestCategory";
        testSubjectCategory = new SubjectCategory();
        testSubjectCategory.setId(testId);
        testSubjectCategory.setTitle(testSubjectCategoryName);

        String testSubjectName = "TestSubject";
        String testSubjectDescription = "TestDescription";
        testSubject = new Subject();
        testSubject.setName(testSubjectName);
        testSubject.setCategory(testSubjectCategory);
        testSubject.setDescription(testSubjectDescription);

        String testTeacherName = "TestTeacher";
        int testTeacherExperience = 10;
        testTeacher = new Teacher();
        testTeacher.setName(testTeacherName);
        testTeacher.setExperience(testTeacherExperience);

        mockedQueryCreator = mock(QueryCreator.class);
        service = new ServiceImpl(mockedQueryCreator);


        when(mockedQueryCreator.addStudent(testStudent)).thenReturn(true);
        when(mockedQueryCreator.addGroup(testGroup)).thenReturn(true);
        when(mockedQueryCreator.addSubject(testSubject)).thenReturn(true);
        when(mockedQueryCreator.addTeacher(testTeacher)).thenReturn(true);

        when(mockedQueryCreator.editStudent(testStudent)).thenReturn(true);
        when(mockedQueryCreator.editGroup(testGroup)).thenReturn(true);
        when(mockedQueryCreator.editSubject(testSubject)).thenReturn(true);
        when(mockedQueryCreator.editTeacher(testTeacher)).thenReturn(true);
    }

    @Test
    public void getStudentsList() throws Exception {
        service.getStudentsList(offset, length);
        verify(mockedQueryCreator, times(1)).getStudentsList(offset, length);
    }

    @Test
    public void getSubjectsList() throws Exception {
        service.getSubjectsList(offset, length);
        verify(mockedQueryCreator, times(1)).getSubjectsList(offset, length);
    }

    @Test
    public void getGroupList() throws Exception {
        service.getGroupList(offset, length);
        verify(mockedQueryCreator, times(1)).getGroupList(offset, length);
    }

    @Test
    public void getTeachersList() throws Exception {
        service.getTeachersList(offset, length);
        verify(mockedQueryCreator, times(1)).getTeachersList(offset, length);
    }

    @Test
    public void addStudent() throws Exception {
        assertThat(service.addStudent(testStudent), is(true));
        verify(mockedQueryCreator, times(1)).addStudent(testStudent);
    }

    @Test
    public void addGroup() throws Exception {
        assertThat(service.addGroup(testGroup), is(true));
        verify(mockedQueryCreator, times(1)).addGroup(testGroup);
    }

    @Test
    public void addSubject() throws Exception {
        assertThat(service.addSubject(testSubject), is(true));
        verify(mockedQueryCreator, times(1)).addSubject(testSubject);
    }

    @Test
    public void addTeacher() throws Exception {
        assertThat(service.addTeacher(testTeacher), is(true));
        verify(mockedQueryCreator, times(1)).addTeacher(testTeacher);
    }

    @Test
    public void editStudent() throws Exception {
        assertThat(service.editStudent(testStudent), is(true));
        verify(mockedQueryCreator, times(1)).editStudent(testStudent);
    }

    @Test
    public void editGroup() throws Exception {
        assertThat(service.editGroup(testGroup), is(true));
        verify(mockedQueryCreator, times(1)).editGroup(testGroup);
    }

    @Test
    public void editTeacher() throws Exception {
        assertThat(service.editTeacher(testTeacher), is(true));
        verify(mockedQueryCreator, times(1)).editTeacher(testTeacher);
    }

    @Test
    public void editSubject() throws Exception {
        assertThat(service.editSubject(testSubject), is(true));
        verify(mockedQueryCreator, times(1)).editSubject(testSubject);
    }

    @Test
    public void getStudentOfGroup() throws Exception {
        service.getStudentOfGroup(testGroup);
        verify(mockedQueryCreator, times(1)).getStudentOfGroup(testGroup);
    }

    @Test
    public void getGroupsBySubject() throws Exception {
        service.getGroupsBySubject(testSubject, offset, length);
        verify(mockedQueryCreator, times(1)).getGroupsBySubject(testSubject, offset, length);
    }

    @Test
    public void getSubjectsThatStudyAllGroups() throws Exception {
        service.getSubjectsThatStudyAllGroups();
        verify(mockedQueryCreator, times(1)).getSubjectsThatStudyAllGroups();
    }

    @Test
    public void getTeacherWithMaxExperience() throws Exception {
        service.getTeacherWithMaxExperience();
        verify(mockedQueryCreator, times(1)).getTeacherWithMaxExperience();
    }

    @Test
    public void getTeacherWithMinExperience() throws Exception {
        service.getTeacherWithMinExperience();
        verify(mockedQueryCreator, times(1)).getTeacherWithMinExperience();
    }

    @Test
    public void getTeachersWithExperienceMoreThanYears() throws Exception {
        int years = 5;

        service.getTeachersWithExperienceMoreThanYears(years);
        verify(mockedQueryCreator, times(1)).getTeachersWithExperienceMoreThanYears(years);
    }

    @Test
    public void getTeachersWithExperienceMoreThanThreeYears() throws Exception {
        service.getTeachersWithExperienceMoreThanThreeYears();
        verify(mockedQueryCreator, times(1)).getTeachersWithExperienceMoreThanThreeYears();
    }

    @Test
    public void getListOfSubjectsByCategory() throws Exception {
        service.getListOfSubjectsByCategory(testSubjectCategory);
        verify(mockedQueryCreator, times(1)).getListOfSubjectsByCategory(testSubjectCategory);
    }

    @Test
    public void getListOfHumanitarianSubjects() throws Exception {
        service.getListOfHumanitarianSubjects();
        verify(mockedQueryCreator, times(1)).getListOfHumanitarianSubjects();
    }

}