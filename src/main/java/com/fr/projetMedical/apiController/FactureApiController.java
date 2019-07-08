package com.fr.projetMedical.apiController;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.TypeMap;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.MappingContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fr.projetMedical.dto.FactureDto;
import com.fr.projetMedical.model.Consultation;
import com.fr.projetMedical.model.Facture;
import com.fr.projetMedical.service.ConsultationService;
import com.fr.projetMedical.service.FactureService;

@RestController
@RequestMapping("/facture-api")
@CrossOrigin(origins = "http://localhost:4200")
public class FactureApiController {

	////////////////////////////////////////////////////////////////
	// Autowired :
	@Autowired(required = false)
	private ModelMapper modelMapper;
	
	@Autowired
	private FactureService factureService;
	
	@Autowired
	private ConsultationService consultationService;

	////////////////////////////////////////////////////////////////
	// Méthodes ModelMapper :
	private void definePropertyMap1() {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		TypeMap<Facture, FactureDto> typeMap = modelMapper.getTypeMap(Facture.class, FactureDto.class);
		if (typeMap == null) {
			modelMapper.addMappings(new PropertyMap<Facture, FactureDto>() {
				@Override
				protected void configure() {
					map().setIdFacture(source.getIdFacture());
					map().setMontant(source.getMontant());
					map().setPayee(source.isPayee());
					map().setIdPatient(source.getConsultation().getDossierPatient().getPatient().getIdPatient());
					map().setNomPatient(source.getConsultation().getDossierPatient().getPatient().getNom());
					map().setPrenomPatient(source.getConsultation().getDossierPatient().getPatient().getPrenom());
					map().setIdDossierPatient(source.getConsultation().getDossierPatient().getIdDossierPatient());
					map().setIdMedecin(source.getConsultation().getMedecin().getIdMedecin());
					map().setNomMedecin(source.getConsultation().getMedecin().getNom());
					map().setPrenomMedecin(source.getConsultation().getMedecin().getPrenom());
				}
			});
		}
	}

	private void definePropertyMap2() {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		TypeMap<FactureDto, Facture> typeMap = modelMapper.getTypeMap(FactureDto.class, Facture.class);
		if (typeMap == null) {
			
			Converter<Long, Consultation> converterIdConsultationToConsultation = new Converter<Long, Consultation>() {
				public Consultation convert(MappingContext<Long, Consultation> context) {
					return consultationService.findByIdConsultation(context.getSource());
				}
			};
			modelMapper.addConverter(converterIdConsultationToConsultation);
			
			modelMapper.addMappings(new PropertyMap<FactureDto, Facture>() {
				@Override
				protected void configure() {
					map().setIdFacture(source.getIdFacture());
					map().setMontant(source.getMontant());
					map().setPayee(source.isPayee());
					using(converterIdConsultationToConsultation).map(source.getIdConsultation(),destination.getConsultation());
				}
			});
		}
	}

	private FactureDto convertFactureToFactureDto(Facture facture) {
		definePropertyMap1();
		FactureDto factureDto = modelMapper.map(facture, FactureDto.class);
		return factureDto;
	}

	private List<FactureDto> convertFacturesToFacturesDto(List<Facture> listeFactures) {
		definePropertyMap1();
		List<FactureDto> listeFacturesDto = new ArrayList<FactureDto>();
		for (Facture a : listeFactures) {
			listeFacturesDto.add(convertFactureToFactureDto(a));
		}
		return listeFacturesDto;
	}

	private Facture convertFactureDtoToFacture(FactureDto factureDto) {
		definePropertyMap2();
		Facture facture = modelMapper.map(factureDto, Facture.class);
		return facture;
	}

	private List<Facture> convertFacturesDtoToFactures(List<FactureDto> listeFacturesDto) {
		definePropertyMap2();
		List<Facture> listeFactures = new ArrayList<Facture>();
		for (FactureDto a : listeFacturesDto) {
			listeFactures.add(convertFactureDtoToFacture(a));
		}
		return listeFactures;
	}

	////////////////////////////////////////////////////////////////
	// Méthodes Controller :
	@GetMapping("/list")
	public List<FactureDto> getFactures() {
		return convertFacturesToFacturesDto(factureService.findAll());
	}

	@GetMapping("/facture")
	public FactureDto getFacture(@RequestParam("idFacture") Long id) {
		return convertFactureToFactureDto(factureService.findByIdFacture(id));
	}

	@PostMapping(value = "/add")
	public ResponseEntity<FactureDto> addFacture(@RequestBody FactureDto factureDto) {
		Facture facture = convertFactureDtoToFacture(factureDto);
		factureService.add(facture);
		factureDto = convertFactureToFactureDto(factureService.findByIdFacture(facture.getIdFacture()));
		return new ResponseEntity<FactureDto>(factureDto, HttpStatus.OK);
	}

	@PutMapping(value = "/update")
	public ResponseEntity<FactureDto> updateFacture(@RequestBody FactureDto factureDto) {
		Facture facture = convertFactureDtoToFacture(factureDto);
		factureService.update(facture);
		factureDto = convertFactureToFactureDto(factureService.findByIdFacture(facture.getIdFacture()));
		return new ResponseEntity<FactureDto>(factureDto, HttpStatus.OK);
	}

	@PostMapping("/deleteList")
	public HttpStatus deleteListeFactures(@RequestBody List<FactureDto> listeFacturesDto) {
		List<Facture> listeFactures = convertFacturesDtoToFactures(listeFacturesDto);
		factureService.delete(listeFactures);
		return HttpStatus.OK;
	}

	@DeleteMapping("/delete")
	public HttpStatus deleteFactureById(@RequestParam("idFacture") Long id) {
		factureService.deleteById(id);
		return HttpStatus.OK;
	}

}
