package gymmanagementsystemcom.example.demo.service;

import gymmanagementsystemcom.example.demo.model.Membership;
import gymmanagementsystemcom.example.demo.repository.MembershipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class MembershipService {

    @Autowired
    private MembershipRepository membershipRepository;

    public Optional<Membership> getMembershipByUser(Long userId) {
        return membershipRepository.findByUserId(userId);
    }

    public Membership saveMembership(Membership membership) {
        return membershipRepository.save(membership);
    }

    public void deleteMembership(Long id) {
        membershipRepository.deleteById(id);
    }
}