package com.github.kirill.LabThree.api;

import com.github.kirill.LabThree.entity.DoctorSchedule;
import com.github.kirill.LabThree.entity.Patient;
import com.github.kirill.LabThree.repository.DoctorScheduleRepository;
import com.github.kirill.LabThree.repository.PatientRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/patients")
public class PatientController {

  private final DoctorScheduleRepository doctorScheduleRepository;
  private final PatientRepository patientRepository;

  @GetMapping("/{id}/schedules")
  public List<DoctorSchedule> fetchSchedulesForPatient(@PathVariable Long id) {
    return doctorScheduleRepository.findAllByPatientId(id);
  }

  @GetMapping("/")
  public List<Patient> fetchAllPatients() {
    return patientRepository.findAll();
  }
}
