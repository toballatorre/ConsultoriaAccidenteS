package cl.tinyprro.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.tinyprro.beans.Checklist;
import cl.tinyprro.beans.ChecklistRepository;

@Service
public class ChecklistImpl implements ChecklistService {

	@Autowired
	ChecklistRepository cr;
	
	@Override
	public Checklist getById(int id) {
		// TODO Auto-generated method stub
		return cr.findOne(id);
	}

	@Override
	public List<Checklist> getAll() {
		// TODO Auto-generated method stub
		return (List<Checklist>) cr.findAll();
	}

	@Override
	public void add(Checklist c) {
		// TODO Auto-generated method stub
		cr.save(c);
	}

	@Override
	public void edit(Checklist c) {
		// TODO Auto-generated method stub
		cr.save(c);
	}

	@Override
	public void delete(Checklist c) {
		// TODO Auto-generated method stub
		cr.delete(c);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		cr.delete(id);
	}

}
