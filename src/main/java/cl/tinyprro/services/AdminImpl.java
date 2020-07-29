package cl.tinyprro.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.tinyprro.beans.Admin;
import cl.tinyprro.beans.AdminRepositiry;

@Service
public class AdminImpl implements AdminService {

	@Autowired
	AdminRepositiry ar;
	
	@Override
	public Admin getById(int id) {
		// TODO Auto-generated method stub
		return ar.findOne(id);
	}

	@Override
	public List<Admin> getAll() {
		// TODO Auto-generated method stub
		return (List<Admin>) ar.findAll();
	}

	@Override
	public void add(Admin a) {
		// TODO Auto-generated method stub
		ar.save(a);
	}

	@Override
	public void edit(Admin a) {
		// TODO Auto-generated method stub
		ar.save(a);
	}

	@Override
	public void delete(Admin a) {
		// TODO Auto-generated method stub
		ar.delete(a);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		ar.delete(id);
	}

}
