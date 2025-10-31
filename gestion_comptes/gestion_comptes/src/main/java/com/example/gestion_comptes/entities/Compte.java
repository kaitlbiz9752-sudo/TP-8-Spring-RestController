package com.example.gestion_comptes.entities;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@JacksonXmlRootElement(localName = "compte") // ✅ racine XML
public class Compte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JacksonXmlProperty(isAttribute = true)
    private Long id;

    @JacksonXmlProperty
    private double solde;

    @Temporal(TemporalType.DATE)
    @JacksonXmlProperty
    private Date dateCreation;

    @Enumerated(EnumType.STRING)
    @JacksonXmlProperty
    private TypeCompte type;

    public enum TypeCompte {
        COURANT,
        EPARGNE
    }
}
