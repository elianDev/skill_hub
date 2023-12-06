package com.example.SkillHub.entities;

import com.example.SkillHub.entities.enums.ContractStatus;
import com.example.SkillHub.entities.pk.ContracterAdPK;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Entity
@Table(name = "tb_contracter_ad")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ContracterAd {

    @EmbeddedId
    private ContracterAdPK id = new ContracterAdPK();
    private Instant date;
    private ContractStatus status;

    public ContracterAd(User contracter, Advertising advertising, Instant date, ContractStatus status) {
        id.setContracter(contracter);
        id.setAdvertising(advertising);
        this.date = date;
        this.status = status;
    }

    public User getContracter() {
        return id.getContracter();
    }

    public void setContracter(User contracter) {
        id.setContracter(contracter);
    }

    public Advertising getAdvertising() {
        return id.getAdvertising();
    }

    public void setAdvertising(Advertising advertising) {
        id.setAdvertising(advertising);
    }
}
