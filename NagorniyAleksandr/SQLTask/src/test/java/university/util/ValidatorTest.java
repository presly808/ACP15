package university.util;

import org.junit.Test;
import university.exceptions.InvalidValueException;
import university.models.*;

import static org.junit.Assert.assertTrue;

public class ValidatorTest {
    @Test
    public void validateOffsetAndLength() throws Exception {
        int correctOffset1 = 0;
        int correctOffset2 = 1_000_000;


        int correctLength1 = 1;
        int correctLength2 = 1_000_000;

        Validator.validateOffsetAndLength(correctOffset1, correctLength1);
        Validator.validateOffsetAndLength(correctOffset2, correctLength2);
    }

    @Test
    public void validateOffsetAndLengthNegative() throws Exception {
        int invalidOffset = -10;
        int correctOffset = 1_000_000;

        int invalidLength = 0;
        int correctLength = 1_000_000;

        try {
            Validator.validateOffsetAndLength(invalidOffset, invalidLength);
            assertTrue(false);
        } catch (InvalidValueException e) {
            assertTrue(true);
        }

        try {
            Validator.validateOffsetAndLength(invalidOffset, correctLength);
            assertTrue(false);
        } catch (InvalidValueException e) {
            assertTrue(true);
        }

        try {
            Validator.validateOffsetAndLength(correctOffset, invalidLength);
            assertTrue(false);
        } catch (InvalidValueException e) {
            assertTrue(true);
        }
    }

    @Test
    public void validateStudent() throws Exception {
        Group validGroup = new Group("ValidGroup");
        String studentValidName = "Nagorniy Aleksandr";
        Student validStudent = new Student(studentValidName, validGroup);
        Validator.validateStudent(validStudent);
    }

    @Test
    public void validateStudentNegative() throws Exception {

        String validGroupName = "ValidGroupName";
        String invalidName = "1231@#$kldsfjklsms=+";

        Group validGroup = new Group(validGroupName);
        Group invalidGroup1 = new Group(null);
        Group invalidGroup2 = new Group(invalidName);
        int invalidGroupId = -4;
        Group invalidGroup3 = new Group(invalidName);

        String studentValidName = "Test";
        Student invalidStudent1 = new Student(null, validGroup);
        Student invalidStudent2 = new Student(invalidName, validGroup);
        Student invalidStudent3 = new Student(studentValidName, invalidGroup1);
        Student invalidStudent4 = new Student(studentValidName, invalidGroup2);
        Student invalidStudent5 = new Student(studentValidName, invalidGroup3);

        try {
            Validator.validateStudent(null);
            assertTrue(false);
        } catch (InvalidValueException e) {
            assertTrue(true);
        }

        try {
            Validator.validateStudent(invalidStudent1);
            assertTrue(false);
        } catch (InvalidValueException e) {
            assertTrue(true);
        }

        try {
            Validator.validateStudent(invalidStudent2);
            assertTrue(false);
        } catch (InvalidValueException e) {
            assertTrue(true);
        }

        try {
            Validator.validateStudent(invalidStudent3);
            assertTrue(false);
        } catch (InvalidValueException e) {
            assertTrue(true);
        }

        try {
            Validator.validateStudent(invalidStudent4);
            assertTrue(false);
        } catch (InvalidValueException e) {
            assertTrue(true);
        }

        try {
            Validator.validateStudent(invalidStudent5);
            assertTrue(false);
        } catch (InvalidValueException e) {
            assertTrue(true);
        }
    }

    @Test
    public void validateGroup() throws Exception {
        Group validGroup1 = new Group("ValidGroup");
        Validator.validateGroup(validGroup1);
        Group validGroup2 = new Group("ACP-15");
        Validator.validateGroup(validGroup2);
    }

    @Test
    public void validateGroupNegative() throws Exception {
        Group invalidGroup1 = new Group(null);
        Group invalidGroup2 = new Group("1231@#$kldsfjklsms=+");

        try {
            Validator.validateGroup(null);
            assertTrue(false);
        } catch (InvalidValueException e) {
            assertTrue(true);
        }

        try {
            Validator.validateGroup(invalidGroup1);
            assertTrue(false);
        } catch (InvalidValueException e) {
            assertTrue(true);
        }

        try {
            Validator.validateGroup(invalidGroup2);
            assertTrue(false);
        } catch (InvalidValueException e) {
            assertTrue(true);
        }
    }

