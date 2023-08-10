package br.com.shop.business;

import br.com.shop.dto.SaleDTO;

import java.time.LocalDate;
import java.util.List;

public interface SaleBusiness {

    List<SaleDTO> findAllSales();

    SaleDTO findSaleById(long id);

    List<SaleDTO> findSaleByDocument(String document);

    SaleDTO createSale(SaleDTO saleDTO);

    SaleDTO updateItemSale(long id, SaleDTO saleDTO);
    List<SaleDTO> findSalesBetweenDates(LocalDate startDate, LocalDate endDate);
}