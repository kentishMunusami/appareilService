package com.home.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.home.bean.Appareil;

public interface IAppareilDao extends JpaRepository<Appareil, Integer> {

}