    @Test
    public void validateSubject() throws Exception {
        SubjectCategory validSubjectCategory = new SubjectCategory("ValidCategory");
        String subjectValidName = "Philosophy";
        String subjectDescription = "Description";
        Subject validSubject = new Subject(subjectValidName, validSubjectCategory, subjectDescription);
        Validator.validateSubject(validSubject);
    }

    @Test
    public void validateSubjectNegative() throws Exception {

        String validCategoryTitle = "ValidCategoryTitle";
        SubjectCategory validSubjectCategory = new SubjectCategory(validCategoryTitle);
        SubjectCategory invalidSubjectCategory1 = new SubjectCategory(null);
        SubjectCategory invalidSubjectCategory2 = new SubjectCategory(validCategoryTitle);

        String subjectDescription = "";
        String subjectValidName = "Test";
        Subject invalidSubject1 = new Subject(null, validSubjectCategory, subjectDescription);
        Subject invalidSubject2 = new Subject("1231@#$kldsfjklsms=+", validSubjectCategory, subjectDescription);
        Subject invalidSubject3 = new Subject(subjectValidName, invalidSubjectCategory1, subjectDescription);
        Subject invalidSubject4 = new Subject(subjectValidName, invalidSubjectCategory2, subjectDescription);

        try {
            Validator.validateSubject(null);
            assertTrue(false);
        } catch (InvalidValueException e) {
            assertTrue(true);
        }

        try {
            Validator.validateSubject(invalidSubject1);
            assertTrue(false);
        } catch (InvalidValueException e) {
            assertTrue(true);
        }

        try {
            Validator.validateSubject(invalidSubject2);
            assertTrue(false);
        } catch (InvalidValueException e) {
            assertTrue(true);
        }

        try {
            Validator.validateSubject(invalidSubject3);
            assertTrue(false);
        } catch (InvalidValueException e) {
            assertTrue(true);
        }

        try {
            Validator.validateSubject(invalidSubject4);
            assertTrue(false);
        } catch (InvalidValueException e) {
            assertTrue(true);
        }
    }

    @Test
    public void validateSubjectCategory() throws Exception {
        String validSubjectCategoryTitle = "Humanities";
        SubjectCategory validSubjectCategory = new SubjectCategory(validSubjectCategoryTitle);
        Validator.validateSubjectCategory(validSubjectCategory);
    }

    @Test
    public void validateSubjectCategoryNegative() throws Exception {
        SubjectCategory invalidSubjectCategory1 = new SubjectCategory(null);
        SubjectCategory invalidSubjectCategory2 = new SubjectCategory("1231@#$kldsfjklsms=+");

        try {
            Validator.validateSubjectCategory(null);
            assertTrue(false);
        } catch (InvalidValueException e) {
            assertTrue(true);
        }

        try {
            Validator.validateSubjectCategory(invalidSubjectCategory1);
            assertTrue(false);
        } catch (InvalidValueException e) {
            assertTrue(true);
        }

        try {
            Validator.validateSubjectCategory(invalidSubjectCategory2);
            assertTrue(false);
        } catch (InvalidValueException e) {
            assertTrue(true);
        }
    }

    @Test
    public void validateTeacher() throws Exception {
        String validTeacherName = "Valid Teacher";
        int validExperience = 10;
        Teacher validTeacher = new Teacher(validTeacherName, validExperience);
    }

    @Test
    public void validateTeacherNegative() throws Exception {
        Teacher invalidTeacher1 = new Teacher(null, 6);
        Teacher invalidTeacher2 = new Teacher("1231@#$kldsfjklsms=+", 6);

        int invalidExperience = -7;
        Teacher invalidTeacher3 = new Teacher("Correct Name", invalidExperience);

        try {
            Validator.validateTeacher(null);
            assertTrue(false);
        } catch (InvalidValueException e) {
            assertTrue(true);
        }

        try {
            Validator.validateTeacher(invalidTeacher1);
            assertTrue(false);
        } catch (InvalidValueException e) {
            assertTrue(true);
        }

        try {
            Validator.validateTeacher(invalidTeacher2);
            assertTrue(false);
        } catch (InvalidValueException e) {
            assertTrue(true);
        }

        try {
            Validator.validateTeacher(invalidTeacher3);
            assertTrue(false);
        } catch (InvalidValueException e) {
            assertTrue(true);
        }
    }
}