package br.com.jp.store.controller;

import br.com.jp.store.business.AddressBusiness;
import br.com.jp.store.business.ClientBusiness;
import br.com.jp.store.dto.AddressDTO;
import br.com.jp.store.dto.ClientDTO;
import br.com.jp.store.repository.AddressRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
@Api(description = "Endpoints to management of Clients ")
public class ClientController {

    @Autowired
    private ClientBusiness clientBusiness;

    @Autowired
    private AddressBusiness addressBusiness;
    @Autowired
    private AddressRepository addressRepository;

    /***
     *
     * @return
     */


    @GetMapping
    @ApiOperation(httpMethod = "GET", value = "List all Clients", notes = "List Clients of Store", response = ClientDTO.class)
    public ResponseEntity<List<ClientDTO>> findAll(){
        var clints = clientBusiness.findAll();
        return ResponseEntity.ok(clints);
    }

    @GetMapping("/{idClient}")
    public ResponseEntity<ClientDTO> findById(@PathVariable long idClient){
        var clientId = clientBusiness.findById(idClient);
        if(clientId == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(clientId);
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
    public ResponseEntity<ClientDTO> createNewBuyer(@Valid @RequestBody ClientDTO clientDTO){
        var clientSave = clientBusiness.create(clientDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(clientSave);
    }

    @PutMapping("/{id}")
    public ClientDTO updateBuyer(@PathVariable long id, @Valid @RequestBody ClientDTO clientDTO){
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
    public AddressDTO createNewAddress(@PathVariable long idBuyer, @Valid @RequestBody AddressDTO addressDTO){
        return addressBusiness.create(idBuyer, addressDTO);
    }

    @PutMapping("/{idBuyer}/address/{idAddress}")
    public AddressDTO updateAddressBuyer(@PathVariable long idBuyer,
                                         @PathVariable long idAddress,
                                         @Valid
                                         @RequestBody AddressDTO addressDTO){
        return addressBusiness.updateAddressBuyer(idBuyer, idAddress, addressDTO);
    }

    @DeleteMapping("/{idBuyer}/address/{idAddress}")
    public ResponseEntity<?> deleteAddressById(@PathVariable long idBuyer, @PathVariable long idAddress){
        addressBusiness.delete(idBuyer, idAddress);
        return ResponseEntity.noContent().build();
    }
}