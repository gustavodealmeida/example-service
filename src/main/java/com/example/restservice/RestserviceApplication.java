package com.example.restservice;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
public class RestserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestserviceApplication.class, args);
	}
}

class Estado{
	Long ID;
	String nome;
	
	public Estado(Long ID, String nome) {
		super();
		this.ID = ID;
		this.nome = nome;
	}
	
	public Long getID() {
		return ID;
	}
	public void setID(Long iD) {
		ID = iD;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
}

class Cidade{
	Long ID;
	String nome; 
	Estado estado;
	
	public Cidade(Long iD, String nome, Estado estado) {
		super();
		ID = iD;
		this.nome = nome;
		this.estado = estado;
	}
	
	public Long getID() {
		return ID;
	}
	public void setID(Long iD) {
		ID = iD;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Estado getEstado() {
		return estado;
	}
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
}

@RestController
class CidadeDAO{
	@PostMapping("/cidade")
	public Cidade create(@RequestBody Cidade cidade){

		return cidade;
	}

	@GetMapping("/cidade")
	public List<Cidade> read(){
		Estado e = new Estado(Long.valueOf(1),"Parana");
		Cidade c1 = new Cidade(Long.valueOf(1),"Cornelio Procopio",e);
		Cidade c2 = new Cidade(Long.valueOf(2),"Londrina", e);

		return Stream.of(c1,c2).collect(Collectors.toList());
	}

	@PutMapping("/cidade")
	public Cidade update(@RequestBody Cidade cidade){

		return cidade;
	}

	@DeleteMapping("/cidade/{id}")
	public int delete(@PathVariable Long id){
		
		return 200;
	}

}


