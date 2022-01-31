package com.example.demomongo;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@AllArgsConstructor
@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public void addNewStudent(Student student) {
        Optional<Student> studentOptional = studentRepository.findStudentByEmail(student.getEmail());
        if (studentOptional.isPresent()) {
            throw new IllegalStateException("Student already exists in database");
        }
        studentRepository.save(student);
    }

    public void deleteStudent(String studentId) {
        boolean studentExists = studentRepository.existsById(studentId);
        if (!studentExists) {
            throw new IllegalStateException("Student with " + studentId + " does not exist");
        }
        studentRepository.deleteById(studentId);
    }

    @Transactional
    public void updateStudent(String studentId,
                              String firstName,
                              String lastName,
                              String email,
                              Gender gender,
                              Address address,
                              List<String> favoriteSubjects,
                              BigDecimal totalSpentInBooks) {
        Student student = studentRepository.findById(studentId).orElseThrow(
                () -> new IllegalStateException("Student with id " + studentId + " does not exist")
        );

        if (firstName != null && firstName.length() > 0 && !Objects.equals(student.getFirstName(), firstName)) {
            student.setFirstName(firstName);
        }

        if (lastName != null && lastName.length() > 0 && !Objects.equals(student.getLastName(), lastName)) {
            student.setLastName(lastName);
        }

        if (email != null && email.length() > 0 && !Objects.equals(student.getEmail(), email)) {
            student.setEmail(email);
        }

        if (gender != null && !Objects.equals(student.getGender(), gender)) {
            student.setGender(gender);
        }

        student.setAddress(address);

        if (favoriteSubjects != null && favoriteSubjects.size() > 0 && !Objects.equals(student.getFavoriteSubjects(), favoriteSubjects)) {
            student.setFavoriteSubjects(favoriteSubjects);
        }

        if (totalSpentInBooks != null && !Objects.equals(student.getTotalSpentInBooks(), totalSpentInBooks)) {
            student.setTotalSpentInBooks(totalSpentInBooks);
        }



    }
}
