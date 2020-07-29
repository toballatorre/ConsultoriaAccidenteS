package cl.tinyprro.services;

import java.util.List;

import cl.tinyprro.beans.Admin;

public interface AdminService {
	
	Admin getById(int id);
	List<Admin> getAll();
	void add(Admin a);
	void edit(Admin a);
	void delete(Admin a);
	void delete(int id);
}
