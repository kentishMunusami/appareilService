package com.home.service;

import java.util.List;

import com.home.bean.Appareil;

public interface IAppareilService {
	
	public List<Appareil> getAppareils();
	
	public void saveAppareil(Appareil appareil);
	
	public void delete(int id);

}
