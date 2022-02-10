package com.example.demo.service;

import java.util.ArrayList;
import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.Categoria;
import com.example.demo.repository.CategoriaRepository;

@Service
@Transactional
public class CategoriaService {

	@Autowired
	private CategoriaRepository repo;
	
	private Collection<Categoria> itemCategoria = new ArrayList<>();
	
	@PostConstruct
	private void initData() {
		
		Categoria c1 = new Categoria("C001","Gorros Antifluidos","A","https://media.istockphoto.com/vectors/woman-doctor-in-surgical-mask-vector-id491310222?k=20&m=491310222&s=612x612&w=0&h=tRLHmXxZ3_kK9jcKNcSqDUKfL1S0RX7uYHVqohmEWRo=");
		Categoria c2 = new Categoria("C002","Cuidado Bucal","A","https://pagina-wv-django.s3.amazonaws.com/patrocina/donacion-causa/350x400-Kits-de-higiene-oral.png");
		Categoria c3 = new Categoria("C003","Alginatos","A" , "https://imfohsa.com/media/catalog/product/cache/e4d64343b1bc593f1c5348fe05efa4a6/m/j/mj-a3000.png");
		Categoria c4 = new Categoria("C004","Mascarillas","A", "https://images.vexels.com/media/users/3/234817/isolated/preview/a6588fa98bdfc11ff9e574bee5003251-ilustracion-de-mascarilla-desechable.png");
		Categoria c5 = new Categoria("C005","Anestesia Dental","A", "https://cdn-icons-png.flaticon.com/512/1741/1741086.png");
		Categoria c6 = new Categoria("C006","Resinas Dentales","A", "https://i.pinimg.com/originals/6e/e0/ef/6ee0ef37edae375b8306c872adb8115f.jpg");
		Categoria c7 = new Categoria("C007","Otros","A", "https://4.bp.blogspot.com/-d0WgO1Kipas/WcIqYUZ7F_I/AAAAAAAARI8/S_fPwdBB6IkiuWAPRjsPsOEozfsjtxphgCLcBGAs/s1600/tag-1.png");
		
		itemCategoria.add(c1);
		itemCategoria.add(c2);
		itemCategoria.add(c3);
		itemCategoria.add(c4);
		itemCategoria.add(c5);
		itemCategoria.add(c6);
		itemCategoria.add(c7);

	
		for(Categoria cat : itemCategoria) {
			saveCategoria(cat);
		}
	}
	
	
	
	public Categoria saveCategoria(Categoria newCategoria) {
		Categoria newCate = repo.save(newCategoria);
		return newCate;
	}
	
	
	public Collection<Categoria> findAll(){
		
		return (Collection<Categoria>)repo.findAll();
	}
	
	public void update(Categoria c){
		repo.save(c);
	}
	
	public void delete(String id) {
		repo.deleteById(id);
	}
	
	public Categoria findById(String id) {
		return repo.findById(id).orElse(null);
	}
}
