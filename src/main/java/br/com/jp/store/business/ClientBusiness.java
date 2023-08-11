package br.com.jp.store.business;

import br.com.jp.store.dto.ClientDTO;
import org.springframework.data.jpa.repository.EntityGraph;

import java.util.List;

public interface ClientBusiness {

    List<ClientDTO> findAll();

    @EntityGraph(attributePaths = {"addressList"})
    ClientDTO findById(long id);

    ClientDTO create(ClientDTO clientDTO);

    ClientDTO update(long id, ClientDTO clientDTO);

    void delete(long id);

    List<ClientDTO> findAllByProfileTrue();

    List<ClientDTO> findUsersByFirstNameOrLastName(String firstName, String lastName);

    List<ClientDTO> findUserByDocument(String document);

}