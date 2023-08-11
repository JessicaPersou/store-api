package br.com.jp.store.repository;

import br.com.jp.store.dto.ClientDTO;
import br.com.jp.store.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    @Query(value = "select b from Client b inner join Address a on b.id = a.clientId.id")
    List<ClientDTO> findAllBuyersWithAddress();

    @Query("select b from Client b where b.profileType= :profile")
    List<ClientDTO> findAllByProfileTrue();

    @Query("select b from Client b where b.firstName like %?1% or b.lastName like %?2%")
    List<ClientDTO> findUsersByFirstNameOrLastName(@Param("firstName")String fisrtName, @Param("lastName")String lastName);

    @Query("select b from Client b where b.document like %?1%")
    List<ClientDTO> findUserByDocument(@Param("document")String document);

}