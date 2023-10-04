package data;

import jakarta.persistence.*;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;
import java.util.List;


@XmlRootElement(namespace = "test")
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
public class Person {
    public Person() {
    }

    public Person(int id, String surname, String name, String secondName, int age, boolean driverLicense, BigDecimal debt) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.secondName = secondName;
        this.age = age;
        this.driverLicense = driverLicense;
        this.debt = debt;
    }

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true, length = 11)
    private int id;
    @Column(name = "Surname")
    private String surname;
    @Column(name = "NameMain")
    private String name;
    @Column(name = "SecondName")
    private String secondName;
    @Column(name = "Age")
    private int age;
    @Column(name = "DriverLicense")
    private boolean driverLicense;
    @Column(name = "Debt")
    private BigDecimal debt;
    @OneToMany(mappedBy = "person")
    private List<Account> accounts;

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isDriverLicense() {
        return driverLicense;
    }

    public void setDriverLicense(boolean driverLicense) {
        this.driverLicense = driverLicense;
    }

    public BigDecimal getDebt() {
        return debt;
    }

    public void setDebt(BigDecimal debt) {
        this.debt = debt;
    }
}
