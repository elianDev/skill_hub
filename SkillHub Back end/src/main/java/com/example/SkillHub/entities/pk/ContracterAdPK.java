package com.example.SkillHub.entities.pk;

import com.example.SkillHub.entities.Advertising;
import com.example.SkillHub.entities.User;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Embeddable
public class ContracterAdPK {

    @EqualsAndHashCode.Include
    @ManyToOne
    @JoinColumn(name = "contracter_id")
    private User contracter;

    @EqualsAndHashCode.Include
    @ManyToOne
    @JoinColumn(name = "advertising_id")
    private Advertising advertising;
}
