package gymmanagementsystemcom.example.demo.controller;

import gymmanagementsystemcom.example.demo.model.Membership;
import gymmanagementsystemcom.example.demo.service.MembershipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/memberships")
@CrossOrigin(origins = "http://localhost:3000")
public class MembershipController {

    @Autowired
    private MembershipService membershipService;

    @GetMapping("/user/{userId}")
    public ResponseEntity<Membership> getMembership(@PathVariable Long userId) {
        return membershipService.getMembershipByUser(userId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Membership createMembership(@RequestBody Membership membership) {
        return membershipService.saveMembership(membership);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMembership(@PathVariable Long id) {
        membershipService.deleteMembership(id);
        return ResponseEntity.ok().build();
    }
}