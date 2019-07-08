package com.fr.projetMedical.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fr.projetMedical.model.Facture;
import com.fr.projetMedical.repository.FactureRepository;

@Service
public class FactureService {
	
	@Autowired
	private FactureRepository factureRepository;

	@Transactional(readOnly = true)
	public List<Facture> findAll() {
		List<Facture> listeFactures = factureRepository.findAll();
		return listeFactures;
	}
	
	@Transactional(readOnly = true)
	public Facture findByIdFacture(Long id) {
		return factureRepository.findByIdFacture(id);
	}
	
	@Transactional
	public void add(Facture facture) {
		factureRepository.save(facture);
	}

	@Transactional
	public void addAll(Collection<Facture> factures) {
		for (Facture facture : factures) {
			factureRepository.save(facture);
		}
	}

	@Transactional
	public void update(Facture facture) {
		factureRepository.findByIdFacture(facture.getIdFacture()).setConsultation(facture.getConsultation());
		factureRepository.findByIdFacture(facture.getIdFacture()).setMontant(facture.getMontant());
		factureRepository.findByIdFacture(facture.getIdFacture()).setPayee(facture.isPayee());
	}

	@Transactional
	public void delete(Collection<Facture> factures) {
		for (Facture facture : factures) {
			factureRepository.delete(facture);
		}
	}

	@Transactional
	public void delete(Facture facture) {
		factureRepository.delete(facture);
	}
	
	@Transactional
	public void deleteById(Long factureId) {
		factureRepository.deleteById(factureId);
	}
	
	

}
