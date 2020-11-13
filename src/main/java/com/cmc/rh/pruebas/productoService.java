package com.cmc.rh.pruebas;

import java.net.URI;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.cmc.rh.dto.FiltoPaginado;
import com.cmc.rh.dto.ProductoCreateDto;
import com.cmc.rh.dto.ProductoUpdateDto;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/producto")
public class productoService {
	@Autowired
	productoRepository productoRepository;

	
	@ApiOperation(value = "Listar todos los productos", response = Iterable.class)
	@ApiResponses(value = {
	    @ApiResponse(code = 200, message = "Listado correcta mente"),
	    @ApiResponse(code = 204, message = "No se encotraron registro"),
	    @ApiResponse(code = 401, message = "No estás autorizado para ver el recurso."),
	    @ApiResponse(code = 403, message = "Está prohibido acceder al recurso al que intentabas acceder"),
	    @ApiResponse(code = 404, message = "El recurso que intentabas alcanzar no se encuentra  ")
	})
	@ApiImplicitParam(name = "Authorization", value = "Access Token", required = true, allowEmptyValue = false, paramType = "header", dataTypeClass = String.class, example = "Ingrese el token para iniciar")
	@GetMapping
	public Iterable<ProductoEntity> ListarProducto(){
		return productoRepository.findAll();
		
	}
	
	@ApiOperation(value = "Listar todos los productos por pagina", response = Iterable.class)
	@ApiResponses(value = {
	    @ApiResponse(code = 200, message = "Listado correcta mente"),
	    @ApiResponse(code = 204, message = "No se encotraron registro"),
	    @ApiResponse(code = 401, message = "No estás autorizado para ver el recurso."),
	    @ApiResponse(code = 403, message = "Está prohibido acceder al recurso al que intentabas acceder"),
	    @ApiResponse(code = 404, message = "El recurso que intentabas alcanzar no se encuentra  ")
	})
	@ApiImplicitParam(name = "Authorization", value = "Access Token", required = true, allowEmptyValue = false, paramType = "header", dataTypeClass = String.class, example = "Ingrese el token para iniciar")
	@PostMapping("/paginado")
	public Iterable<ProductoEntity> ListarProductoPaginado(@ModelAttribute("FiltoPaginado") FiltoPaginado filtoPaginado){
		return productoRepository.listaProductos(filtoPaginado.getPagIni(),filtoPaginado.getPagFin());
		
	}
	
	@ApiOperation(value = "Listar por producto", response = Iterable.class)
	@ApiResponses(value = {
	    @ApiResponse(code = 200, message = "Listado correcta mente"),
	    @ApiResponse(code = 204, message = "No se encotraron registro"),
	    @ApiResponse(code = 401, message = "No estás autorizado para ver el recurso."),
	    @ApiResponse(code = 403, message = "Está prohibido acceder al recurso al que intentabas acceder"),
	    @ApiResponse(code = 404, message = "El recurso que intentabas alcanzar no se encuentra  ")
	})
	@ApiImplicitParam(name = "Authorization", value = "Access Token", required = true, allowEmptyValue = false, paramType = "header", dataTypeClass = String.class, example = "Ingrese el token para iniciar")
	@GetMapping("/{id}")
	public Optional<ProductoEntity> ListarProducto(@PathVariable("id") int id ){
		return productoRepository.findById(id);
	}
	@ApiOperation(value = "eliminar producto", response = Iterable.class)
	@ApiResponses(value = {
	    @ApiResponse(code = 200, message = "Producto elimindo Correctamente"),
	    @ApiResponse(code = 403, message = "Está prohibido acceder al recurso al que intentabas acceder"),
	    @ApiResponse(code = 404, message = "El recurso que intentabas alcanzar no se encuentra  "),
	    @ApiResponse(code = 500, message = "El recurso que intentabas alcanzar no Existe en la base de datos  ")
	})
	@ApiImplicitParam(name = "Authorization", value = "Access Token", required = true, allowEmptyValue = false, paramType = "header", dataTypeClass = String.class, example = "Ingrese el token para iniciar")
	@DeleteMapping("/{id}")
	public void eliminarProducto(@PathVariable("id") int id)  { 	
		productoRepository.deleteById(id);
	}
	@ApiOperation(value = " Producto Creado", response = Iterable.class)
	@ApiResponses(value = {
	    @ApiResponse(code = 201, message = "Producto Creada correctamente"),
	    @ApiResponse(code = 403, message = "Está prohibido acceder al recurso al que intentabas acceder"),
	    @ApiResponse(code = 404, message = "El recurso que intentabas alcanzar no se encuentra  ")
	})
	@ApiImplicitParam(name = "Authorization", value = "Access Token", required = true, allowEmptyValue = false, paramType = "header", dataTypeClass = String.class, example = "Ingrese el token para iniciar")
    @PostMapping()
	public ResponseEntity <Object> crearProducto(@ModelAttribute("ProductoCreateDto")ProductoCreateDto productoCreateDto  ){
		ProductoEntity productoEntity = new   ProductoEntity();
		   productoEntity.setId(productoCreateDto.getId());
		   productoEntity.setProducto(productoCreateDto.getProducto());
		   productoEntity.setFecha(productoCreateDto.getFecha());
		   productoEntity.setCantidad(productoCreateDto.getCantidad());
		   productoEntity.setEstado(productoCreateDto.getEstado());
			ProductoEntity guardarProducto = productoRepository.save(productoEntity);
		   URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(guardarProducto.getId()).toUri();
		 
		return ResponseEntity.created(location).build();
	
	}
	
	@ApiOperation(value = " producto Editado ", response = Iterable.class)
	@ApiResponses(value = {
	    @ApiResponse(code = 200, message = "producto editado correctamente"),
	    @ApiResponse(code = 403, message = "Está prohibido acceder al recurso al que intentabas acceder"),
	    @ApiResponse(code = 404, message = "El recurso que intentabas alcanzar no se encuentra  ")
	})
	@ApiImplicitParam(name = "Authorization", value = "Access Token", required = true, allowEmptyValue = false, paramType = "header", dataTypeClass = String.class, example = "Ingrese el token para iniciar")
    @PutMapping("/{id}")
	public ResponseEntity<Object> editarproducto(@ModelAttribute("ProductoUpdateDto") ProductoUpdateDto productoUpdateDto , @PathVariable("id") int id) { 
	
		Optional<ProductoEntity> producto = productoRepository.findById(id);
		if (!producto.isPresent()) {
			return ResponseEntity.notFound().build();
			
		}
		ProductoEntity productoEntity= new ProductoEntity();
		productoEntity.setId(id);
		productoEntity.setProducto(productoUpdateDto.getProducto());
		productoEntity.setCantidad(productoUpdateDto.getCantidad());
		productoEntity.setEstado(productoUpdateDto.getEstado());
		productoEntity.setFecha(productoUpdateDto.getFecha());
		productoRepository.save(productoEntity);
		return ResponseEntity.status(200).build();
	}
	
	}
	
	
