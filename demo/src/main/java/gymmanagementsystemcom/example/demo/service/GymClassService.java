package gymmanagementsystemcom.example.demo.service;

import gymmanagementsystemcom.example.demo.model.GymClass;
import gymmanagementsystemcom.example.demo.repository.GymClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class GymClassService {

    @Autowired
    private GymClassRepository gymClassRepository;

    public List<GymClass> getAllClasses() {
        return gymClassRepository.findAll();
    }

    public Optional<GymClass> getClassById(Long id) {
        return gymClassRepository.findById(id);
    }

    public GymClass saveClass(GymClass gymClass) {
        return gymClassRepository.save(gymClass);
    }

    public void deleteClass(Long id) {
        gymClassRepository.deleteById(id);
    }
}