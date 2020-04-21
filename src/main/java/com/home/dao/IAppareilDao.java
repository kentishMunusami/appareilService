package com.home.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.home.bean.Appareil;

public interface IAppareilDao extends JpaRepository<Appareil, Long> {

}
