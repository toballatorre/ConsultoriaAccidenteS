package cl.tinyprro.services;

import java.util.List;

import cl.tinyprro.beans.Checklist;

public interface ChecklistService {
	
	Checklist getById(int id);
	List<Checklist> getAll();
	void add(Checklist c);
	void edit(Checklist c);
	void delete(Checklist c);
	void delete(int id);
}
