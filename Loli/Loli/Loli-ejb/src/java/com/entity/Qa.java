/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "QA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Qa.findAll", query = "SELECT q FROM Qa q")
    , @NamedQuery(name = "Qa.findByIdQA", query = "SELECT q FROM Qa q WHERE q.idQA = :idQA")
    , @NamedQuery(name = "Qa.findByQuestion", query = "SELECT q FROM Qa q WHERE q.question = :question")
    , @NamedQuery(name = "Qa.findByAnswers", query = "SELECT q FROM Qa q WHERE q.answers = :answers")})
public class Qa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "Id_QA")
    private String idQA;
    @Size(max = 1073741823)
    @Column(name = "Question")
    private String question;
    @Size(max = 1073741823)
    @Column(name = "Answers")
    private String answers;

    public Qa() {
    }

    public Qa(String idQA) {
        this.idQA = idQA;
    }

    public String getIdQA() {
        return idQA;
    }

    public void setIdQA(String idQA) {
        this.idQA = idQA;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswers() {
        return answers;
    }

    public void setAnswers(String answers) {
        this.answers = answers;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idQA != null ? idQA.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Qa)) {
            return false;
        }
        Qa other = (Qa) object;
        if ((this.idQA == null && other.idQA != null) || (this.idQA != null && !this.idQA.equals(other.idQA))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entity.Qa[ idQA=" + idQA + " ]";
    }
    
}
