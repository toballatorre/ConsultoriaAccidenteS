package cl.tinyprro.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.tinyprro.beans.Factura;
import cl.tinyprro.beans.FacturaRepository;

@Service
public class FacturaImpl implements FacturaService {

	@Autowired
	FacturaRepository fr;
	
	@Override
	public Factura getById(int id) {
		// TODO Auto-generated method stub
		return fr.findOne(id);
	}

	@Override
	public List<Factura> getAll() {
		// TODO Auto-generated method stub
		return (List<Factura>) fr.findAll();
	
	}

	@Override
	public void add(Factura f) {
		// TODO Auto-generated method stub
		fr.save(f);
	}

	@Override
	public void edit(Factura f) {
		// TODO Auto-generated method stub
		fr.save(f);
	}

	@Override
	public void delete(Factura f) {
		// TODO Auto-generated method stub
		fr.delete(f);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		fr.delete(id);
	}

}
