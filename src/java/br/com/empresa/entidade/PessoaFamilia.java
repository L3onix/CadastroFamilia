/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.empresa.entidade;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author leonix
 */
@Entity
@Table(name = "pessoa_familia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PessoaFamilia.findAll", query = "SELECT p FROM PessoaFamilia p")
    , @NamedQuery(name = "PessoaFamilia.findById", query = "SELECT p FROM PessoaFamilia p WHERE p.id = :id")
    , @NamedQuery(name = "PessoaFamilia.findByGrauparentesco", query = "SELECT p FROM PessoaFamilia p WHERE p.grauparentesco = :grauparentesco")
    , @NamedQuery(name = "PessoaFamilia.findByTipoparentesco", query = "SELECT p FROM PessoaFamilia p WHERE p.tipoparentesco = :tipoparentesco")})
public class PessoaFamilia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "grauparentesco")
    private int grauparentesco;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tipoparentesco")
    private int tipoparentesco;
    @JoinColumn(name = "idparente", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Pessoa idparente;
    @JoinColumn(name = "idpessoa", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Pessoa idpessoa;

    public PessoaFamilia() {
    }

    public PessoaFamilia(Integer id) {
        this.id = id;
    }

    public PessoaFamilia(Integer id, int grauparentesco, int tipoparentesco) {
        this.id = id;
        this.grauparentesco = grauparentesco;
        this.tipoparentesco = tipoparentesco;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getGrauparentesco() {
        return grauparentesco;
    }

    public void setGrauparentesco(int grauparentesco) {
        this.grauparentesco = grauparentesco;
    }

    public int getTipoparentesco() {
        return tipoparentesco;
    }

    public void setTipoparentesco(int tipoparentesco) {
        this.tipoparentesco = tipoparentesco;
    }

    public Pessoa getIdparente() {
        return idparente;
    }

    public void setIdparente(Pessoa idparente) {
        this.idparente = idparente;
    }

    public Pessoa getIdpessoa() {
        return idpessoa;
    }

    public void setIdpessoa(Pessoa idpessoa) {
        this.idpessoa = idpessoa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PessoaFamilia)) {
            return false;
        }
        PessoaFamilia other = (PessoaFamilia) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.empresa.entidade.PessoaFamilia[ id=" + id + " ]";
    }
    
}
