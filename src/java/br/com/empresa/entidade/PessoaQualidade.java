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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author leonix
 */
@Entity
@Table(name = "pessoa_qualidade")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PessoaQualidade.findAll", query = "SELECT p FROM PessoaQualidade p")
    , @NamedQuery(name = "PessoaQualidade.findById", query = "SELECT p FROM PessoaQualidade p WHERE p.id = :id")})
public class PessoaQualidade implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "idpessoa", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Pessoa idpessoa;
    @JoinColumn(name = "idqualidade", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Qualidade idqualidade;

    public PessoaQualidade() {
    }

    public PessoaQualidade(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Pessoa getIdpessoa() {
        return idpessoa;
    }

    public void setIdpessoa(Pessoa idpessoa) {
        this.idpessoa = idpessoa;
    }

    public Qualidade getIdqualidade() {
        return idqualidade;
    }

    public void setIdqualidade(Qualidade idqualidade) {
        this.idqualidade = idqualidade;
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
        if (!(object instanceof PessoaQualidade)) {
            return false;
        }
        PessoaQualidade other = (PessoaQualidade) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.empresa.entidade.PessoaQualidade[ id=" + id + " ]";
    }
    
}
