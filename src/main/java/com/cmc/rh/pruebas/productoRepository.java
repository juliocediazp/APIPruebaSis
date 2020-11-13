package com.cmc.rh.pruebas;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface productoRepository extends JpaRepository<ProductoEntity, Integer>{

	@Query(nativeQuery = true , value = "select     * \r\n" + 
			"from(select ROWNUM , a.*\r\n" + 
			"      from \r\n" + 
			"        (select  * from Producto  order by id asc) a \r\n" + 
			"      where \r\n" + 
			"        ROWNUM <= ?2 \r\n" + 
			"    ) \r\n" + 
			"where \r\n" + 
			"    ROWNUM>=  ?1")
	List<ProductoEntity> listaProductos(int pagIni , int pagFin);
	
}
