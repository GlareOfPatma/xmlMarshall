package data;

import jakarta.persistence.*;
import jakarta.xml.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Date;


@XmlRootElement(namespace = "test")
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
public class Account {
    public Account() {
    }

    @Id
    @Column(name = "AccountNumber", nullable = false, unique = true)
    private String accountNumber;

    @Column(name = "personid", nullable = false)
    private int id;

    @Column(name = "OpeningDate", nullable = false)
    private Date openingDate;

    @Column(name = "FullName", nullable = false)
    private String fullName;
    @Column(name = "Balance", nullable = false)
    private BigDecimal currentBalance;

    public Account(String accountNumber, int id, Date openingDate, String fullName, BigDecimal currentBalance) {
        this.accountNumber = accountNumber;
        this.id = id;
        this.openingDate = openingDate;
        this.fullName = fullName;
        this.currentBalance = currentBalance;
    }
    public int getId() {return id;}
    public void setId(int id) {this.id = id;}
    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Date getOpeningDate() {
        return openingDate;
    }

    public void setOpeningDate(Date openingDate) {
        this.openingDate = openingDate;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public BigDecimal getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(BigDecimal currentBalance) {
        this.currentBalance = currentBalance;
    }
}
