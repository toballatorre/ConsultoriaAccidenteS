package cl.tinyprro.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.tinyprro.beans.Item;
import cl.tinyprro.beans.ItemRepository;

@Service
public class ItemImpl implements ItemService{

	@Autowired
	ItemRepository ir;
	
	@Override
	public Item getById(int id) {
		// TODO Auto-generated method stub
		return ir.findOne(id);
	}

	@Override
	public List<Item> getAll() {
		// TODO Auto-generated method stub
		return (List<Item>) ir.findAll();
	}

	@Override
	public void add(Item i) {
		// TODO Auto-generated method stub
		ir.save(i);
	}

	@Override
	public void edit(Item i) {
		// TODO Auto-generated method stub
		ir.save(i);
	}

	@Override
	public void delete(Item i) {
		// TODO Auto-generated method stub
		ir.delete(i);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		ir.delete(id);
	}

}
