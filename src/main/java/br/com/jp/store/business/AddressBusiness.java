package br.com.jp.store.business;

import br.com.jp.store.dto.AddressDTO;

import java.util.List;


public interface AddressBusiness {

    List<AddressDTO> findAllAddressByBuyer(long idBuyer);

    AddressDTO create(long idBuyer, AddressDTO addressDTO);

    AddressDTO updateAddressBuyer(long idBuyer, long idAddress, AddressDTO addressDTO);

    void delete(long idBuyer, long idAddress);
}