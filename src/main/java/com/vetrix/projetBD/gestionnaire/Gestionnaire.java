package com.vetrix.projetBD.gestionnaire;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor @AllArgsConstructor @Getter @Setter @Entity @Table(name = "gestionnaire")
public class Gestionnaire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idGes;
    private String nomGes;
    private int typeGes;
    private String login;
    private String pwd;
    private int actif;
}
