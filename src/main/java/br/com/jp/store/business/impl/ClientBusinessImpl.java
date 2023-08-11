package br.com.jp.store.business.impl;

import br.com.jp.store.business.ClientBusiness;
import br.com.jp.store.dto.ClientDTO;
import br.com.jp.store.enums.ProfileType;
import br.com.jp.store.model.Address;
import br.com.jp.store.model.Client;
import br.com.jp.store.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class ClientBusinessImpl implements ClientBusiness {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public List<ClientDTO> findAll() {
        List<Client> clients = clientRepository.findAll();
        List<ClientDTO> clientDTOS = new ArrayList<>();

        for (Client client : clients){
            List<Address> addressList = client.getAddressList();
            ClientDTO clientDTO = new ClientDTO(client, addressList);
            clientDTOS.add(clientDTO);
        }
        return clientDTOS;
    }

    @Override
    public ClientDTO findById(long id) {
        Client buyers = clientRepository.findById(id).orElseThrow(() -> new RuntimeException(id + " NOT FOUND"));
        List<Address> addressList = new ArrayList<>();
        addressList = buyers.getAddressList();
        return new ClientDTO(buyers,addressList);
    }

    public List<ClientDTO> findAllByProfileTrue(){
        return clientRepository.findAllByProfileTrue();
    }

    public List<ClientDTO> findUserByDocument(String document){
        return clientRepository.findUserByDocument(document);
    }

    public List<ClientDTO> findUsersByFirstNameOrLastName(String firstName, String lastName){
        return clientRepository.findUsersByFirstNameOrLastName(firstName,lastName);
    }

    @Override
    public ClientDTO create(ClientDTO clientDTO){
        Client client = new Client();

        client.setFirstName(clientDTO.getFirstName());
        client.setLastName(clientDTO.getLastName());
        client.setDocument(clientDTO.getDocument());
        client.setBirthdate(clientDTO.getBirthdate());
        client.setPhone(clientDTO.getPhone());
        client.setEmail(clientDTO.getEmail());
        client.setPassword(clientDTO.getPassword());
        client.setProfileCriatedDate(LocalDate.now());

        if(client.getProfileType() == null){
            client.setProfileType(ProfileType.USER);
        }

        clientRepository.save(client);
        clientDTO.setId(client.getId());

        return new ClientDTO(client);
    }

    @Override
    public ClientDTO update(long id, ClientDTO clientDTO) {
        Client client = clientRepository.findById(id).orElseThrow(() -> new RuntimeException("ID " + id + " NOT FOUND"));

        client.setFirstName(clientDTO.getFirstName());
        client.setLastName(clientDTO.getLastName());
        client.setDocument(clientDTO.getDocument());
        client.setBirthdate(clientDTO.getBirthdate());
        client.setPhone(clientDTO.getPhone());
        client.setEmail(clientDTO.getEmail());
        client.setPassword(clientDTO.getPassword());
        client.setProfileCriatedDate(LocalDate.now());

        if(client.getProfileType() == null){
            client.setProfileType(ProfileType.USER);
        }

        clientRepository.save(client);

        return new ClientDTO(client);
    }

    public void delete(long id){
        Client client =  clientRepository.findById(id).orElseThrow(() -> new RuntimeException("ID " + id + " NOT FOUND"));
        try{
            if(client.getProfileType() != ProfileType.DISABLED){
                client.setProfileDisabledDate(LocalDate.now());
                client.setProfileType(ProfileType.DISABLED);
                clientRepository.save(client);
            }
        }catch (Exception e){
            throw new RuntimeException("Não foi possivel Desabilitar esse usuário.");
        }
    }
}