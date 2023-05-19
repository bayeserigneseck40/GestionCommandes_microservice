package com.example.servicedetailcommande.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.servicedetailcommande.model.DetailsCommande;

@Repository
public interface DetailsRepository extends JpaRepository<DetailsCommande, Long> {
	 DetailsCommande findByIdDetail(Long id);
	 DetailsCommande findByNumCommande(Long id);
}
