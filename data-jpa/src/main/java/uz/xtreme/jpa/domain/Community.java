package uz.xtreme.jpa.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
public class Community {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "community", cascade = {CascadeType.PERSIST})
    private Set<Organizer> organizers;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH})
    @JoinColumn(name = "community_id")
    private Set<Member> members;

    @PreRemove
    private void preRemove() {
        organizers.forEach( e -> e.setCommunity(null));
        members.forEach( e -> e.setCommunityId(null));
    }

}
