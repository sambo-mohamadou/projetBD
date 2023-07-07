package com.vetrix.projetBD.produit;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProduitRepository extends JpaRepository<Produit,Integer> {
    @Query("select count(*) from Produit")
    long count();

    @Query("select count(p) from Produit p where p.idCategorie = ?1")
    Long catCount(int cat);

    @Query("Select p from Produit p where p.idCategorie = ?1")
    List<Produit> getByCat(int idCat);

    @Query("Select p from Produit where p.age = ?1 and p.size1 <= ?2 and p.size2 >= ?2 ")
    List<Produit> getBySize(int typeSize, int size);

    @Query("Select count(p) from Produit where p.age = ?1 and p.size1 <= ?2 and p.size2 >= ?2 ")
    long countSize(int typeSize, int size);
}
