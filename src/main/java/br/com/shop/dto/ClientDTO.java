package br.com.shop.dto;

import br.com.shop.enums.ProfileType;
import br.com.shop.model.Address;
import br.com.shop.model.Client;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientDTO {

    private long id;
    private String firstName;
    private String lastName;
    private Date birthdate;
    private String document;
    private String phone;
    private String email;
    private String password;
    private ProfileType profileType;
    private List<AddressDTO> addressList = new ArrayList<>();

    private LocalDate profileCriatedDate;

    private LocalDate profileDisabledDate;

    public ClientDTO(Client client) {
        this.id = client.getId();
        this.firstName = client.getFirstName();
        this.lastName = client.getLastName();
        this.birthdate = client.getBirthdate();
        this.document = client.getDocument();
        this.phone = client.getPhone();
        this.email = client.getEmail();
        this.password = client.getPassword();
        this.profileType = client.getProfileType();
        this.profileCriatedDate = client.getProfileCriatedDate();
        this.profileDisabledDate = client.getProfileDisabledDate();

        this.addressList = new ArrayList<>();

        addressList.forEach(item -> {
            AddressDTO addressDTO = new AddressDTO();
            addressDTO.setStreet(item.getStreet());
            addressDTO.setNumber(item.getNumber());
            addressDTO.setZipcode(item.getZipcode());
            addressDTO.setDistrict(item.getDistrict());
            addressDTO.setCity(item.getCity());
            addressDTO.setState(item.getState());
            addressDTO.setCountry(item.getCountry());
            addressDTO.setAddressType(item.getAddressType());
            addressDTO.setId(item.getId());

            this.addressList.add(addressDTO);
        });

    }

    public ClientDTO(Client client, List<Address> addressList ) {
        this.id = client.getId();
        this.firstName = client.getFirstName();
        this.lastName = client.getLastName();
        this.birthdate = client.getBirthdate();
        this.document = client.getDocument();
        this.phone = client.getPhone();
        this.email = client.getEmail();
        this.password = client.getPassword();
        this.profileType = client.getProfileType();
        this.profileCriatedDate = client.getProfileCriatedDate();
        this.profileDisabledDate = client.getProfileDisabledDate();

        this.addressList = new ArrayList<>();

        addressList.forEach(item -> {
            AddressDTO addressDTO = new AddressDTO();
            addressDTO.setStreet(item.getStreet());
            addressDTO.setNumber(item.getNumber());
            addressDTO.setZipcode(item.getZipcode());
            addressDTO.setDistrict(item.getDistrict());
            addressDTO.setCity(item.getCity());
            addressDTO.setState(item.getState());
            addressDTO.setCountry(item.getCountry());
            addressDTO.setAddressType(item.getAddressType());
            addressDTO.setId(item.getId());

            this.addressList.add(addressDTO);
        });

    }

}