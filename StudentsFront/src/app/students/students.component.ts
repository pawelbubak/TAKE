import { Component, OnInit } from '@angular/core';
import { Student } from '../model/student';
import { StudentService } from '../service/student.service';

@Component({
  selector: 'app-students',
  templateUrl: './students.component.html',
  styleUrls: ['./students.component.css'],
})
export class StudentsComponent implements OnInit {
  students: Student[];

  constructor(private studentService: StudentService) {}

  ngOnInit(): void {
    this.getStudents();
  }

  getStudents(): void {
    this.studentService
      .getStudents()
      .subscribe((students) => (this.students = students));
  }

  create(index: number, firstName: string, lastName: string): void {
    this.studentService
      .createStudent({
        index,
        firstName,
        lastName,
      } as Student)
      .subscribe((student) => {
        this.students.push(student);
      });
  }

  delete(student: Student): void {
    this.students = this.students.filter((s) => s.id !== student.id);
    this.studentService.deleteStudent(student).subscribe();
  }
}
