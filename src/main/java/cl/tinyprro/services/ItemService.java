package cl.tinyprro.services;

import java.util.List;

import cl.tinyprro.beans.Item;

public interface ItemService {

	Item getById(int id);
	List<Item> getAll();
	void add(Item i);
	void edit(Item i);
	void delete(Item i);
	void delete(int id);
}
