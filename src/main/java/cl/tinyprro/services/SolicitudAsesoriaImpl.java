package cl.tinyprro.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.tinyprro.beans.SolicitudAsesoria;
import cl.tinyprro.beans.SolicitudAsesoriaReposotory;

@Service
public class SolicitudAsesoriaImpl implements SolicitudAsesoriaService {

	@Autowired
	SolicitudAsesoriaReposotory sar;
	
	@Override
	public SolicitudAsesoria getById(int id) {
		// TODO Auto-generated method stub
		return sar.findOne(id);
	}

	@Override
	public List<SolicitudAsesoria> getAll() {
		// TODO Auto-generated method stub
		return (List<SolicitudAsesoria>)sar.findAll();
	}

	@Override
	public void add(SolicitudAsesoria sa) {
		// TODO Auto-generated method stub
		sar.save(sa);
	}

	@Override
	public void edit(SolicitudAsesoria sa) {
		// TODO Auto-generated method stub
		sar.save(sa);
	}

	@Override
	public void delete(SolicitudAsesoria sa) {
		// TODO Auto-generated method stub
		sar.delete(sa);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		sar.delete(id);
	}

}
