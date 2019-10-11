package com.example.internetshop.repositories;

import com.example.internetshop.entities.Invoice;
import org.springframework.data.repository.CrudRepository;

public interface InvoiceRepository extends CrudRepository<Invoice, Integer> {

}
