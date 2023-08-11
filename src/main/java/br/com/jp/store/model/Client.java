package br.com.jp.store.model;
import br.com.jp.store.enums.ProfileType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"document"}))
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    private Date birthdate;

    @Column(unique = true)
    private String document;

    private String phone;

    private String email;

    private String password;

    @Column(name = "profile_type")
    private ProfileType profileType;

    @OneToMany(mappedBy = "clientId")
    private List<Address> addressList = new ArrayList<>();

    @Column(name = "profile_created")
    private LocalDate profileCriatedDate;

    @Column(name = "profile_disabled")
    private LocalDate profileDisabledDate;
    public Client(long id) {
        this.id = id;
    }
}
