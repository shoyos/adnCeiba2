package adn.ceiba.consignataria.infraestructura.persistencia.repositorio;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import adn.ceiba.consignataria.dominio.repositorio.RepositorioMongoCliente;
import adn.ceiba.consignataria.infraestructura.persistencia.entidad.ClienteEntityMongo;

public class RepositorioClientePersistente implements RepositorioMongoCliente {

	@Override
	public <S extends ClienteEntityMongo> List<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ClienteEntityMongo> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ClienteEntityMongo> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends ClienteEntityMongo> S insert(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends ClienteEntityMongo> List<S> insert(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends ClienteEntityMongo> List<S> findAll(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends ClienteEntityMongo> List<S> findAll(Example<S> example, Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<ClienteEntityMongo> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public  <S extends ClienteEntityMongo> S save(S entity) {
		this.save(entity);
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<ClienteEntityMongo> findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existsById(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<ClienteEntityMongo> findAllById(Iterable<String> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteById(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(ClienteEntityMongo entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll(Iterable<? extends ClienteEntityMongo> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <S extends ClienteEntityMongo> Optional<S> findOne(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends ClienteEntityMongo> Page<S> findAll(Example<S> example, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends ClienteEntityMongo> long count(Example<S> example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <S extends ClienteEntityMongo> boolean exists(Example<S> example) {
		// TODO Auto-generated method stub
		return false;
	}
	



}
