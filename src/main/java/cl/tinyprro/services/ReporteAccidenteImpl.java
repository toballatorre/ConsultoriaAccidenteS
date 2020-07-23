package cl.tinyprro.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.tinyprro.beans.ReporteAccidente;
import cl.tinyprro.beans.ReporteAccidenteRepository;

@Service
public class ReporteAccidenteImpl implements ReporteAccidenteService {

	@Autowired
	ReporteAccidenteRepository rar; 
	
	@Override
	public ReporteAccidente getById(int id) {
		// TODO Auto-generated method stub
		return rar.findOne(id);
	}

	@Override
	public List<ReporteAccidente> getAll() {
		
		return (List<ReporteAccidente>) rar.findAll();
	}
	/*
	 * @Override //!!!!!!!!!! public List<ReporteAccidente> getAllId(int id) {
	 * 
	 * return (List<ReporteAccidente>) rar.findAll(); }
	 */

	@Override
	public void add(ReporteAccidente r) {
		// TODO Auto-generated method stub
		rar.save(r);
	}

	@Override
	public void edit(ReporteAccidente r) {
		// TODO Auto-generated method stub
		rar.save(r);
	}

	@Override
	public void delete(ReporteAccidente r) {
		// TODO Auto-generated method stub
		rar.delete(r);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		rar.delete(id);
	}



}
