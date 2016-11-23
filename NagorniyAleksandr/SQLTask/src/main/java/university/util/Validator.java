package university.util;

import org.apache.log4j.Logger;
import university.exceptions.InvalidValueException;
import university.models.*;

import java.util.regex.Pattern;

public class Validator {

    private static final Pattern PATTERN_FOR_PEOPLE_NAME = Pattern.compile("[a-zA-Z\\-\\s]{1,40}");
    private static final Pattern PATTERN_FOR_SUBJECT_NAME = Pattern.compile("[a-zA-Z0-9\\-\\s]{1,20}");
    private static final Pattern PATTERN_FOR_GROUP_NAME = Pattern.compile("[a-zA-Z0-9\\-\\s]{1,20}");
    private static final Pattern PATTERN_FOR_SUBJECT_CATEGORY_NAME = Pattern.compile("[a-zA-Z\\-\\s]{1,15}");

    private static final Logger log = Logger.getLogger(Validator.class);

    public static void validateOffsetAndLength(int offset, int length) throws InvalidValueException {
        if (offset < 0) {
            log.error("Throw: Offset parameter is invalid");
            throw new InvalidValueException("Offset parameter is invalid");
        }
        if (length < 1) {
            log.error("Throw: Length parameter is invalid");
            throw new InvalidValueException("Length parameter is invalid");
        }
    }

    public static void validateStudent(Student student) throws InvalidValueException {
        if (student == null) {
            log.error("Throw: Student is null");
            throw new InvalidValueException("Student is null");
        }

        if (!PATTERN_FOR_PEOPLE_NAME.matcher(student.getName()).matches()) {
            log.error("Throw: Invalid students name");
            throw new InvalidValueException("Invalid students name");
        }

        validateGroup(student.getGroup());

        if (student.getGroup().getId() < 1) {
            log.error("Throw: Invalid students group ID");
            throw new InvalidValueException("Invalid students group ID");
        }
    }

    public static void validateGroup(Group group) throws InvalidValueException {
        if (group == null) {
            log.error("Throw: Group is null");
            throw new InvalidValueException("Group is null");
        }

        if (!PATTERN_FOR_GROUP_NAME.matcher(group.getName()).matches()) {
            log.error("Throw: Invalid group name");
            throw new InvalidValueException("Invalid group name");
        }

    }

    public static void validateSubject(Subject subject) throws InvalidValueException {
        if (subject == null) {
            log.error("Throw: Subject is null");
            throw new InvalidValueException("Subject is null");
        }

        if (!PATTERN_FOR_SUBJECT_NAME.matcher(subject.getName()).matches()) {
            log.error("Throw: Invalid subject name");
            throw new InvalidValueException("Invalid subject name");
        }

        validateSubjectCategory(subject.getCategory());

        if (subject.getCategory().getId() < 1) {
            log.error("Throw: Invalid subject category ID");
            throw new InvalidValueException("Invalid subject category ID");
        }
    }

    public static void validateSubjectCategory(SubjectCategory subjectCategory) throws
            InvalidValueException {

        if (subjectCategory == null) {
            log.error("Throw: Subject category is null");
            throw new InvalidValueException("Subject category is null");
        }

        if (!PATTERN_FOR_SUBJECT_CATEGORY_NAME.matcher(subjectCategory.getTitle()).matches()) {
            log.error("Throw: Invalid subject category name");
            throw new InvalidValueException("Invalid subject category name");
        }
    }

    public static void validateTeacher(Teacher teacher) throws InvalidValueException {
        if (teacher == null) {
            log.error("Throw: Teacher is null");
            throw new InvalidValueException("Teacher is null");
        }

        if (!PATTERN_FOR_PEOPLE_NAME.matcher(teacher.getName()).matches()) {
            log.error("Throw: Invalid teacher name");
            throw new InvalidValueException("Invalid teacher name");
        }

        if (teacher.getExperience() < 0) {
            log.error("Throw: Invalid teacher experience");
            throw new InvalidValueException("Invalid teacher experience");
        }
    }
}
