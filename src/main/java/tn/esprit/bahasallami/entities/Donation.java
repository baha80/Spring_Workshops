package tn.esprit.bahasallami.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
@Getter
@Setter
@NoArgsConstructor
//@AllArgsConstructor
@ToString
@Entity
public class Donation implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long donId;
    private float donAmount;
    private String donDate;
    @Enumerated(EnumType.STRING)
    private DonationType donType;



    @ManyToOne
    private Employe employe;
    @ManyToOne
    private RedCrescent redCrescent;




}
