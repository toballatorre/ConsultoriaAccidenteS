package cl.tinyprro.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.tinyprro.beans.CasoAsesoria;
import cl.tinyprro.beans.CasoAsesoriaRepository;

@Service
public class CasoAsesoriaImpl implements CasoAsesoriaService {

	@Autowired
	CasoAsesoriaRepository car;
	
	@Override
	public CasoAsesoria getById(int id) {
		return car.findOne(id);
	}

	@Override
	public List<CasoAsesoria> getAll() {
		return (List<CasoAsesoria>) car.findAll();
	}

	@Override
	public void add(CasoAsesoria ca) {
		car.save(ca);
	}

	@Override
	public void edit(CasoAsesoria ca) {
		car.save(ca);
	}

	@Override
	public void delete(CasoAsesoria ca) {
		car.delete(ca);
	}

	@Override
	public void delete(int id) {
		car.delete(id);
	}

}
