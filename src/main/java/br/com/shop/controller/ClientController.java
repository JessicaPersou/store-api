package br.com.shop.controller;

import br.com.shop.business.AddressBusiness;
import br.com.shop.business.ClientBusiness;
import br.com.shop.dto.AddressDTO;
import br.com.shop.dto.ClientDTO;
import br.com.shop.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientBusiness clientBusiness;

    @Autowired
    private AddressBusiness addressBusiness;
    @Autowired
    private AddressRepository addressRepository;

    @GetMapping
    public List<ClientDTO> findAll(){
        return clientBusiness.findAll();
    }

    @GetMapping("/{idClient}")
    public ClientDTO findById(@PathVariable long idClient){
        return clientBusiness.findById(idClient);
    }

    @GetMapping("/admin")
    public List<ClientDTO> findProfileUser(){
        return clientBusiness.findAllByProfileTrue();
    }

    @GetMapping("/name")
    public List<ClientDTO> findUsersByFirstNameAndLastName(@Param("firstName")String firstName,
                                                           @Param("lastName") String lastName){
        return clientBusiness.findUsersByFirstNameOrLastName(firstName, lastName);
    }

    @GetMapping("/document")
    public List<ClientDTO> findUserByDocument(@Param("document")String document){
        return clientBusiness.findUserByDocument(document);
    }

    @PostMapping
    public ClientDTO createNewBuyer(@RequestBody ClientDTO clientDTO){
        return clientBusiness.create(clientDTO);
    }

    @PutMapping("/{id}")
    public ClientDTO updateBuyer(@PathVariable long id, @RequestBody ClientDTO clientDTO){
        return clientBusiness.update(id, clientDTO);
    }

    @DeleteMapping("/{idBuyer}")
    public void deleteBuyerById(@PathVariable long idBuyer){
        clientBusiness.delete(idBuyer);
    }

    @GetMapping("/{idBuyer}/address")
    public List<AddressDTO> findAllAddressByBuyerId(@PathVariable long idBuyer){
        return addressBusiness.findAllAddressByBuyer(idBuyer);
    }

    @PostMapping("{idBuyer}/new-address")
    public AddressDTO createNewAddress(@PathVariable long idBuyer, @RequestBody AddressDTO addressDTO){
        return addressBusiness.create(idBuyer, addressDTO);
    }

    @PutMapping("/{idBuyer}/address/{idAddress}")
    public AddressDTO updateAddressBuyer(@PathVariable long idBuyer,
                                         @PathVariable long idAddress,
                                         @RequestBody AddressDTO addressDTO){
        return addressBusiness.updateAddressBuyer(idBuyer, idAddress, addressDTO);
    }

    @DeleteMapping("/{idBuyer}/address/{idAddress}")
    public void deleteAddressById(@PathVariable long idBuyer, @PathVariable long idAddress){
        addressBusiness.delete(idBuyer, idAddress);
    }
}