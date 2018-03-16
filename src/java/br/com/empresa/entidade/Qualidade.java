/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.empresa.entidade;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author leonix
 */
@Entity
@Table(name = "qualidade")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Qualidade.findAll", query = "SELECT q FROM Qualidade q")
    , @NamedQuery(name = "Qualidade.findById", query = "SELECT q FROM Qualidade q WHERE q.id = :id")
    , @NamedQuery(name = "Qualidade.findByDescricao", query = "SELECT q FROM Qualidade q WHERE q.descricao = :descricao")})
public class Qualidade implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "descricao")
    private String descricao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idqualidade")
    private List<PessoaQualidade> pessoaQualidadeList;

    public Qualidade() {
    }

    public Qualidade(Integer id) {
        this.id = id;
    }

    public Qualidade(Integer id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @XmlTransient
    public List<PessoaQualidade> getPessoaQualidadeList() {
        return pessoaQualidadeList;
    }

    public void setPessoaQualidadeList(List<PessoaQualidade> pessoaQualidadeList) {
        this.pessoaQualidadeList = pessoaQualidadeList;
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
        if (!(object instanceof Qualidade)) {
            return false;
        }
        Qualidade other = (Qualidade) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.empresa.entidade.Qualidade[ id=" + id + " ]";
    }
    
}
