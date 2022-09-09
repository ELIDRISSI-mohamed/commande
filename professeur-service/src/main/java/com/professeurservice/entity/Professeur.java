package com.professeurservice.entity;

import com.professeurservice.dto.ProfResDto;
import lombok.*;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Professeur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String prenom;
    @Column(unique = true)
    private String mail;

    public ProfResDto toProfResDto(){
        ProfResDto target = new ProfResDto();

        target.setId(this.getId());
        target.setUsername(this.getNom()+" "+this.getPrenom());

        return target;
    }
}
