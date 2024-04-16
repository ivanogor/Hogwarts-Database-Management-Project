package ru.hogwarts.school.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.service.FacultyService;

import java.util.Collection;


@RestController
@RequestMapping("/faculty")
public class FacultyController {
    private final FacultyService facultyService;

    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    @PostMapping
    public ResponseEntity<Faculty> add(@RequestBody Faculty faculty){
        Faculty addedFaculty = facultyService.add(faculty);
        return ResponseEntity.ok(addedFaculty);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity remove(@PathVariable long id){
        facultyService.remove(id);

        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Faculty> get(@PathVariable long id){
        Faculty faculty = facultyService.get(id);
        if(faculty == null){
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(faculty);
    }

    @PutMapping
    public ResponseEntity<Faculty> edit(@RequestBody Faculty faculty){
        Faculty editedFaculty = facultyService.edit(faculty);

        if(editedFaculty == null){
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(editedFaculty);
    }

    @GetMapping
    public ResponseEntity<Collection<Faculty>> getAllStudents(){
        return ResponseEntity.ok(facultyService.getAllFaculties());
    }
}
